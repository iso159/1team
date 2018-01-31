package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// @Repository를 적으면 객체가 미리 생성되서 MovieDao를 AutoWired로 객체에 주입할수있음
@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 쿼리 경로를 상수로 입력 
	private final String str = "ksmart.project.test26.service.MovieMapper.";
	public List<Movie> selectMovieList(){
		// 아이디가 selectMovieList인 쿼리를 실행해 List<Movie>형태로 받은후 리턴
		return sqlSessionTemplate.selectList(str + "selectMovieList");
	}
}
