package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String str = "ksmart.project.test26.service.CityMapper.";
	
	public List<City> selectCityList(){
		return sqlSessionTemplate.selectList(str + "selectCityList");
	}
	
	public void deleteCityList(int i) {
		sqlSessionTemplate.delete(str + "deleteCityList", i);
	}
	
	public void updateCityList(City city) {
		sqlSessionTemplate.update(str+"updateCityList", city);
	}
	
	public int insertCityList(City city) {
		
		return sqlSessionTemplate.insert(str+"insertCityList", city);
	}
	
	public List<City> selectOneCityList(int i) {
		System.out.println("도시하나조회 메서드 확인");
		return sqlSessionTemplate.selectList(str+"selectOneCityList", i);
	}
}
