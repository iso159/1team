package ksmart.project.test26.country.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CountryCommand {
	private int countryId;
	private String countryName;
	private List<MultipartFile> file;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "CountryCommand [countryId=" + countryId + ", countryName=" + countryName + ", file=" + file + "]";
	}

}
