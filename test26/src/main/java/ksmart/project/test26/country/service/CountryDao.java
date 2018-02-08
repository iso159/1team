package ksmart.project.test26.country.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.movie.service.MovieDao;

//@Repository를 적으면 객체가 미리 생성되서 CountryDao를 AutoWired로 객체에 주입할수있음
@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	// 쿼리 경로를 상수로 입력
	private final String nameSpace = "ksmart.project.test26.country.service.CountryMapper.";

	public List<Country> selectCountryList() {
		// selectCountryList 쿼리문 실행후 결과를 List<Country> 타입으로 리턴
		logger.debug("selectCountryList() 메서드 list is {}");
		return sqlSessionTemplate.selectList(nameSpace + "selectCountryList");
	}

	// country insert
	public void insertCountry(Country country) {
		logger.debug("insertCountry(Country country) 메서드 list is {}");
		sqlSessionTemplate.insert(nameSpace + "insertCountry", country);
	}

	// country delete
	public void deleteCountry(Country country) { // 여기 매개변수타입 int
		logger.debug("deleteCountry(int country) 메서드 list is {}");
		sqlSessionTemplate.delete(nameSpace + "deleteCountry", country);
	}

	// country update
	public void updateCountry(Country country) { // 여기 매개변수타입 int
		logger.debug("updateCountry(int country) 메서드 list is {}");
		sqlSessionTemplate.selectOne(nameSpace + "updateCountry", country);
	}

	// country one update
	public Country selectCountryOne(Country country) {
		Country checkCountry = sqlSessionTemplate.selectOne(nameSpace + "selectOneCountry", country);
		logger.debug("selectCountryOne(Country country) 메서드 country is {}",country);
		return checkCountry;
	}
}
