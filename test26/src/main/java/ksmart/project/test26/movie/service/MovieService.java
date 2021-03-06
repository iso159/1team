package ksmart.project.test26.movie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ksmart.project.test26.MovieController;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	public ModelAndView movieFileDownload(HttpServletRequest request,String path, String fileName, String fileExt) {
		logger.debug("movieFileDownload(String path, String fileName) 메서드 실행 paht is {}", path);
		logger.debug("movieFileDownload(String path, String fileName) 메서드 실행 fileName is {}", fileName);
		movieDao.movieFileDownload();
		// 경로 + 다운받을 파일이름을 file에 입력
		File file = new File(path+fileName);
		logger.debug("movieFileDownload(String path, String fileName) 메서드 실행 file is {}", file);
		// 입력한 파일을 읽을수 없다면 if블록실행
		if(!file.canRead()) {
			logger.debug("{} 파일을 찾지 못했습니다.",file);
			return new ModelAndView("fileDownloadView", "file",file);
		}
		// 원본 파일명 request에 셋팅
		request.setAttribute("fileName", fileName);
		// 확장자명을 더해서 파일 셋팅
		File reFile = new File(path+fileName+"."+fileExt);
		logger.debug("movieFileDownload(String path, String fileName) 메서드 실행 reFile is {}", reFile);
		try {
			// 파일이 있다면 if블록실행
			if(file.exists()) {
				// 확장자명을 더한 파일명으로 수정
				file.renameTo(reFile);
				// 확장자명을 더한 파일을 request에 셋팅
				request.setAttribute("reFile", reFile);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("fileDownloadView", "file",reFile);
	}
	
	public MovieAndMovieFile getMovieAndMovieFile(int movieId) {
		logger.debug("getMovieAndMovieFile(int movieId) 메서드 movieId is {}",movieId);
		MovieAndMovieFile movieAndMovieFile = movieDao.selectMovieAndMovieFile(movieId);
		logger.debug("getMovieAndMovieFile(int movieId) 메서드 movieAndMovieFile is {}",movieAndMovieFile);
		
		return movieAndMovieFile;
	}
	
	public List<Movie> getMovieList(){
		// 전체 영화 조회 메서드 호출 후 리턴 받음
		List<Movie> list = movieDao.selectMovieList();
		// 리턴받은 리스트 출력
		logger.debug("getMovieList() 메서드 list is {}",list);
		return list;
	}
	
	public void addMovie(MovieCommand movieCommand, String path,MultipartFile multiPartFile) {
		// 매개변수 movie 값 확인
		logger.debug("addMovie(MovieCommand movieCommand) 메서드 movieCommand is {}",movieCommand);
		// Movie 생성자로 객체 생성
		Movie movie = new Movie();
		// MovieCommand로 생성된 객체에 값 셋팅 
		movie.setMovieName(movieCommand.getMovieName());
		// movie 테이블 입력 메서드 호출하고 movieId 값을 리턴받음
		movieDao.insertMovie(movie);
		// movie에 입력한 마지막 키값을 조회하는 메서드 호출후 movieId에 리턴값 입력
		int movieId = movieDao.selectLastId();
		// lastId값 확인
		logger.debug("addMovie(MovieCommand movieCommand) 메서드 movieId is {}",movieId);
		// 폼에서 파일이 있을 경우 반복문을 실행  
		if(!multiPartFile.isEmpty()) {
			for(MultipartFile file : movieCommand.getFile()) {
				// MovieFile 객체 생성
				MovieFile movieFile = new MovieFile();
				// 중복되지 않을 random 파일이름 생성
				UUID uuid = UUID.randomUUID();
				// String타입으로 입력 받음
				String fileName = uuid.toString();
				// 확장자명까지 포함된 오리지널 파일 이름을 입력 받은후 콘솔창에 출력
				String originalFileName = file.getOriginalFilename();
				logger.debug("addMovie(MovieCommand movieCommand) 메서드 originalFileName is {}",originalFileName);
				// 마지막 .의 위치값을 pos에 입력하고 콘솔창에 출력
				int pos = originalFileName.lastIndexOf(".");
				logger.debug("addMovie(MovieCommand movieCommand) 메서드 pos is {}",pos);
				// 오리지널 파일이름의 마지막 .뒤 문자열을 가져와 fileExt에 입력후 콘솔창에 출력
				String fileExt = originalFileName.substring(pos+1);
				logger.debug("addMovie(MovieCommand movieCommand) 메서드 fileExt is {}",fileExt);
				// 파일의 크기를 fileSize에 입력후 콘솔창에 출력
				long fileSize = file.getSize();
				logger.debug("addMovie(MovieCommand movieCommand) 메서드 fileSize is {}",fileSize);
				
				// movieFile 객체에 필드를 셋팅해준후 insertMovieFile 메서드 호출
				movieFile.setMovieId(movieId);
				movieFile.setFileName(fileName);
				movieFile.setFileExt(fileExt);
				movieFile.setFileSize(fileSize);
				movieDao.insertMovieFile(movieFile);
				
				// 파일을 하드디스크에 저장할 경로 설정
				File temp = new File(path + fileName);
				
				// 빈 파일에 등록한 파일을 이동시킴
				try {
					file.transferTo(temp);
				} catch (IllegalStateException e) {
					// IllegalStateException 예외 발생시 처리
					e.printStackTrace();
					// temp 파일이 존재할경우 if 블록 실행
					if(temp.exists()) {
						// temp 파일 삭제 및 콘솔창으로 확인
						if(temp.delete()) {
							logger.debug("addMovie(MovieCommand movieCommand) 메서드 {} 파일 삭제 성공",temp);
						}else {
							logger.debug("addMovie(MovieCommand movieCommand) 메서드 {} 파일 삭제 실패",temp);
						}
					}
				} catch (IOException e) {
					// IOException 에외 발생시 처리
					e.printStackTrace();
					// temp 파일이 존재할경우 if 블록 실행
					if(temp.exists()) {
						// temp 파일 삭제 및 콘솔창으로 확인
						if(temp.delete()) {
							logger.debug("addMovie(MovieCommand movieCommand) 메서드 {} 파일 삭제 성공",temp);
						}else {
							logger.debug("addMovie(MovieCommand movieCommand) 메서드 {} 파일 삭제 실패",temp);
						}
					}
				}
			}
		}
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
	
	// movie_file 테이블 삭제 및 파일삭제후 movie 테이블 삭제
	public void removeMovie(int movieId, String path) {
		// 매개변수 movie 값 확인
		logger.debug("removeMovie(int movieId, String path) 메서드 movieId is {}",movieId);
		// 매개변수 Path 값 확인
		logger.debug("removeMovie(int movieId, String path) 메서드 path is {}",path);
		// movieId에 맞는 movie_file 테이블 조회
		List<MovieFile> list = movieDao.selectMovieFileByMovieId(movieId);
		// 조회결과가 null이 아니면 if블록 실행
		if(list != null) {
			for(MovieFile movieFile : list) {
				// 경로에 조회 결과로 얻은 파일이름을 결합 
				File temp = new File(path+movieFile.getFileName());
				// 파일이 있다면 if블록 실행
				if(temp.exists()) {
					// 파일이 삭제되면 if블록 실행 아니면 else 블록 실행
					if(temp.delete()) {
						// 파일 삭제 성공 debug 메시지
						logger.debug("removeMovie(int movieId, String path) 메서드 {} 파일 삭제 성공!",temp);
					}else {
						// 파일 삭제 실패 debug 메시지
						logger.debug("removeMovie(int movieId, String path) 메서드 {} 파일 삭제 실패!",temp);
					}
				}
			}			
			movieDao.deleteMovieFile(movieId);
		}
		// 영화 삭제 메서드 호출
		movieDao.deleteMovie(movieId);
	}
	
	public Map<String,Object> getListByPage(int currentPage, int rowPerPage, String searchWord){
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow, String searchWord) 메서드 currentPage is {}", currentPage);
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow, String searchWord) 메서드 rowPerPage is {}", rowPerPage);
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow, String searchWord) 메서드 rowPerPage is {}", searchWord);
		// startRow 선언
		int startRow = 0;
		// 현재페이지 * 보여줄 개수로 시작행을 구함
		startRow = (currentPage-1)*rowPerPage;
		// 매개변수로 넘길 map객체 생성
		Map map = new HashMap();
		// map에 startRow,pagePerRow를 매핑함
		map.put("startRow",startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);

		// 리턴할 맵객체 생성
		Map returnMap = new HashMap();
		// 총 행의 개수 조회 메서드 호출 및 totalCount에 입력
		int totalCount = movieDao.selectTotalCount(searchWord);
		// 페이지별로 보여줄 리스트 조회 메서드 호출
		List<Movie> list = movieDao.selectListByPerPage(map);
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 list is {}",list);
		
		logger.debug("Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 totalCount is {}",totalCount);
		// totalCount와 pagePerRow로 마지막 페이지를 구함
		int lastPage = (int)Math.ceil(((double)totalCount/(double)rowPerPage));
		logger.debug("Map<String,Object> getListByPage(int currentPage, int lastPage) 메서드 lastPage is {}",lastPage);
		// returnMap에 list와 lastPage를 매핑함
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalCount", totalCount);
		return returnMap;
	}
}
