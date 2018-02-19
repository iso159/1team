package ksmart.project.test26.movie.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MovieCommand {
	private int movieId;
	private String movieName;
	private List<MultipartFile> file;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "MovieCommand [movieId=" + movieId + ", movieName=" + movieName + ", file=" + file + "]";
	}
	
}
