package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String NS = "ksmart.project.test26.service.BookMapper."; // namespace
	
	public List<Book> selectBookList(){
		
		return sqlSessionTemplate.selectList(NS+"selectBookList");
	}
	
	// Book 입력 메소드
	public void insertBook(Book book) {
		System.out.println("insert메소드 확인");
		sqlSessionTemplate.insert(NS+"insertBook", book);
	}
}
