package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.book.service.Book;
import ksmart.project.test26.book.service.BookDao;
import ksmart.project.test26.book.service.BookService;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;

	
	// Book전체 리스트(페이징)
	@RequestMapping(value="/book/bookList")
	public String Book(Model model,HttpSession session
			,@RequestParam(value="currentPage",defaultValue="1", required=false) int currentPage
			,@RequestParam(value="rowPerPage",defaultValue="10", required=false) int rowPerPage) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("Book 메서드 currentPage is {}",currentPage);
		logger.debug("Book 메서드 rowPerPage is {}",rowPerPage);
	
		// service에서 return받은 map을 형변환 후 값을 담는다.
		Map map = bookService.getListByPage(currentPage, rowPerPage);
		List<Book> list = (List<Book>)map.get("list");
		int lastPage = (Integer) map.get("lastPage");
		
		// model에 담는다.
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		return "/book/bookList";
		
	}
	// 입력요청
	@RequestMapping(value="/book/bookAdd", method = RequestMethod.POST)
	public String bookInsert(Book book,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.info("bookInsert(Book book,HttpSession session) 메서드 book is {}", book);
		bookService.addBook(book);
		return "redirect:/book/bookList";	// 북 입력 후 "/book/bookList"로 redirect 요청
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
	
	// 삭제요청
	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.info("bookDelete(int bookId,HttpSession session) 메서드 bookId is {}", bookId);
		bookService.removeBook(bookId);
		return "redirect:/book/bookList";
	}
	
	// 수정페이지 요청, 수정할 한 권조회
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
