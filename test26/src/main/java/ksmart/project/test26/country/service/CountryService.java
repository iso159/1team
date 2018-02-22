package ksmart.project.test26.country.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

	// 국가 1개 조회
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

/*	
// 국가 삭제
	public void deleteCountry(Country country) {
		// 매개변수 country 값 확인
		logger.debug("deleteCountry(Country country) 메서드 country is {}", country);
		// 국가 삭제 메서드 호출
		countryDao.deleteCountry(country);
	}
*/

	/*
	 * // 국가파일 삭제 public void removeCountryFile (CountryFile countryFile) { // 매개변수
	 * countryFile 값 확인 logger.
	 * debug("removeCountryFile (CountryFile countryFile) 메서드 countryFile is {}",
	 * countryFile); //국가 삭제 메서드 호출 countryDao.deleteCountryFile(countryFile); }
	 */

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

	// 파일저장
	public void addCountry(CountryCommand countryCommand, String path, MultipartFile multiPartFile) {
		logger.debug("addCountry(CountryCommand countryCommand) 메서드 countryCommand is {}", countryCommand);
		logger.debug("addCountry(CountryCommand countryCommand) 메서드 path is {}", path);
		Country country = new Country();
		logger.debug("addCountry(CountryCommand countryCommand) 메서드 countryCommand is {}",
				countryCommand.getCountryName());
		country.setCountryName(countryCommand.getCountryName());
		countryDao.insertCountry(country);
		logger.debug("countryDao.insertCountry(country) country is {}", country);
		int countryId = countryDao.selectLastId();
		logger.debug("int countryId = countryDao.selectLastId(); countryId is {}", countryId);

			
		if(!multiPartFile.isEmpty()) { // 국가 파일 저장을 할 때 아무것도 파일을 저장하지 않았는데 랜덤으로 용량0 여러가지 파일이 들어가는것 수정
			for (MultipartFile file : countryCommand.getFile()) {
				// 1. DB에 입력
				CountryFile countryFile = new CountryFile();
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString(); // 중복되지않은 이름 랜덤...
				String originalName = file.getOriginalFilename();
				int pos = originalName.lastIndexOf(".");
				logger.debug("addCountry(CountryCommand countryCommand, String path) 메서드 pos is {}", pos);
				// 오리지널 이름에서 마지막 .
				String fileExt = originalName.substring(pos + 1); // 오지리널 파일 확장자
	
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
				File temp = new File(path + fileName);
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

	public CountryAndCountryFile getCountryAndCountryFile(int countryId) {
		logger.debug("getCountryAndCountryFile(int countryId)");
		CountryAndCountryFile countryAndCountryFile = countryDao.selectCountryAndCountryFile(countryId);
		return countryAndCountryFile;
	}

	// 국가 삭제할 때 해당 국가에 같이 업로드된 파일도 함께 삭제
	public void deleteCountry(int countryId, String realPath) {
		// country_file 테이블 삭제 및 파일삭제후 country 테이블 삭제
		// 매개변수 country 값 확인
		logger.debug("deleteCountry(int countryId, String Path) 메서드 countryId is {}", countryId);
		// 매개변수 Path 값 확인
		logger.debug("deleteCountry(int countryId, String Path) 메서드 realPath is {}", realPath);
		// countryId에 맞는 country_file 테이블 조회
		List<CountryFile> list = countryDao.selectCountryFileAndCountryId(countryId);
		// 조회결과가 null이 아니면 if블록 실행
		if (list != null) {
			for (CountryFile countryFile : list) {
				// 경로에 조회 결과로 얻은 파일이름을 결합
				File temp = new File(realPath + countryFile.getFileName());
				// 파일이 있다면 if블록 실행
				if (temp.exists()) {
					// 파일이 삭제되면 if블록 실행 아니면 else 블록 실행
					if (temp.delete()) {
						// 파일 삭제 성공 debug 메시지
						logger.debug("deleteCountry(int countryId, String path) 메서드 temp.delete CLEAR DELETE ! {} !",
								temp);
					} else {
						// 파일 삭제 실패 debug 메시지
						logger.debug("deletecountry(int countryId, String path) 메서드 temp.delete FAILURE DELETE ! {} ",
								temp);
					}
				}
			}
			countryDao.deleteCountryFile(countryId);
		}
		// 국가 삭제 메서드 호출
		countryDao.deleteCountry(countryId);
	}
	
	public ModelAndView countryFileDownload(HttpServletRequest request,String path, String fileName, String fileExt) {
 		logger.debug("countryFileDownload(String path, String fileName) 메서드 실행 paht is {}", path);
 		logger.debug("countryFileDownload(String path, String fileName) 메서드 실행 fileName is {}", fileName);
 		countryDao.countryFileDownload();
 		// 경로 + 다운받을 파일이름을 file에 입력
 		File file = new File(path+fileName);
 		logger.debug("countryFileDownload(String path, String fileName) 메서드 실행 file is {}", file);
 		// 입력한 파일을 읽을수 없다면 if블록실행
 		if(!file.canRead()) {
 			logger.debug("{} 파일을 찾지 못했습니다.",file);
 			return new ModelAndView("fileDownloadView", "file",file);
 		}
 		// 원본 파일명 request에 셋팅
 		request.setAttribute("fileName", fileName);
 		// 확장자명을 더해서 파일 셋팅
 		File reFile = new File(path+fileName+"."+fileExt);
 		logger.debug("countryFileDownload(String path, String fileName) 메서드 실행 reFile is {}", reFile);
 		try {
 			// 파일이 있다면 if블록실행
 			if(file.exists()) {
 				// 확장자명을 더한 파일명으로 수정
 				file.renameTo(reFile);
 				// 확장자명을 더한 파일을 request에 셋팅
 				request.setAttribute("reFile", reFile);
 			}
 		}catch(Exception e) {
 			e.printStackTrace();
 		}
 		return new ModelAndView("fileDownloadView", "file",reFile);
 	}
}