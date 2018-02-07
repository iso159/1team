package ksmart.project.test26.book.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.project.test26.BookController;

@Service
public class BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	@Autowired
	private BookDao bookDao;
	
	// 전체조회
	public List<Book> checkBookList (){
		logger.debug("checkBookList () 메서드");
		List<Book> list = bookDao.selectBookList();
		logger.debug("checkBookList () 메서드 list is {}",list);
		return list;
	}
	
	// 입력
	public void addBook(Book book) {
		logger.debug("addBook(Book book) 메서드 book is {}",book);
		bookDao.insertBook(book);
	}
	// 삭제
	public void removeBook(int bookId) {
		logger.debug("removeBook(int bookId) 메서드 bookId is {}",bookId);
		bookDao.deleteBook(bookId);
	}
	
	// 수정할 한권 조회
	public Book checkBookOne(int bookId) {
		logger.debug("checkBookOne(int bookId) 메서드 bookId is {}",bookId);
		Book book = bookDao.selectBookOne(bookId);
		// 리턴값 확인
		logger.debug("checkBookOne(int bookId) 메서드 book is {}",book);
		return book;
	}
	
	// 수정
	public void modifyBook(Book book) {
		logger.debug("modifyBook(Book book) 메서드 book is {}",book);
		bookDao.updateBook(book);
	}
	
}
