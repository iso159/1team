package ksmart.project.test26.book.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart.project.test26.BookController;

@Service
@Transactional
public class BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	@Autowired
	private BookDao bookDao;
	
	
	// 페이징+검색
	public Map<String, Object> getListByPage(int currentPage, int rowPerPage, String SearchWord){
		logger.debug("getListByPage () 메서드");
		logger.debug("getListByPage(int currentPage, int pagePerRow, String SearchWord) 메서드 currentPage is {}", currentPage);
		logger.debug("getListByPage(int currentPage, int pagePerRow, String SearchWord) 메서드 rowPerPage is {}", rowPerPage);
		logger.debug("getListByPaㄴge(int currentPage, int pagePerRow, String SearchWord) 메서드 SearchWord is {}", SearchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("SearchWord", SearchWord);
		
		// 전체갯수
		int totalCount = bookDao.selectTotalCount(SearchWord);
		logger.debug("getListByPage () 메서드 totalCount is {}",totalCount);
		// 페이지당 보여줄 갯수+검색
		List<Book> list = bookDao.selectListByPerPage(map);
		logger.debug("getListByPage () 메서드 list is {}",list);
		// totalCount,rowPerPage로 마지막 페이지를 구함
		int lastPage = ((totalCount / rowPerPage) +1);
		logger.debug("getListByPage () 메서드 lastPage is {}",lastPage);
		
		// 매핑한 list,lastPage를 returnMap에 담고 리턴
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("SearchWord", SearchWord);
		returnMap.put("totalCount", totalCount);
		return returnMap;
	}
	
	
	// 전체조회
	public List<Book> getBookList (){
		logger.debug("getBookList () 메서드");
		List<Book> list = bookDao.selectBookList();
		logger.debug("getBookList () 메서드 list is {}",list);
		return list;
	}
	// 파일리스트조회
	public BookAndBookFile getBookFileList(int bookId) {
		BookAndBookFile bookAndBookFile = bookDao.selectBookAndBookFile(bookId);
		logger.debug("getBookFileList(int bookId) bookAndBookFile is {}",bookAndBookFile);
		return bookAndBookFile;
	}
	
	// 입력
	public void addBook(BookCommand bookCommand, String path)  {
		logger.debug("addBook(BookCommand bookCommand) 메서드 bookCommand is {}",bookCommand);
		Book book = new Book();
		book.setBookName(bookCommand.getBookName());
		bookDao.insertBook(book);
		int bookId = bookDao.selectLastId();
		
		for(MultipartFile file : bookCommand.getFile()) {
			// 1. db에 입력
			BookFile bookFile = new BookFile();
				UUID uuid = UUID.randomUUID();
				// 파일이름
				String fileName = uuid.toString();	// 중복되지않은 이름
				String originalName = file.getOriginalFilename();
				// 파일확장자
				int pos = originalName.lastIndexOf(".");
				String fileExt = originalName.substring(pos+1);
				// 파일크기
				long fileSize = file.getSize();
				// 값들을 셋팅 후 메소드 실행
				bookFile.setBookId(bookId);
				bookFile.setFileName(fileName);
				bookFile.setFileExt(fileExt);
				bookFile.setFileSize(fileSize);
				bookDao.insertBookFile(bookFile);
			
			// 2. 하드디스크에 파일저장
			File temp = new File(path+fileName);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				if(temp.exists()) {
					// temp 파일 삭제 및 콘솔창으로 확인
					if(temp.delete()) {
						logger.debug("addBook(BookCommand bookCommand) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addBook(BookCommand bookCommand) 메서드 {} 파일 삭제 실패",temp);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				if(temp.exists()) {
					// temp 파일 삭제 및 콘솔창으로 확인
					if(temp.delete()) {
						logger.debug("addBook(BookCommand bookCommand) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addBook(BookCommand bookCommand) 메서드 {} 파일 삭제 실패",temp);
					}
				}
			}
			
		}
	}
	// 삭제
	public void removeBook(int bookId) {
		logger.debug("removeBook(int bookId) 메서드 bookId is {}",bookId);
		bookDao.deleteBook(bookId);
	}
	
	// 수정할 한권 조회
	public Book getBookOne(int bookId) {
		logger.debug("getBookOne(int bookId) 메서드 bookId is {}",bookId);
		Book book = bookDao.selectBookOne(bookId);
		// 리턴값 확인
		logger.debug("getBookOne(int bookId) 메서드 book is {}",book);
		return book;
	}
	
	// 수정
	public void modifyBook(Book book) {
		logger.debug("modifyBook(Book book) 메서드 book is {}",book);
		bookDao.updateBook(book);
	}
	
}
