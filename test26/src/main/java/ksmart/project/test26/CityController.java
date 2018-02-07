package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.*;

@Controller
public class CityController {
	@Autowired
	private CityService cityservice;
	
	@RequestMapping(value="/city/cityList")
	public String city(Model model,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		List <City> list = cityservice.checkCityList();
		model.addAttribute("CityList", list);
		return "city/cityList";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.GET)
	public String cityAdd(HttpSession session) {
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
		model.addAttribute("city", city);
		return "city/cityUpdate";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
	public String cityModify(Model model, City city,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		cityservice.modifyCity(city);
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityRemove", method = RequestMethod.GET)
	public String cityRemove(@RequestParam(value="cityId", required=true) int cityId,HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/member/login";
		}
		System.out.println(cityId + "<--cityId");
		cityservice.removeCity(cityId);
		return "redirect:/city/cityList";
	}
}
