package ksmart.project.test26.country.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart.project.test26.CountryController;
import ksmart.project.test26.country.service.Country;
import ksmart.project.test26.country.service.CountryCommand;
import ksmart.project.test26.country.service.CountryFile;

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
	public Map<String, Object> getListByPage(int currentPage, int rowPerPage, String searchWord) {
		logger.debug("getListByPage(int currentPage, int rowPerPage) 메서드 currentPage is {}", currentPage);
		logger.debug("getListByPage(int currentPage, int rowPerPage) 메서드 currentPage is {}", rowPerPage);
		logger.debug("getListByPage(int currentPage, int rowPerPage) 메서드 currentPage is {}", searchWord);
		// CountryDao 를 이용하여 startRow
		int startRow = 0;
		startRow = (currentPage - 1) * rowPerPage;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		logger.debug("(startRow) getListByPage(int currentPage, int rowPerPage, String searchWord) 메서드 is {}",
				startRow);
		map.put("rowPerPage", rowPerPage);
		logger.debug("(getListByPage(int currentPage, int rowPerPage, String searchWord) 메서드 is {}", rowPerPage);
		/* Map searchWordmap = new HashMap(); */
		map.put("searchWord", searchWord);
		logger.debug("(searchWord) getListByPage(int currentPage, int rowPerPage ,String searchWord) 메서드 is {}",
				searchWord);

		Map<String, Object> returnMap = new HashMap<String, Object>();
		logger.debug("getListByPage(int currentPage, int pagePerRow) 메서드 list is {}", returnMap);
		int totalCount = countryDao.selectTotalCount(searchWord);
		List<Country> list = countryDao.selectListByPerPage(map);
		logger.debug("getListByPage(int currentPage, int pagePerRow) 메서드 list is {}", list);

		int lastPage = (int) Math.ceil((double) totalCount / (double) rowPerPage);
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		/* returnMap.put("searchWord", searchWord); */
		returnMap.put("totalCount", totalCount);
		/* logger.debug("01. searchWord{}", searchWord); */
		return returnMap;
	}

	public void addCountry(CountryCommand countryCommand){
		logger.debug("addCountry(CountryCommand countryCommand) 메서드 countryCommand is {}", countryCommand);
		Country country = new Country();
		logger.debug("addCountry(CountryCommand countryCommand) 메서드 countryCommand is {}", countryCommand.getCountryName());
		country.setCountryName(countryCommand.getCountryName());
		countryDao.insertCountry(country);
		logger.debug("countryDao.insertCountry(country) country is {}", country);
		int countryId = countryDao.selectLastId();
		logger.debug("int countryId = countryDao.selectLastId(); countryId is {}", countryId);

		for (MultipartFile file : countryCommand.getFile()) {
			// 1. DB에 입력...
			CountryFile countryFile = new CountryFile();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString(); // 중복되지않은 이름 랜덤...
			String originalName = file.getOriginalFilename();
			int pos = originalName.lastIndexOf(".");
			// 오리지널 이름에서 마지막 .
			String fileExt = originalName.substring(pos+1); // 오지리널 파일 확장자

			long fileSize = file.getSize(); // 오지리널 파일 사이즈
			logger.debug("long fileSize = file.getSize() fileSize is {}", fileSize);
			
			countryFile.setCountryId(countryId);
			logger.debug("countryFile.setFileName(fileName) countryId is {}", countryId);
			countryFile.setFileName(fileName);
			logger.debug("countryFile.setFileName(fileName) fileName is {}", fileName);
			countryFile.setFileExt(fileExt);
			logger.debug("countryFile.setFileExt(fileExt) fileExt is {}", fileExt);
			countryFile.setFileSize(fileSize);
			logger.debug("countryFile.setFileSize(fileSize) fileSize is {}", fileSize);
			
			countryDao.insertCountryFile(countryFile);
			// 2. 파일을 저장
			File temp = new File("c:\\upload\\" + fileName);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				if (temp.exists()) {
					if (temp.delete()) {
						logger.debug("addCountry(CountryCommand countryCommand) 메서드 {} 파일 삭제 성공", temp);
					} else {
						logger.debug("addCountry(CountryCommand countryCommand) 메서드 {} 파일 삭제 실패", temp);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				if (temp.exists()) {
					logger.debug("addCountry(CountryCommand countryCommand) 메서드 {} 파일 삭제 성공", temp);
				} else {
					logger.debug("addCountry(CountryCommand countryCommand) 메서드 {} 파일 삭제 실패", temp);
				}
			}
		}
	}
}