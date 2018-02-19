package ksmart.project.test26.city.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CityCommand {
	private int cityId;
	private String cityName;
	private List<MultipartFile> file;
	
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "CityCommand [cityId=" + cityId + ", cityName=" + cityName + ", file=" + file + "]";
	}
	
	
	
}
