package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	private CityDao citydao;
	
	public List<City> checkCityList(){ //메서드생성
		
		return citydao.selectCityList();//cityDao에 잇는 selectCityList()호출
	}
	
	public void removeCity(int i) {
		
		citydao.deleteCity(i);
	}
	
	public void modifyCity(City city) {
		
		citydao.updateCity(city);
	}
	
	public int addCity(City city) {
		
		return citydao.insertCity(city);
	}
	
	public City checkCityOne(int i) {
		
		return citydao.selectCityOne(i);
	}
}
