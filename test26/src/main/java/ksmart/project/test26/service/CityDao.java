package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String ns = "ksmart.project.test26.service.CityMapper.";
	
	public List<City> selectCityList(){
		return sqlSessionTemplate.selectList(ns + "selectCityList");
	}
	
	public void deleteCityList(int i) {
		sqlSessionTemplate.delete(ns + "deleteCityList", i);
	}
	
	public void updateCityList(City city) {
		sqlSessionTemplate.update(ns + "updateCityList", city);
	}
	
	public int insertCityList(City city) {
		
		return sqlSessionTemplate.insert(ns + "insertCityList", city);
	}
	
	public City selectOneCityList(int i) {
		return sqlSessionTemplate.selectOne(ns + "selectOneCityList", i);
	}
}
