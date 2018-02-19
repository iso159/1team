package ksmart.project.test26.idol.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class IdolCommand {
	private int idolId;
	private String idolTitle;
	private List<MultipartFile> file;
	
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
	}
	public String getIdolTitle() {
		return idolTitle;
	}
	public void setIdolTitle(String idolTitle) {
		this.idolTitle = idolTitle;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
}
