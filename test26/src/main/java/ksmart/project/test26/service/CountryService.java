package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.project.test26.MovieController;


@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryDao countryDao;
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	public List<Country> checkCountryList() {
		// 전체 국가 조회 메서드 호출 후 리턴 받음
		List<Country> list = countryDao.selectCountryList();
		// 리턴받은 리스트 출력
		logger.debug("checkCountryList() 메서드 list is {}", list);
		return list;
	}
	public void addcountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("addCountry(Country country) 메서드 country is {}",country);
		// 입력 메서드 호출
		countryDao.insertCountry(country);
	}
	public Country checkCountryOne(Country country) {
		// 매개변수 country 값 확인
		logger.debug("checkCountryOne(Country country) 메서드 country is {}",country);
		Country checkCountry = countryDao.selectCountryOne(country);
		// 리턴값 확인
		logger.debug("checkCountryOne(Country country) 메서드 checkCountry is {}",checkCountry);
		return checkCountry;
	}
	
	public void modifyCountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("modifyCountry(Country country) 메서드 country is {}",country);
		// 국가 수정 메서드 호출
		countryDao.updateCountry(country);
	}
	public void removeCountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("removeCountry(Country country) 메서드 country is {}",country);
		// 국가 삭제 메서드 호출
		countryDao.deleteCountry(country);
	}

}
