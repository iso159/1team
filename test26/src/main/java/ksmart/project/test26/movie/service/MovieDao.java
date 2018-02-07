package ksmart.project.test26.movie.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// @Repository를 적으면 객체가 미리 생성되서 MovieDao를 AutoWired로 객체에 주입할수있음
@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	// 쿼리 경로를 상수로 입력 
	private final String ns = "ksmart.project.test26.movie.service.MovieMapper.";
	
	// movie 테이블 전체 리스트 조회
	public List<Movie> selectMovieList(){
		// 아이디가 selectMovieList인 쿼리를 실행해 List<Movie>형태로 받은후 리턴
		List<Movie> list = sqlSessionTemplate.selectList(ns + "selectMovieList");
		// 콘솔창에 리턴 값 출력
		logger.debug("selectMovieList() 메서드 list is {}",list);
		return list;
	}
	
	// movie 테이블 컬럼 입력
	public void insertMovie(Movie movie) {
		logger.debug("insertMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 insertMovie인 쿼리를 실행해 매개변수 movie의 필드를 입력
		sqlSessionTemplate.insert(ns + "insertMovie",movie);
	}
	
	// movie 테이블 컬럼 결과 하나만 조회
	public Movie selectMovieOne(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("selectMovieOne(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 selectMovie인 쿼리를 실행해 결과를 Movie형태로 받은후 리턴
		Movie checkMovie = sqlSessionTemplate.selectOne(ns + "selectMovieOne", movie);
		// 리턴 값 확인
		logger.debug("selectMovieOne(Movie movie) 메서드 checkMovie is {}",checkMovie);		
		return checkMovie;
	}
	
	// movie 테이블 컬럼 수정
	public void updateMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("updateMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 movie_name컬럼을 매개변수 movie의 movieName필드값으로 수정
		sqlSessionTemplate.update(ns + "updateMovie", movie);
	}
	
	// movie 테이블 컬럼 삭제
	public void deleteMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("deleteMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 id와 같은 컬럼 삭제
		sqlSessionTemplate.delete(ns + "deleteMovie", movie);
	}
}
