package ksmart.project.test26.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ksmart.project.test26.CountryController;

@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryDao countryDao;
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	private final int pagePerCount = 10; // 페이징

	public List<Country> getCountryList() {
		// 전체 국가 조회 메서드 호출 후 리턴 받음
		List<Country> list = countryDao.selectCountryList();
		// 리턴받은 리스트 출력
		logger.debug("getCountryList() 메서드 list is {}", list);
		return list;
	}

	public void addcountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("addCountry(Country country) 메서드 country is {}", country);
		// 입력 메서드 호출
		countryDao.insertCountry(country);
	}

	public Country getCountryOne(Country country) {
		// 매개변수 country 값 확인
		logger.debug("getCountryOne(Country country) 메서드 country is {}", country);
		Country getCountry = countryDao.selectCountryOne(country);
		// 리턴값 확인
		logger.debug("getCountryOne(Country country) 메서드 getCountry is {}", getCountry);
		return getCountry;
	}

	public void modifyCountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("modifyCountry(Country country) 메서드 country is {}", country);
		// 국가 수정 메서드 호출
		countryDao.updateCountry(country);
	}

	public void removeCountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("removeCountry(Country country) 메서드 country is {}", country);
		// 국가 삭제 메서드 호출
		countryDao.deleteCountry(country);
	}

	// 페이지당 보여줄 개수 

	public Map<String, Object> getListByPage(int currentPage, int rowPerPage) {
		logger.debug("01getListByPage(int currentPage, int rowPerPage) 메서드 is {}", currentPage, rowPerPage);
		// CountryDao 를 이용하여 startRow
		int startRow = 0;
		startRow = (currentPage - 1) * rowPerPage;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		logger.debug("02getListByPage(int currentPage, int rowPerPage) 메서드 is {}", startRow);
		map.put("rowPerPage", rowPerPage);
		logger.debug("03getListByPage(int currentPage, int rowPerPage) 메서드 is {}", rowPerPage);

		Map<String, Object> returnMap = new HashMap<String, Object>(); // Map returnMap = new HashMap();
		logger.debug("04Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 list is {}", returnMap);
		List<Country> list = countryDao.selectListByPerPage(map);
		logger.debug("05Map<String,Object> getListByPage(int currentPage, int pagePerRow) 메서드 list is {}", list);
		int totalCount = countryDao.selectTotalCount();
		int lastPage = (totalCount / rowPerPage);
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
}