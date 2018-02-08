package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.city.service.City;
import ksmart.project.test26.city.service.CityService;
import ksmart.project.test26.service.*;

@Controller
public class CityController {
	@Autowired
	private CityService cityservice;
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping(value="/city/cityList")
	public String city(Model model,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		List <City> list = cityservice.checkCityList();
		// list 값 확인
		logger.debug("city(Model model,HttpSession session) 메서드 list is {}",list);
		model.addAttribute("CityList", list);
		return "city/cityList";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.GET)
	public String cityAdd(HttpSession session) {
		// 메서드 확인
		logger.debug("cityAdd(HttpSession session) 메서드");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		return "city/cityinsert";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.POST)
	public String cityAdd(City city,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		cityservice.addCity(city);
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
	public String cityModify(Model model, @RequestParam(value="cityId", required=true) int cityId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		City city = cityservice.checkCityOne(cityId);
		// 매개변수 city 값 확인
		logger.debug("cityModify(City , Movie movie, HttpSession session) 메서드 city is {}",city);
		model.addAttribute("city", city);
		return "city/cityUpdate";
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
		cityservice.removeCity(cityId);
		return "redirect:/city/cityList";
	}
}
