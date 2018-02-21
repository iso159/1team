package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.book.service.Book;
import ksmart.project.test26.book.service.BookAndBookFile;
import ksmart.project.test26.book.service.BookCommand;
import ksmart.project.test26.book.service.BookDao;
import ksmart.project.test26.book.service.BookService;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;
	
	// Book전체 리스트(페이징+검색)
	@RequestMapping(value="/book/bookList")
	public String Book(Model model,HttpSession session
			,@RequestParam(value="currentPage",defaultValue="1", required=false) int currentPage
			,@RequestParam(value="rowPerPage",defaultValue="10", required=false) int rowPerPage
			,@RequestParam(value="SearchWord",defaultValue="", required=false) String SearchWord) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("Book 메서드 currentPage is {}",currentPage);
		logger.debug("Book 메서드 rowPerPage is {}",rowPerPage);
		logger.debug("Book 메서드 SearchWord is {}",SearchWord);
	
		// service에서 리턴받은 map(returnMap)을 형변환 후 값을 담는다.
		Map map = bookService.getListByPage(currentPage, rowPerPage, SearchWord);
		List<Book> list = (List<Book>)map.get("list");
		int lastPage = (Integer) map.get("lastPage");
		SearchWord = (String) map.get("SearchWord");
		int totalCount = (Integer) map.get("totalCount");
		
		// model에 담는다.
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("SearchWord", SearchWord);
		model.addAttribute("totalCount",totalCount);
		return "/book/bookList";
	
	}
	// Book 파일리스트
	@RequestMapping(value="/book/bookFileList")
	public String BookFile(@RequestParam(value="bookId", required=true) int bookId,HttpSession session, Model model) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("BookFile 메서드 bookId is {}",bookId);
		BookAndBookFile bookAndBookFile =  bookService.getBookFileList(bookId);
		logger.debug("BookFile 메서드 bookAndBookFile is {}",bookAndBookFile);
		model.addAttribute("bookAndBookFile", bookAndBookFile);
		return "/book/bookFileList";
	}
	
	// 입력페이지요청
	@RequestMapping(value="/book/bookAdd", method = RequestMethod.GET)
	public String bookInsert(HttpSession session) {
		logger.info("bookInsert(HttpSession session) 메서드");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		return "/book/bookAdd";
	}
	
	// 입력요청(파일추가)
	@RequestMapping(value="/book/bookAdd", method = RequestMethod.POST)
	public String bookInsert(Book book, HttpSession session, BookCommand bookCommand) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/upload/";
		logger.debug("bookInsert(Book book,HttpSession session) 메서드 path is {}",path);
		logger.debug("fileName :{}",bookCommand);
		logger.debug("filesize :{}",bookCommand.getFile().size());
		bookService.addBook(bookCommand, path);
		return "redirect:/book/bookList";	// 북 입력 후 "/book/bookList"로 redirect 요청
	}
		
	// 삭제요청
	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.info("bookDelete(int bookId,HttpSession session) 메서드 bookId is {}", bookId);
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/upload/";
		bookService.removeBook(bookId, path);
		return "redirect:/book/bookList";
	}
	
	// 수정페이지 요청, 수정할 한 권조회, 파일추가
	@RequestMapping(value="/book/bookModify", method = RequestMethod.GET)
	public String bookOneSelect(Model model,@RequestParam(value="bookId", required=true) int bookId,HttpSession session ) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		Book book = bookService.getBookOne(bookId);
		// 리턴받은 book값 확인
		logger.info("bookOneSelect(Model model,int bookId,HttpSession session) 메서드 book is {}", book);
		model.addAttribute("book", book);
		return "/book/bookModify";
	}
	
	// 수정요청
	@RequestMapping(value="/book/bookModify", method = RequestMethod.POST)
	public String bookUpdate(Book book,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.info("bookModify(Book book,HttpSession session) 메서드 book is {}", book);
		bookService.modifyBook(book);
		
		return "redirect:/book/bookList";
	}
	

}
