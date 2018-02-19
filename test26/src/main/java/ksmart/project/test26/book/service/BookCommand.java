package ksmart.project.test26.book.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BookCommand {
	private int bookId;
	private String bookName;
	private List<MultipartFile> file;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "BookCommand [bookId=" + bookId + ", bookName=" + bookName + ", file=" + file + "]";
	}
	
	
	
}
