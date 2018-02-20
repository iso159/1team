package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.country.service.Country;
import ksmart.project.test26.country.service.CountryAndCountryFile;
import ksmart.project.test26.country.service.CountryCommand;
import ksmart.project.test26.country.service.CountryDao;
import ksmart.project.test26.country.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	/*
	 * @RequestMapping(value = "/country/countryList") public String country(Model
	 * model, HttpSession session) { // 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트 if
	 * (session.getAttribute("loginMember") == null) {
	 * logger.debug("country(Model model,HttpSession session) 메서드 model is {}",
	 * model); return "redirect:/member/login"; } List<Country> list =
	 * countryService.getCountryList(); model.addAttribute("CountryList", list);
	 * logger.debug("country(Model model,HttpSession session) 메서드 list is {}",
	 * list); return "country/countryList"; }
	 */

	// insert 입력하기 요청
	@RequestMapping(value = "/country/countryAdd", method = RequestMethod.GET)
	public String countryAdd(HttpSession session) {
		logger.debug("countryAdd(HttpSession session) 메서드 session is {}", session);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		return "/country/countryAdd";
	}

	// insert post방식 요청
	@RequestMapping(value = "/country/countryAdd", method = RequestMethod.POST)
	public String countryInsert(CountryCommand countryCommand, HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		String path = session.getServletContext().getRealPath("/");
		path += "/resources/upload/";
		logger.debug("countryInsert(CountryCommand countryCommand, HttpSession session) 메서드 path is {}", path);
		countryService.addCountry(countryCommand, path);
		logger.debug("countryInsert(Country country,HttpSession session) 메서드 countryCommand is {}", countryCommand);
		return "redirect:/country/countryList";
	}

	// 삭제요청
	@RequestMapping(value = "/country/countryDelete", method = RequestMethod.GET)
	public String countryDelete(Country country, HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		countryService.removeCountry(country);
		logger.debug("String countryDelete(Country country,HttpSession session) 메서드 country, session is {}", country,
				session);
		return "redirect:/country/countryList";
	}

	// 수정페이지 요청, 수정할 한 권조회
	@RequestMapping(value = "/country/countryModify", method = RequestMethod.GET)
	public String countryOneSelect(Model model, Country country, HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("countryOneSelect(Model model, Country country,HttpSession session) 메서드 country is {}", country);
		Country countrySelect = countryService.getCountryOne(country);
		model.addAttribute("Country", countrySelect);
		return "/country/countryModify";
	}

	// 수정요청
	@RequestMapping(value = "/country/countryModify", method = RequestMethod.POST)
	public String countryModify(Country country, HttpSession session) {
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		countryService.modifyCountry(country);
		logger.debug("countryModify(Country country,HttpSession session) 메서드 country session is {}", country, session);
		return "redirect:/country/countryList";
	}

	// /country/countryList 요청시 country메서드 호출됨
	@RequestMapping(value = "/country/countryList")
	public String country(Model model, HttpSession session,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "rowPerPage", defaultValue = "10", required = false) int rowPerPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("country(Model model, HttpSession session, @RequestParam(value = \"currentPage\", defaultValue = \"1\", required = false) int currentPage 메서드 currentPage is {}", currentPage);
		logger.debug("country(Model model, HttpSession session, @RequestParam(value = \"rowPerPage\", defaultValue = \"10\", required = false) int rowPerPage is {}", rowPerPage);
		logger.debug("country(Model model, HttpSession session, @RequestParam(value = \"searchWord\", required = false) String searchWord is {}", searchWord);
		Map map = countryService.getListByPage(currentPage, rowPerPage, searchWord);
		// map에서 형변환으로 list와 lastPage변수를 꺼내 값을 입력 받음
		@SuppressWarnings("unchecked")
		List<Country> list = (List<Country>) map.get("list");
		int lastPage = (Integer) map.get("lastPage");
		int totalCount = (Integer) map.get("totalCount");
		// list,lastPage,currentPage,rowPerPage model에 담음
		model.addAttribute("CountryList", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("totalCount", totalCount);
		logger.debug("searchWord{}", searchWord);
		return "/country/countryList";
	}
	@RequestMapping(value="/country/countryFileList")
	public String countryFile(Model model, HttpSession session
								,@RequestParam(value="countryId") int countryId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("countryFile(Model model, HttpSession session\r\n" + ",@RequestParam(value=\"countryId\") int countryId) 메서드 countryId is {}", countryId);
		CountryAndCountryFile countryFile = countryService.getCountryAndCountryFile(countryId);
		logger.debug("countryFile(Model model, HttpSession session\\r\\n\" + \",@RequestParam(value=\\\"countryId\\\") int countryId) 메서드 countryFile is {}", countryFile);
		model.addAttribute("countryFile", countryFile);
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/upload/";
		model.addAttribute("realPath", realPath);
		return "/country/countryFileList";
	}

}