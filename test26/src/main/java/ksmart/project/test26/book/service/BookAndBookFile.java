package ksmart.project.test26.book.service;

import java.util.List;

public class BookAndBookFile {
	private int bookId;
	private String bookName;
	private List<BookFile> list;
	
	
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
	public List<BookFile> getList() {
		return list;
	}
	public void setList(List<BookFile> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "BookAndBookFile [bookId=" + bookId + ", bookName=" + bookName + ", list=" + list + "]";
	}
	
	
}
