package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookDao;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping(value="/book/bookList")
	public String BookList(Model model,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		List<Book> list = bookDao.selectBookList();
		model.addAttribute("list", list);
		return "book/bookList";
		
	}
	// 입력요청
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.POST)
	public String bookInsert(Book book,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		logger.info("입력요청확인 :{}", book);
		bookDao.insertBook(book);
		return "redirect:/book/bookList";	// 북 입력 후 "/book/bookList"로 redirect 요청
	}
	// 입력페이지요청
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.GET)
	public String bookInsert(HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		logger.debug("입력페이지 요청확인");
		return "/book/bookInsert";
	}
	
	// 삭제요청
	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		logger.debug("삭제 요청확인");
		bookDao.deleteBook(bookId);
		return "redirect:/book/bookList";
	}
	
	// 수정페이지 요청, 수정할 한 권조회
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
	public String bookOneSelect(Model model,@RequestParam(value="bookId", required=true) int bookId,HttpSession session ) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		logger.debug("수정페이지 요청확인");
		Book book = bookDao.selectOneBook(bookId);
		model.addAttribute("book", book);
		return "/book/bookUpdate";
	}
	
	// 수정요청
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.POST)
	public String bookUpdate(Book book,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect://login1team/login";
		}
		logger.info("수정요청확인 :{}", book);
		bookDao.updateBook(book);
		return "redirect:/book/bookList";
	}
	
}
