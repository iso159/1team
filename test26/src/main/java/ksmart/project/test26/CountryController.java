package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

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
}
