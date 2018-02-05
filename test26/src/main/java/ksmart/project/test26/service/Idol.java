package ksmart.project.test26.service;

import org.springframework.stereotype.Repository;

public class Idol {
	private int idolId;
	private String idolName;
	
	public Idol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Idol(int idolId, String idolName) {
		super();
		this.idolId = idolId;
		this.idolName = idolName;
	}

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

	@Override
	public String toString() {
		return "Idol [idolId=" + idolId + ", idolName=" + idolName + "]";
	}

}
