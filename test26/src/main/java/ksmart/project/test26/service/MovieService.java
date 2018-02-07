package ksmart.project.test26.service;

import java.util.List;

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
	
	public List<Movie> checkMovieList(){
		// 전체 영화 조회 메서드 호출 후 리턴 받음
		List<Movie> list = movieDao.selectMovieList();
		// 리턴받은 리스트 출력
		logger.debug("checkMovieList() 메서드 list is {}",list);
		return list;
	}
	
	public void addMovie(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("addMovie(Movie movie) 메서드 movie is {}",movie);
		// 입력 메서드 호출
		movieDao.insertMovie(movie);
	}
	
	public Movie checkMovieOne(Movie movie) {
		// 매개변수 movie 값 확인
		logger.debug("checkMovieOne(Movie movie) 메서드 movie is {}",movie);
		Movie checkMovie = movieDao.selectMovieOne(movie);
		// 리턴값 확인
		logger.debug("checkMovieOne(Movie movie) 메서드 checkMovie is {}",checkMovie);
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
}
