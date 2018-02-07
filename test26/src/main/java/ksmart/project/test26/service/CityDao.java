package ksmart.project.test26.service;

import java.util.List;

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
	
	private final String ns = "ksmart.project.test26.service.CityMapper.";
	
	public List<City> selectCityList(){
		List<City> list = sqlSessionTemplate.selectList(ns + "selectCityList");
		//콘솔창에서 list에 들어있는값 확인
		logger.debug("selectCityList() 메서드 list is {}",list);
		return list;
	}
	
	public void deleteCity(int cityId) {
		//int값 받아오는지 확인
		logger.debug("deleteCityList(int cityId) 메서드 cityId is {}",cityId);
		sqlSessionTemplate.delete(ns + "deleteCity", cityId);
	}
	
	public void updateCity(City city) {
		// 매개변수 city값 확인
		logger.debug("updateCity(City city) 메서드 city is {}",city);
		sqlSessionTemplate.update(ns + "updateCity", city);
	}
	
	public int insertCity(City city) {
		
		logger.debug("insertCity(City city) 메서드 movie is {}",city);
		
		return sqlSessionTemplate.insert(ns + "insertCity", city);
	}
	
	public City selectCityOne(int cityId) {
		//int i 값 콘솔창에서 확인
		logger.debug("selectCityOne(int cityId) 메서드 cityId is {}",cityId);
		return sqlSessionTemplate.selectOne(ns + "selectCityOne", cityId);
	}
}
