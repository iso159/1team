package ksmart.project.test26.movie.service;

import java.util.List;
import java.util.Map;

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
	private final String nameSpace = "ksmart.project.test26.movie.service.MovieMapper.";
	
	// movie 테이블과 movieFile 조인 결과 조회
	public MovieAndMovieFile selectMovieAndMovieFile(int movieId) {
		logger.debug("selectMovieAndMovieFile(int movieId) 메서드 movieId is {}", movieId);
		MovieAndMovieFile movieAndMovieFile = sqlSessionTemplate.selectOne(nameSpace + "selectMovieAndMovieFile", movieId);
		logger.debug("selectMovieAndMovieFile(int movieId) 메서드 movieAndMovieFile is {}", movieAndMovieFile);
		return movieAndMovieFile;
	}
	
	// 마지막 입력된 id값 조회
	public int selectLastId() {
		int lastId = sqlSessionTemplate.selectOne(nameSpace+"selectLastId");
		logger.debug("selectLastId() 메서드 lastId is {}",lastId);
		return lastId;
	}
	
	// movieFile 테이블 컬럼 입력
	public void insertMovieFile(MovieFile movieFile) {
		logger.debug("insertMovieFile(MovieFile movieFile) 메서드 movieFile is {}",movieFile);
		sqlSessionTemplate.insert(nameSpace + "insertMovieFile", movieFile);
	}
	
	// movie 테이블 전체 리스트 조회
	public List<Movie> selectMovieList(){
		// 아이디가 selectMovieList인 쿼리를 실행해 List<Movie>형태로 받은후 리턴
		List<Movie> list = sqlSessionTemplate.selectList(nameSpace + "selectMovieList");
		// 콘솔창에 리턴 값 출력
		logger.debug("selectMovieList() 메서드 list is {}",list);
		return list;
	}
	
	// movie 테이블 컬럼 입력
	public void insertMovie(Movie movie) {
		logger.debug("insertMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 insertMovie인 쿼리를 실행해 매개변수 movie의 필드를 입력
		sqlSessionTemplate.insert(nameSpace + "insertMovie",movie);
	}
	
	// movie 테이블 컬럼 결과 하나만 조회
	public Movie selectMovieOne(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("selectMovieOne(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 selectMovie인 쿼리를 실행해 결과를 Movie형태로 받은후 리턴
		Movie checkMovie = sqlSessionTemplate.selectOne(nameSpace + "selectMovieOne", movie);
		// 리턴 값 확인
		logger.debug("selectMovieOne(Movie movie) 메서드 checkMovie is {}",checkMovie);		
		return checkMovie;
	}
	
	// movie 테이블 컬럼 수정
	public void updateMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("updateMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 movie_name컬럼을 매개변수 movie의 movieName필드값으로 수정
		sqlSessionTemplate.update(nameSpace + "updateMovie", movie);
	}
	
	// movie 테이블 컬럼 삭제
	public void deleteMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("deleteMovie(Movie movie) 메서드 movie is {}",movie);
		// 아이디가 updateMovie인 쿼리를 실행해 movie필드의 id와 같은 컬럼 삭제
		sqlSessionTemplate.delete(nameSpace + "deleteMovie", movie);
	}
	
	// movie 테이블 현재 페이지에 맞는 리스트 조회
	public List<Movie> selectListByPerPage(Map map){
		logger.debug("selectListByPerPage(Map map) 메서드 map is {}",map);
		List<Movie> list = sqlSessionTemplate.selectList(nameSpace + "selectListByPerPage", map);
		logger.debug("selectListByPerPage(Map map) 메서드 list is {}",list);
		return list;
	}
	
	// movie 테이블 총 행의 개수 조회
	public int selectTotalCount(String searchWord) {
		logger.debug("selectTotalCount() 메서드 map is {}", searchWord);
		int totalCount = sqlSessionTemplate.selectOne(nameSpace + "selectTotalCount",searchWord);
		logger.debug("selectTotalCount() 메서드 totalCount is {}", totalCount);
		return totalCount;
	}
}
