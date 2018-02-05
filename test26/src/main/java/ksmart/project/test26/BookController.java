package ksmart.project.test26;

import java.util.List;

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
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping(value="/book/bookList")
	public String BookList(Model model) {
		List<Book> list = bookDao.selectBookList();
		model.addAttribute("list", list);
		return "book/bookList";
		
	}
	// 입력요청
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.POST)
	public String bookInsert(Book book) {
		System.out.println(book);
		bookDao.insertBook(book);
		return "redirect:/book/bookList";	// 북 입력 후 "/book/bookList"로 redirect 요청
	}
	// 입력페이지요청
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.GET)
	public String bookInsert() {
		System.out.println("입력페이지요청 확인");
		return "/book/bookInsert";
	}
	
	// 삭제요청
	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId) {
		System.out.println("삭제 요청 확인");
		bookDao.deleteBook(bookId);
		return "redirect:/book/bookList";
	}
	
	// 수정페이지 요청, 수정할 한 권조회
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
	public String bookOneSelect(Model model,@RequestParam(value="bookId", required=true) int bookId ) {
		System.out.println("수정페이지요청 확인");
		List<Book> list = bookDao.selectOneBook(bookId);
		model.addAttribute("list", list);
		return "/book/bookUpdate";
	}
	
	// 수정요청
	
}
