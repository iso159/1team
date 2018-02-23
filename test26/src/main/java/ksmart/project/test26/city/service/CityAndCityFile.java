package ksmart.project.test26.city.service;

import java.util.List;

// country JOIN country_file
public class CityAndCityFile {
	private int cityId;
	private String cityName;
	private List<CityFile> list;

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

	public List<CityFile> getList() {
		return list;
	}

	public void setList(List<CityFile> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CityAndCityFile [cityId=" + cityId + ", cityName=" + cityName + ", list=" + list + "]";
	}

}