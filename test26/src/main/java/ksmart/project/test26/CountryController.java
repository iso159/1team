package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;
import ksmart.project.test26.service.Movie;


@Controller
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	@RequestMapping(value="/country/countryList")
	public String country(Model model) {
		List<Country> list = countryDao.selectCountryList();
		model.addAttribute("CountryList",list);
		return "country/countryList";
	}
	
	 // 입력하기 요청
    @RequestMapping(value="/country/countryAdd", method = RequestMethod.GET)
	public String countryAdd() {
		// 입력 폼으로 이동
		return "/country/countryAdd";
	}
	
	// post방식 요청
	@RequestMapping(value="/country/countryAdd", method = RequestMethod.POST)
	public String movieAdd(Country country) {
		System.out.println(country); // 값이 들어가는지 안들어가는지 확인
		// 호출허기
		countryDao.insertCountry(country);
		// 리다이렉트로 이동.
		return "redirect:/country/countryList";
	}
}
