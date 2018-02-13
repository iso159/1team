package ksmart.project.test26.city.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {

	@Autowired
	private CityDao citydao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	public List<City> getCityList(){ //메서드생성
		
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
	public City getCityOne(int cityId) {
		logger.debug("getCityOne(int cityId) 메서드 cityId is {}", cityId);
		City onecity = citydao.selectCityOne(cityId);
		//리턴받은 도시출력
		logger.debug("checkCityOne(int cityId) 메서드 onecity is {}",onecity);
		return onecity; 
	}
	
	//Map<String, Object> int로 받을 수없기 때문에 Object로 받는다
	public Map<String,Object> getListByPage(int currentPage, int rowPerPage){
		logger.debug("getListByPage(int currentPage, int pagePerRow)메서드 currentPage is {}", currentPage);
		logger.debug("getListByPage(int currentPage, int pagePerRow)메서드 rowPerPage is {}", rowPerPage);
		//startRow선언
		int startRow = 0;
		//현재페이지 * 보여줄 개수로 시작행 구함
		startRow = (currentPage-1)*rowPerPage;
		//매개변수를 넘길 map객체 생성
		Map map = new HashMap();
		//map에 startRow, pagePerRow를 매핑함
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		
		//리턴할 맵객체 생성
		Map returnMap = new HashMap();
		//페이지별로 보여줄 리스트 조회 메서드 호출
		List<City> list = citydao.selectListByPerPage(map);
		logger.debug("getListByPage(int currentPage, int rowPerPage)메서드 List is {}", list);
		//총 행의 개수 조회 메서드 호출 및 totalCount에 입력
		int totalCount = citydao.selectTotalCount();
		logger.debug("getListByPage(int currentPage, int rowPerPage)메서드 totalCount is {}", totalCount);
		//totalCount와 pagePerRow로 마지막 페이지를 구함
		int lastPage = (int)Math.ceil(totalCount/rowPerPage);
		logger.debug("getListByPage(int currentPage, int rowPerPage)메서드 lastPage is {}", lastPage);
		
		//returnMap에 list와 lastPage를 매핑함
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
}
