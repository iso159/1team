package ksmart.project.test26.movie.service;

import java.util.List;

public class MovieAndMovieFile {
	private int movieId;
	private String movieName;
	private List<MovieFile> list;
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
	public List<MovieFile> getList() {
		return list;
	}
	public void setList(List<MovieFile> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "MovieAndMovieFile [movieId=" + movieId + ", movieName=" + movieName + ", list=" + list + "]";
	}
	
}
