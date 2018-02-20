package ksmart.project.test26.book.service;

import java.util.List;
import java.util.Map;

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
	private final String nameSpace = "ksmart.project.test26.book.service.BookMapper."; // namespace

	// Book 총 갯수
	public int selectTotalCount(String SearchWord) {
		logger.debug("selectTotalCount 메서드");
		return sqlSessionTemplate.selectOne(nameSpace + "selectTotalCount", SearchWord);
	}
	
	// 페이지당 보여줄 리스트 갯수+검색
	public List<Book> selectListByPerPage(Map map){
		logger.debug("selectListByPerPage(Map map) 메서드 map is {}",map);
		return sqlSessionTemplate.selectList(nameSpace + "selectListByPerPage", map);
	}
	
	// Book 리스트 보여주는 메소드
	public List<Book> selectBookList(){
		return sqlSessionTemplate.selectList(nameSpace + "selectBookList");
	}
	// Book 파일 리스트 보여주는 메소드
	public BookAndBookFile selectBookAndBookFile(int bookId){
		logger.debug("selectBookAndBookFile(int bookId) 메서드 bookId is {}",bookId);
		return sqlSessionTemplate.selectOne(nameSpace + "selectBookAndBookFile", bookId);
	}
	
	// Book 입력 메소드
	public void insertBook(Book book) {
		logger.debug("insertBook(Book book) 메서드 book is {}",book);
		sqlSessionTemplate.insert(nameSpace + "insertBook", book);
	}
	
	// 마지막으로 입력된 ID값 조회
	public int selectLastId() {
		int lastId = sqlSessionTemplate.selectOne(nameSpace+"selectLastId");
		logger.debug("selectLastId() 메서드 lastId is {}",lastId);
		return lastId;
	}
		
	// Book 파일 입력 메소드
	public int insertBookFile(BookFile bookFile) {
		logger.debug("insertBookFile(BookFile bookFile) 메서드 bookFile is {}",bookFile);
		return sqlSessionTemplate.insert(nameSpace + "insertBookFile", bookFile);
	}
	
	// Book 삭제 메소드
	public void deleteBook(int bookId) {
		logger.debug("deleteBook(int bookId) 메서드 bookId is {}",bookId);
		sqlSessionTemplate.delete(nameSpace + "deleteBook", bookId);
	}
	
	// Book 한 권 조회 메소드
	public Book selectBookOne(int bookId){
		logger.debug("selectBookOne(int bookId) 메서드 bookId is {}",bookId);
		return sqlSessionTemplate.selectOne(nameSpace + "selectBookOne", bookId);
	}
	
	// Book 한 권 조회 후 수정 처리 메소드
	public void updateBook(Book book) {
		logger.debug("updateBook(Book book) 메서드 book is {}",book);
		sqlSessionTemplate.selectList(nameSpace + "updateBook", book);
	}
}
