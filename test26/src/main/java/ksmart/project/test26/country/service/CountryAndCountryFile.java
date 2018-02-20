package ksmart.project.test26.country.service;

import java.util.List;

// country JOIN country_file
public class CountryAndCountryFile {
	private int countryId;
	private String countryName;
	private List<CountryFile> list;

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

	public List<CountryFile> getList() {
		return list;
	}

	public void setList(List<CountryFile> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CountryAndCountryFile [countryId=" + countryId + ", countryName=" + countryName + ", list=" + list
				+ "]";
	}

}