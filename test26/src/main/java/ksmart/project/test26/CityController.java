package ksmart.project.test26;

import java.util.List;

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
	private CityDao cityDao;
	
	@RequestMapping(value="/city/cityList")
	public String cityList(Model model) {
		List <City> list = cityDao.selectCityList();
		model.addAttribute("CityList", list);
		return "city/cityList";
	}
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.GET)
	public String cityAdd() {
		return "city/cityinsert";
	}
	
	@RequestMapping(value="/city/cityInsert", method = RequestMethod.POST)
	public String cityInsert(City city) {		
		cityDao.insertCityList(city);		
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
	public String seletOneList(Model model, @RequestParam(value="cityId", required=true) int cityId) {
		System.out.println("도시하나조회 확인");
		List<City> list = cityDao.selectOneCityList(cityId);
		model.addAttribute("list", list);
		return "city/cityUpdate";
	}
}
