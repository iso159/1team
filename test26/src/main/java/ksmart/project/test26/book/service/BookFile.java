package ksmart.project.test26.book.service;

public class BookFile {
	private int bookFileId;
	private int bookId;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	
	public int getBookFileId() {
		return bookFileId;
	}
	public void setBookFileId(int bookFileId) {
		this.bookFileId = bookFileId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "BookFile [bookFileId=" + bookFileId + ", bookId=" + bookId + ", fileName=" + fileName + ", fileExt="
				+ fileExt + ", fileSize=" + fileSize + "]";
	}
	
	
	
	
}
