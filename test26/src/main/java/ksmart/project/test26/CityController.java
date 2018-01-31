package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.*;

@Controller
public class CityController {
	@Autowired
	private CityDao cityDao;
	
	@RequestMapping(value="/city/cityList")
	public String cityList(Model model) {
		List <City> list = cityDao.selectCityList();
		model.addAttribute("CityList", list);
		return "city/cityList";
	}

}
