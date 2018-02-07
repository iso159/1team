package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	private CityDao citydao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	public List<City> checkCityList(){ //메서드생성
		
		List<City> list = citydao.selectCityList();//cityDao에 잇는 selectCityList()호출
		// 리턴받은 리스트 출력
		logger.debug("checkCityList() 메서드 list is {}",list);
		return list;
	}
	//city 삭제
	public void removeCity(int cityId) {
		
		logger.debug("removeCity(int cityId) 메서드 cityId is {}", cityId);
		citydao.deleteCity(cityId);
	}
	//city 수정
	public void modifyCity(City city) {
		
		logger.debug("modifyCity(City city) 메서드 city is {}",city);
		citydao.updateCity(city);
	}
	//city 추가
	public void addCity(City city) {
		
		logger.debug("addCity(City city) 메서드 city is {}",city);
		citydao.insertCity(city);
	}
	//한개도시조회
	public City checkCityOne(int cityId) {
		logger.debug("checkCityOne(int cityId) 메서드 cityId is {}", cityId);
		City onecity = citydao.selectCityOne(cityId);
		//리턴받은 도시출력
		logger.debug("checkCityOne(int cityId) 메서드 onecity is {}",onecity);
		return onecity; 
	}
}
