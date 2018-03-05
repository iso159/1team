package ksmart.project.test26.city.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ksmart.project.test26.country.service.CountryAndCountryFile;

@Service
@Transactional
public class CityService {

	@Autowired
	private CityDao citydao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	public List<City> getCityList(){ //메서드생성
		
		List<City> list = citydao.selectCityList();//cityDao에 잇는 selectCityList()호출
		// 리턴받은 리스트 출력
		logger.debug("checkCityList() 메서드 list is {}",list);
		return list;
	}
	
	//city, city file삭제
	public void removeCity(int cityId, String path) {
		logger.debug("removeCityFile()메서드 cityId is {}", cityId);
		logger.debug("removeCity(int cityId, String path) 메서드 path is {}", path);
		//파일이 있는지 확인후 삭제
		CityAndCityFile cityandcityfile = citydao.selectCityAndCityFile(cityId);
		if(cityandcityfile != null){
			List<CityFile> list = cityandcityfile.getList();
			for(CityFile i : list) {
				//path와 파일이름을 결합
				File temp = new File(path+i.getFileName());
				//File클래스의 생성자 함수, pathname에 해당되는 파일의 File 객체를 생성한다
				//파일이 있다면 if블록 실행
				if(temp.exists()) {
					if(temp.delete()) { //파일을 삭제하고 if문 실행
						logger.debug("removeCity(int cityId, String path) 메서드 temp.delete CLEAR DELETE !{} !", temp);
					}else {
						//파일 삭제 실패 debug 메세지
						logger.debug("removeCity(int cityId, String path) 메서드temp.delete FAILURE DELETE ! {}",temp);
					}
				}
			}
			citydao.deleteCityFile(cityId);
		}
		citydao.deleteCity(cityId);
	}
	
	//city 수정
	public void modifyCity(City city) {
		
		logger.debug("modifyCity(City city) 메서드 city is {}",city);
		citydao.updateCity(city);
	}
	//city 추가
	public void addCity(CityCommand cityCommand, String path, MultipartFile multiPartFile) {
		logger.debug("addCity(CityCommand cityCommand) 메서드 cityCommand is {}",cityCommand);
		City city = new City();
		city.setCityName(cityCommand.getCityName());
		citydao.insertCity(city);
		int cityId = citydao.selectLastId();
		//폼에 파일이 있을경우 반복문을 실행
	if(!multiPartFile.isEmpty()) {	
		for(MultipartFile file : cityCommand.getFile()) {
			// 1. db에 입력
			CityFile cityFile = new CityFile();
			UUID uuid = UUID.randomUUID();
			//파일이름
			String fileName = uuid.toString();	// 중복되지않은 이름
			String originalName = file.getOriginalFilename();
			// 파일확장자
			int pos = originalName.lastIndexOf(".");
			String fileExt = originalName.substring(pos+1);
			// 파일크기
			long fileSize = file.getSize();
			// 값들을 셋팅 후 메소드 실행
			cityFile.setCityId(cityId);
			cityFile.setFileName(fileName);
			cityFile.setFileExt(fileExt);
			cityFile.setFileSize(fileSize);
			citydao.insertCityFile(cityFile);
			
			// 2. 하드디스크에 파일저장
			File temp = new File(path+fileName);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				if(temp.exists()) {
					// temp 파일 삭제 및 콘솔창으로 확인
					if(temp.delete()) {
						logger.debug("addCity(CityCommand cityCommand) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addCity(CityCommand cityCommand) 메서드 {} 파일 삭제 실패",temp);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				if(temp.exists()) {
					// temp 파일 삭제 및 콘솔창으로 확인
					if(temp.delete()) {
						logger.debug("addCity(CityCommand cityCommand) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addCity(CityCommand cityCommand) 메서드 {} 파일 삭제 실패",temp);
					}
				}
			}
		}
	}
	}
	public CityAndCityFile getCityAndCityFile(int cityId) {
		logger.debug("getCityAndCityFile(int cityId)메서드 cityId is {}", cityId);
		CityAndCityFile cityandcityFile = citydao.selectCityAndCityFile(cityId);
		logger.debug("getCityAndCityFile(int cityId)메서드 cityAndcityFile is {}", cityandcityFile);
		return cityandcityFile;
	}
	//한개도시조회
	public City getCityOne(int cityId) {
		logger.debug("getCityOne(int cityId) 메서드 cityId is {}", cityId);
		City onecity = citydao.selectCityOne(cityId);
		//리턴받은 도시출력
		logger.debug("checkCityOne(int cityId) 메서드 onecity is {}",onecity);
		return onecity; 
	}
	
	//Map<String, Object> int로 받을 수없기 때문에 Object로 받는다
	public Map<String,Object> getListByPage(int currentPage, int rowPerPage, String citySearchWord){
		logger.debug("getListByPage()메서드 currentPage is {}", currentPage);
		logger.debug("getListByPage()메서드 rowPerPage is {}", rowPerPage);
		logger.debug("getListByPage()메서드 citySearchWord is {}", citySearchWord);
		//startRow선언
		int startRow = 0;
		//현재페이지 * 보여줄 개수로 시작행 구함
		startRow = (currentPage-1)*rowPerPage;
		//매개변수를 넘길 map객체 생성
		Map map = new HashMap();
		//map에 startRow, pagePerRow를 매핑함
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("citySearchWord", citySearchWord);
		
		//리턴할 맵객체 생성
		Map returnMap = new HashMap();
		//페이지별로 보여줄 리스트 조회 메서드 호출
		List<City> list = citydao.selectListByPerPage(map);
		logger.debug("getListByPage()메서드 List is {}", list);
		//총 행의 개수 조회 메서드 호출 및 totalCount에 입력
		int totalCount = citydao.selectTotalCount(map);
		logger.debug("getListByPage()메서드 totalCount is {}", totalCount);
		//totalCount와 pagePerRow로 마지막 페이지를 구함
		int lastPage = (int)(totalCount/rowPerPage+1);
		logger.debug("getListByPage()메서드 lastPage is {}", lastPage);
		
		//returnMap에 list와 lastPage를 매핑함
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalCount", totalCount);
		return returnMap;
	}
	//city파일 다운로드
	public ModelAndView cityFileDownload(HttpServletRequest request, String path, String fileName, String fileExt) {
		logger.debug("cityFileDownload()메서드 실행 path is {}", path);
		logger.debug("cityFileDownload()메서드 실행 fileName is {}", fileName);
		logger.debug("cityFileDownload()메서드 실행 fileExt is{}", fileExt);
		citydao.cityFileDownload();
		//경로 + 다운받을 파일이름을 file에 입력
		File file = new File(path+fileName);
		logger.debug("cityFileDownload()메서드 실행 file is {}", file);
		//입력한 파일을 읽을 수 없다면 if블록실행
		if(!file.canRead()) {
			logger.debug("{} 파일을 찾지못했습니다.", file);
			return new ModelAndView("fileDownloadView","file",file);
		}
		//원본 파일명 request에 셋팅
		request.setAttribute("fileName",fileName);
		//확장명을 더해서 파일 셋팅
		File reFile = new File(path+fileName+"."+fileExt);
		logger.debug("cityFileDownload()메서드 실행 reFile is {}", reFile);
		try {
			//파일이 있다면 if블록 실행
			if(file.exists()) {
				//확장자명을 더한 파일명으로 수정
				file.renameTo(reFile);
				//확장자명을 더한 파일을 request에 셋팅
				request.setAttribute("reFile",reFile);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("fileDownloadView","file",reFile);
	}	
}
