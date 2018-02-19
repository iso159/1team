package ksmart.project.test26.city.service;

public class CityFile {
	private int cityFileId;
	private int cityId;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	
	public int getCityFileId() {
		return cityFileId;
	}
	public void setCityFileId(int cityFileId) {
		this.cityFileId = cityFileId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
		return "CityFile [cityFileId=" + cityFileId + ", cityId=" + cityId + ", fileName=" + fileName + ", fileExt="
				+ fileExt + ", fileSize=" + fileSize + "]";
	}
	
	
}
