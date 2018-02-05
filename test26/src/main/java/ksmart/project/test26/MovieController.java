package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	// /movie/movieList 요청시 movie메서드 호출됨
	@RequestMapping(value="/movie/movieList")
	public String movie(Model model) {
		List<Movie> list = movieDao.selectMovieList();
		// request.setAttribute와 비슷함 forward한 곳에서도 객체를 사용할수 있게해줌
		model.addAttribute("MovieList",list);
		return "/movie/movieList";
	}
	
	// /movie/movieAdd get방식으로 요청시 movieAdd메서드 호출됨
	@RequestMapping(value="/movie/movieAdd", method = RequestMethod.GET)
	public String movieAdd() {
		// 입력 폼으로 이동
		return "/movie/movieAdd";
	}
	
	// /movie/movieAdd post방식으로 요청시 movieAdd메서드 호출됨
	@RequestMapping(value="/movie/movieAdd", method = RequestMethod.POST)
	public String movieAdd(Movie movie) {
		// movie dto에 값이 잘들어갔는지 콘솔창으로 확인
		System.out.println(movie);
		// 입력 메소드 호출
		movieDao.insertMovie(movie);
		return "redirect:/movie/movieList";
	}
}
