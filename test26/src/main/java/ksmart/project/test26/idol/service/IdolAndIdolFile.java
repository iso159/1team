package ksmart.project.test26.idol.service;

import java.util.List;

public class IdolAndIdolFile {
	private int idolId;
	private String idolName;
	private List<IdolFile> file;
	
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
	}
	public String getIdolName() {
		return idolName;
	}
	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}
	public List<IdolFile> getFile() {
		return file;
	}
	public void setFile(List<IdolFile> file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "IdolAndIdolFile [idolId=" + idolId + ", idolName=" + idolName + ", file=" + file + "]";
	}
	
}
