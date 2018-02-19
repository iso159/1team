package ksmart.project.test26.idol.service;

public class IdolFile {
	private int idolFileId;
	private int idolId;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	public int getIdolFileId() {
		return idolFileId;
	}
	public void setIdolFileId(int idolFileId) {
		this.idolFileId = idolFileId;
	}
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
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
	
}
