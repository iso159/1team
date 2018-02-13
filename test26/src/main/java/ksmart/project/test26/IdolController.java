package ksmart.project.test26;

import java.util.HashMap;
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

import ksmart.project.test26.idol.service.Idol;
import ksmart.project.test26.idol.service.IdolService;

@Controller
public class IdolController {
	private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
	
	@Autowired
	private IdolService idolService;
	
	/* /idol/idolList 에서 get방식 일시 idol 리스트로 연결해서 전체 띄움*/
	@RequestMapping(value="/idol/idolList", method = RequestMethod.GET)
	public String idol(Model model,
						HttpSession session,
						@RequestParam(value="currentPage" ,defaultValue="1" ,required=false) int currentPage,
						@RequestParam(value="rowPerPage" ,defaultValue="10" ,required=false) int rowPerPage,
						@RequestParam(value="idolSearchWord" ,required=false) String idolSearchWord) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		//startRow 값 확인
		logger.debug("idol(Model model,\r\n" + 
				"HttpSession session,\r\n" + 
				"@RequestParam(value=\"currentPage\" ,defaultValue=\"1\" ,required=false) int currentPage,\r\n" + 
				"@RequestParam(value=\"rowPerPage\" ,defaultValue=\"10\" ,required=false) int rowPerPage,\r\n" + 
				"@RequestParam(value=\"idolSearchWord\" ,defaultValue=\"null\" ,required=false) String idolSearchWord)" +
				"메서드 currentPage is {}",currentPage);
		map.put("currentPage", currentPage);
		//pageperRow 값 확인
		logger.debug("idol(Model model,\r\n" + 
				"HttpSession session,\r\n" + 
				"@RequestParam(value=\"currentPage\" ,defaultValue=\"1\" ,required=false) int currentPage,\r\n" + 
				"@RequestParam(value=\"rowPerPage\" ,defaultValue=\"10\" ,required=false) int rowPerPage,\r\n" + 
				"@RequestParam(value=\"idolSearchWord\" ,defaultValue=\"null\" ,required=false) String idolSearchWord)" +
				"메서드 rowPerPage is {}",rowPerPage);
		map.put("rowPerPage", rowPerPage);
		//idolSearchWord 값 확인
		logger.debug("idol(Model model,\r\n" + 
				"HttpSession session,\r\n" + 
				"@RequestParam(value=\"currentPage\" ,defaultValue=\"1\" ,required=false) int currentPage,\r\n" + 
				"@RequestParam(value=\"rowPerPage\" ,defaultValue=\"10\" ,required=false) int rowPerPage,\r\n" + 
				"@RequestParam(value=\"idolSearchWord\" ,defaultValue=\"null\" ,required=false) String idolSearchWord)" +
				"메서드 idolSearchWord is {}",idolSearchWord);
		map.put("idolSearchWord", idolSearchWord);
		//전체 리스트 정보 받아옴
		Map<String, Object> returnMap = idolService.getIdolList(map);
		//받아온 returnMap 정보 확인
		logger.debug("idol(Model model,\r\n" + 
				"HttpSession session,\r\n" + 
				"@RequestParam(value=\"currentPage\" ,defaultValue=\"1\" ,required=false) int currentPage,\r\n" + 
				"@RequestParam(value=\"rowPerPage\" ,defaultValue=\"10\" ,required=false) int rowPerPage,\r\n" + 
				"@RequestParam(value=\"idolSearchWord\" ,defaultValue=\"null\" ,required=false) String idolSearchWord)" +
				"메서드 returnMap is {}",returnMap);
		model.addAttribute("map", returnMap);
		return "/idol/idolList";
	}
	
	/* /idol/idolUpdate 에서 get방식 일시 한명 출력*/
	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.GET)
	public String idolModify(Model model,HttpSession session,@RequestParam(value="idolId", required=true) int idolId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		//idolId 값 확인
		logger.debug("(Model model,HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 idolId is {}",idolId);
		List<Idol> list = idolService.getIdolOne(idolId);
		//list 객체 안에 있는 정보 확인
		logger.debug("(Model model,HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 list is {}",list);
		model.addAttribute("list", list);
		return "/idol/idolModify";
	}
	
	/* /idol/idolUpdate 에서 post방식 일시 업데이트 부분*/
	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.POST)
	public String idolModify(Idol idol, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		//idol 객체 정보 확인
		logger.debug("idolModify(Idol idol, HttpSession session) 메서드 idol is {}",idol);
		idolService.modifyIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	/*idol 추가 입력 부분*/
	@RequestMapping(value="/idol/idolAdd", method = RequestMethod.GET)
	public String idolAdd(HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("idolAdd(HttpSession session) 메서드");
		return "/idol/idolAdd";
	}
	
	/*idol 추가 부분*/
	@RequestMapping(value="/idol/idolAdd", method = RequestMethod.POST)
	public String idolAdd(Idol idol,HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// idol객체 안에 정보 확인
		logger.debug("idolAdd(Idol idol,HttpSession session) 메서드 idol is {}",idol);
		idolService.addIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	/*idol 삭제 부분*/
	@RequestMapping(value="/idol/idolDelete", method = RequestMethod.GET)
	public String idolRemove(HttpSession session ,@RequestParam(value="idolId", required=true) int idolId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// idolId 정보 확인
		logger.debug("idolRemove(HttpSession session ,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 idolId is {}",idolId);
		idolService.removeMovie(idolId);
		return "redirect:/idol/idolList";
	}
	
}
