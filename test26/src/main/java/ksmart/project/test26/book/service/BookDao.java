package ksmart.project.test26.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.BookController;

@Repository
public class BookDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
	private final String NS = "ksmart.project.test26.book.service.BookMapper."; // namespace

	// Book 리스트 보여주는 메소드
	public List<Book> selectBookList(){
		return sqlSessionTemplate.selectList(NS+"selectBookList");
	}
	
	// Book 입력 메소드
	public void insertBook(Book book) {
		logger.debug("insertBook(Book book) 메서드 book is {}",book);
		sqlSessionTemplate.insert(NS+"insertBook", book);
	}
	
	// Book 삭제 메소드
	public void deleteBook(int bookId) {
		logger.debug("deleteBook(int bookId) 메서드 bookId is {}",bookId);
		sqlSessionTemplate.delete(NS+"deleteBook", bookId);
	}
	
	// Book 한 권 조회 메소드
	public Book selectBookOne(int bookId){
		logger.debug("selectBookOne(int bookId) 메서드 bookId is {}",bookId);
		return sqlSessionTemplate.selectOne(NS+"selectBookOne", bookId);
	}
	
	// Book 한 권 조회 후 수정 처리 메소드
	public void updateBook(Book book) {
		logger.debug("updateBook(Book book) 메서드 book is {}",book);
		sqlSessionTemplate.selectList(NS+"updateBook", book);
	}
}
