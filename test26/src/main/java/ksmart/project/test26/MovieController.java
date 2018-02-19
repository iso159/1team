package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.movie.service.Movie;
import ksmart.project.test26.movie.service.MovieCommand;
import ksmart.project.test26.movie.service.MovieDao;
import ksmart.project.test26.movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	// /movie/movieList 요청시 movie메서드 호출됨
	@RequestMapping(value="/movie/movieList")
	public String movie(Model model,HttpSession session
							,@RequestParam(value="currentPage",defaultValue="1",required=false) int currentPage
							,@RequestParam(value="rowPerPage",defaultValue="10",required=false) int rowPerPage
							,@RequestParam(value="searchWord",required=false) String searchWord) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("movie(...)메서드 currentPage is {}",currentPage);
		logger.debug("movie(...)메서드 pagePerRow is {}",rowPerPage);
		logger.debug("movie(...)메서드 searchWord is {}",searchWord);
		Map map = movieService.getListByPage(currentPage, rowPerPage,searchWord);
		// map에서 형변환으로 list와 lastPage변수를 꺼내 값을 입력 받음
		List<Movie> list = (List<Movie>)map.get("list");
		int lastPage = (Integer)map.get("lastPage");
		int totalCount = (Integer)map.get("totalCount");
		// list,lastPage,currentPage,rowPerPage model에 담음
		model.addAttribute("MovieList",list);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("rowPerPage",rowPerPage);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("searchWord",searchWord);
		return "/movie/movieList";
	}
	
	// /movie/movieAdd get방식으로 요청시 movieAdd()메서드 호출됨
	@RequestMapping(value="/movie/movieAdd", method = RequestMethod.GET)
	public String movieAdd(HttpSession session) {
		// 메서드 확인
		logger.debug("movieAdd(HttpSession session) 메서드");
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// 입력 폼으로 이동
		return "/movie/movieAdd";
	}
	
	// /movie/movieAdd post방식으로 요청시 movieAdd(Movie movie)메서드 호출됨
	@RequestMapping(value="/movie/movieAdd", method = RequestMethod.POST)
	public String movieAdd(MovieCommand movieCommand, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// 매개변수 movie 확인
		logger.debug("movieAdd(Movie movie, HttpSession session) 메서드 movieCommand is {}",movieCommand);
		// 입력 서비스 메서드 호출
		movieService.addMovie(movieCommand);
		return "redirect:/movie/movieList";
	}
	
	// /movie/movieModify get방식으로 요청시 movieModify(Model model) 메소드 호출됨
	@RequestMapping(value="/movie/movieModify", method = RequestMethod.GET)
	public String movieModify(Model model, Movie movie, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// 매개변수 movie 값 확인
		logger.debug("movieModify(Model model, Movie movie, HttpSession session) 메서드 movie is {}",movie);		
		// movieService.checkMovieOne(movie)의 결과를 받는다.
		Movie checkMovie = movieService.getMovieOne(movie);
		// 영화 하나를 조회하는 서비스 메서드 호출후 리턴 값 확인
		logger.debug("movieModify(Model model, Movie movie, HttpSession session) 메서드 checkMovie is {}",checkMovie);
		// Movie라는 키에 checkMovie 값을 담는다.
		model.addAttribute("Movie",checkMovie);
		return "/movie/movieModify";
	}
	
	// /movie/movieModify post방식으로 요청시 movieModify(Movie movie, HttpSession session) 메소드 호출됨
	@RequestMapping(value="/movie/movieModify", method = RequestMethod.POST)
	public String movieModify(Movie movie, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// 매개변수 movie 값 확인
		logger.debug("movieModify(Movie movie, HttpSession session) 메서드 movie is {}",movie);
		// 영화를 수정하는 서비스 메서드 호출
		movieService.modifyMovie(movie);
		return "redirect:/movie/movieList";
	}
	
	// /movie/movieRemove get방식으로 요청시 movieRemove(Movie movie) 메소드 호출됨
	@RequestMapping(value="/movie/movieRemove", method = RequestMethod.GET)
	public String movieRemove(Movie movie, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// 매개변수 movie 값 확인
		logger.debug("movieRemove(Movie movie, HttpSession session) 메서드 movie is {}",movie);
		// 영화 삭제 서비스 메서드 호출
		movieService.removeMovie(movie);
		return "redirect:/movie/movieList";
	}
}
