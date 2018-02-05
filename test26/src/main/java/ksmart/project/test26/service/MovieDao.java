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
	private final String ns = "ksmart.project.test26.service.MovieMapper.";
	
	// movie 테이블 전체 리스트 조회
	public List<Movie> selectMovieList(){
		// 아이디가 selectMovieList인 쿼리를 실행해 List<Movie>형태로 받은후 리턴
		return sqlSessionTemplate.selectList(ns + "selectMovieList");
	}
	
	// movie 테이블 컬럼 입력
	public void insertMovie(Movie movie) {
		// 아이디가 insertMovie인 쿼리를 실행해 매개변수 movie의 필드를 입력
		sqlSessionTemplate.insert(ns + "insertMovie",movie);
	}
	
	// movie 테이블 컬럼 결과 하나만 조회
	public Movie selectMovie(Movie movie) {
		// 아이디가 selectMovie인 쿼리를 실행해 결과를 Movie형태로 받은후 리턴
		return sqlSessionTemplate.selectOne(ns + "selectMovie", movie);
	}
	
	// movie 테이블 컬럼 수정
	public void updateMovie(Movie movie) {
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 movie_name컬럼을 매개변수 movie의 movieName필드값으로 수정
		sqlSessionTemplate.update(ns + "updateMovie", movie);
	}
	
	// movie 테이블 컬럼 삭제
	public void deleteMovie(Movie movie) {
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 id와 같은 컬럼 삭제
		sqlSessionTemplate.delete(ns + "deleteMovie", movie);
	}
}
