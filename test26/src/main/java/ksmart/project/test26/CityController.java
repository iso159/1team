package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ksmart.project.test26.city.service.City;
import ksmart.project.test26.city.service.CityAndCityFile;
import ksmart.project.test26.city.service.CityCommand;
import ksmart.project.test26.city.service.CityFile;
import ksmart.project.test26.city.service.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService cityservice;
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	
	
	@RequestMapping(value="/city/cityList", method = RequestMethod.GET)
	public String city(Model model,HttpSession session
							,@RequestParam(value="currentPage",defaultValue="1",required=false) int currentPage
							,@RequestParam(value="rowPerPage",defaultValue="10",required=false) int rowPerPage
							,@RequestParam(value="citySearchWord",required=false) String citySearchWord){
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("city()메서드 currentPage is {}", currentPage);
		logger.debug("city()메서드 rowPerPage is {}", rowPerPage);
		logger.debug("city()메서드 citySearchWord is {}", citySearchWord);
				
		Map map = cityservice.getListByPage(currentPage, rowPerPage, citySearchWord);
		// map에서 형변환으로 list와 lastPage변수를 꺼내 값을 입력받음
		List<City> list = (List<City>)map.get("list"); //map에서 list 키에 해당되는 값을 얻어온다
		int lastPage = (Integer)map.get("lastPage");
		int totalCount = (Integer)map.get("totalCount");
		// list,lastPage,currentPage,rowPerPage model에 담음
		model.addAttribute("CityList", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("citySearchWord", citySearchWord);
		model.addAttribute("totalCount", totalCount);
		return "city/cityList";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.GET)
	public String cityAdd(CityCommand cityCommand, HttpSession session) {
		// 메서드 확인
		logger.debug("cityAdd(HttpSession session) 메서드");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		return "city/cityAdd";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.POST)
	public String cityAdd(HttpSession session, CityCommand cityCommand 
			 ,@RequestParam(value="file") MultipartFile multiPartFile) {
		
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		String path = session.getServletContext().getRealPath("/");
		//현재 웹서비스가 실행되고있는 파일경로를 가져와서 패쓰에 담는다?????
		path +="/resources/upload/";
		logger.debug("fileName :{}",cityCommand);
		logger.debug("000000000000000000000000000path:{}",path);
		cityservice.addCity(cityCommand, path, multiPartFile);
		return "redirect:/city/cityList";
	}
	@RequestMapping(value="/city/cityFileList")
	public String cityFile(Model model, HttpSession session
								,@RequestParam(value="cityId") int cityId) {
		//로그인 세션이 녈이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("cityFile() 메서드 cityId is {}", cityId);
		CityAndCityFile cityandcityFile = cityservice.getCityAndCityFile(cityId);
		model.addAttribute("cityandcityFile", cityandcityFile);
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources\\upload\\";
		model.addAttribute("realPath", realPath);
		return "/city/cityFileList";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
	public String cityModify(Model model, @RequestParam(value="cityId", required=true) int cityId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		City city = cityservice.getCityOne(cityId);
		// 매개변수 city 값 확인
		logger.debug("cityModify(City , city city, HttpSession session) 메서드 city is {}",city);
		model.addAttribute("city", city);
		return "city/cityModify";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
	public String cityModify(Model model, City city,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("cityModify(Model model, City city,HttpSession session) 메서드 city is {}",city);
		cityservice.modifyCity(city);		
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityRemove", method = RequestMethod.GET)
	public String cityRemove(@RequestParam(value="cityId", required=true) int cityId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		logger.debug("cityRemove(int cityId,HttpSession session) 메서드 cityId is {}",cityId);
		
		String path = session.getServletContext().getRealPath("/");
		//현재 웹서비스가 실행되고있는 파일경로를 가져와서 패쓰에 담는다?????
		path +="\\resources\\upload\\";
		//path에 경로추가 /resources/upload/
		logger.debug("cityRemove()메서드 path:{}",path);
		cityservice.removeCity(cityId, path);
		return "redirect:/city/cityList";
	}
}
