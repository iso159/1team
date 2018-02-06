package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

@Controller
public class CountryController {
	@Autowired
	private CountryDao countryDao;

	@RequestMapping(value = "/country/countryList")
	public String country(Model model) {
		List<Country> list = countryDao.selectCountryList();
		model.addAttribute("CountryList", list);
		return "country/countryList";
	}

	// insert 입력하기 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.GET)
	public String countryInsert() {
		return "/country/countryInsert";
	}

	// insert post방식 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.POST)
	public String countryInsert(Country country) {
		countryDao.insertCountry(country);
		return "redirect:/country/countryList";	
	}

	// 삭제요청
	@RequestMapping(value = "/country/countryDelete", method = RequestMethod.GET)
	public String countryDelete(@RequestParam(value = "countryId", required = true) int countryId) {
		countryDao.deleteCountry(countryId);
		return "redirect:/country/countryList";
	}

	// 수정페이지 요청, 수정할 한 권조회
	@RequestMapping(value = "/country/countryUpdate", method = RequestMethod.GET)
	public String countryOneSelect(Model model, @RequestParam(value = "countryId", required = true) int country) {
		List<Country> list = countryDao.selectOneCountry(country);
		model.addAttribute("list", list);
		return "/country/countryUpdate";
	}

	// 수정요청
	@RequestMapping(value = "/country/countryUpdate", method = RequestMethod.POST)
	public String countryUpdate(Country country) {
		countryDao.updateCountry(country);
		return "redirect:/country/countryList";
	}
}