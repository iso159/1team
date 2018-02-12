package ksmart.project.test26.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.project.test26.MovieController;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	public List<Movie> getMovieList(){
		// 전체 영화 조회 메서드 호출 후 리턴 받음
		List<Movie> list = movieDao.selectMovieList();
		// 리턴받은 리스트 출력
		logger.debug("getMovieList() 메서드 list is {}",list);
		return list;
	}
	
	public void addMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("addMovie(Movie movie) 메서드 movie is {}",movie);
		// 입력 메서드 호출
		movieDao.insertMovie(movie);
	}
	
	public Movie getMovieOne(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("getMovieOne(Movie movie) 메서드 movie is {}",movie);
		Movie checkMovie = movieDao.selectMovieOne(movie);
		// 리턴값 확인
		logger.debug("getMovieOne(Movie movie) 메서드 checkMovie is {}",checkMovie);
		return checkMovie;
	}
	
	public void modifyMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("modifyMovie(Movie movie) 메서드 movie is {}",movie);
		// 영화 수정 메서드 호출
		movieDao.updateMovie(movie);
	}
	
	public void removeMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("removeMovie(Movie movie) 메서드 movie is {}",movie);
		// 영화 삭제 메서드 호출
		movieDao.deleteMovie(movie);
	}
	
	public Map<String,Object> getListByPage(int currentPage, int rowPerPage){
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 currentPage is {}", currentPage);
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 rowPerPage is {}", rowPerPage);
		// startRow 선언
		int startRow = 0;
		// 현재페이지 * 보여줄 개수로 시작행을 구함
		startRow = (currentPage-1)*rowPerPage;
		// 매개변수로 넘길 map객체 생성
		Map map = new HashMap();
		// map에 startRow,pagePerRow를 매핑함
		map.put("startRow",startRow);
		map.put("rowPerPage", rowPerPage);
		
		// 리턴할 맵객체 생성
		Map returnMap = new HashMap();
		// 페이지별로 보여줄 리스트 조회 메서드 호출
		List<Movie> list = movieDao.selectListByPerPage(map);
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 list is {}",list);
		// 총 행의 개수 조회 메서드 호출 및 totalCount에 입력
		int totalCount = movieDao.selectTotalCount();
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 totalCount is {}",totalCount);
		// totalCount와 pagePerRow로 마지막 페이지를 구함
		int lastPage = (int)Math.ceil(((double)totalCount/(double)rowPerPage));
		logger.debug("Map<String,Object> getListByPage(int currentPage, int lastPage) 메서드 totalCount is {}",lastPage);
		// returnMap에 list와 lastPage를 매핑함
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
}
