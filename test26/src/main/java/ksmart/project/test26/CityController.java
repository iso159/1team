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
	
	@RequestMapping(value="/city/cityAdd", method = RequestMethod.POST)
	public String cityAdd(City city) {		
		cityDao.insertCityList(city);		
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
	public String seletOneList(Model model, @RequestParam(value="cityId", required=true) int cityId) {
		City city = cityDao.selectOneCityList(cityId);
		model.addAttribute("city", city);
		return "city/cityUpdate";
	}
	
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
	public String seletOneList(Model model, City city) {
		cityDao.updateCityList(city);
		return "redirect:/city/cityList";
	}
	
	@RequestMapping(value="/city/cityRemove", method = RequestMethod.GET)
	public String cityRemove(@RequestParam(value="cityId", required=true) int cityId) {
		System.out.println(cityId + "<--cityId");
		cityDao.deleteCityList(cityId);
		return "redirect:/city/cityList";
	}
}
