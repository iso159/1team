package ksmart.project.test26.city.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.movie.service.Movie;
import ksmart.project.test26.movie.service.MovieDao;

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
	
	public void deleteCity(int cityId) {
		//int값 받아오는지 확인
		logger.debug("deleteCityList(int cityId) 메서드 cityId is {}",cityId);
		sqlSessionTemplate.delete(nameSpace + "deleteCity", cityId);
	}
	
	public void updateCity(City city) {
		// 매개변수 city값 확인
		logger.debug("updateCity(City city) 메서드 city is {}",city);
		sqlSessionTemplate.update(nameSpace + "updateCity", city);
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
}
