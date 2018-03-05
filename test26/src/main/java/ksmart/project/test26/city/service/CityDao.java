package ksmart.project.test26.city.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.city.service.CityAndCityFile;


@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
	
	private final String nameSpace = "ksmart.project.test26.city.service.CityMapper.";
	
	public List<City> selectCityList(){
		List<City> list = sqlSessionTemplate.selectList(nameSpace + "selectCityList");
		//콘솔창에서 list에 들어있는값 확인
		logger.debug("selectCityList() 메서드 list is {}",list);
		return list;
	}
	//city삭제
	public void deleteCity(int cityId) {
		//int값 받아오는지 확인
		logger.debug("deleteCityList(int cityId) 메서드 cityId is {}",cityId);
		sqlSessionTemplate.delete(nameSpace + "deleteCity", cityId);
	}
	//city 파일 삭제
	public void deleteCityFile(int cityId) {
		logger.debug("deletefilecity(int cityId)메서드", cityId);
		sqlSessionTemplate.delete(nameSpace+"deleteCityFile",cityId);
	}
	
	public void updateCity(City city) {
		// 매개변수 city값 확인
		logger.debug("updateCity(City city) 메서드 city is {}",city);
		sqlSessionTemplate.update(nameSpace + "updateCity", city);
	}
	
	// 마지막으로 입력된 id값 조회
	public int selectLastId() {
		int lastId = sqlSessionTemplate.selectOne(nameSpace+"selectLastId");
		logger.debug("selectLastId() 메서드 lastId is {}",lastId);
		return lastId;
	}
	
	// city 파일 입력메소드
	public int insertCityFile(CityFile cityFile) {
		logger.debug("insertCityFile(CityFile cityFile) 메서드 cityFile is {}",cityFile);
		return sqlSessionTemplate.insert(nameSpace + "insertCityFile", cityFile);
	}
	public int insertCity(City city) {
		
		logger.debug("insertCity(City city) 메서드 movie is {}",city);
		
		return sqlSessionTemplate.insert(nameSpace + "insertCity", city);
	}
	
	public City selectCityOne(int cityId) {
		//int i 값 콘솔창에서 확인
		logger.debug("selectCityOne(int cityId) 메서드 cityId is {}",cityId);
		return sqlSessionTemplate.selectOne(nameSpace + "selectCityOne", cityId);
	}
	
	public List<City> selectListByPerPage(Map map) {
		List<City> city = sqlSessionTemplate.selectList(nameSpace + "selectListByPerPage", map);
		logger.debug("selectListByPerPage(Map map)메서드 city is{}", city);
		return city;
	}
	
	public int selectTotalCount(Map map) {
		
		int totalCount = sqlSessionTemplate.selectOne(nameSpace+"selectTotalCount", map);
		logger.debug("selectTotalCount()메서드 map is {}",map);
		return totalCount;
	}

	public CityAndCityFile selectCityAndCityFile(int cityId) {
		CityAndCityFile cityandcityFile = sqlSessionTemplate.selectOne(nameSpace + "selectCityAndCityFile", cityId);
		return cityandcityFile;
	}
	//controller -> service -> dao 규칙을 맞추기위해 생성
	public void cityFileDownload() {
		logger.debug("cityFileDownload()메서드 실행");
	}
}
