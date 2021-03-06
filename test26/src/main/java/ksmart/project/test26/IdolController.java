package ksmart.project.test26;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ksmart.project.test26.idol.service.Idol;
import ksmart.project.test26.idol.service.IdolAndIdolFile;
import ksmart.project.test26.idol.service.IdolCommand;
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
		logger.debug("idolModify(Model model,HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 idolId is {}",idolId);
		Map<String, Object> map = idolService.getIdolOne(idolId);
		//list 객체 안에 있는 정보 확인
		logger.debug("idolModify(Model model,HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 map is {}",map);
		model.addAttribute("map", map);
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
	public String idolAdd(IdolCommand idolCommand,HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		// idolCommand 객체 안에 정보 확인
		logger.debug("idolAdd(IdolCommand idolCommand,HttpSession session) 메서드 idolCommand is {}",idolCommand);
		//session이용해서 리소스 폴더 절대경로 찾음
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/";
		// path 확인
		logger.debug("idolAdd(IdolCommand idolCommand,HttpSession session) 메서드 path is {}",realPath);
		idolService.addIdol(idolCommand,realPath);
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
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/";
		idolService.removeidol(idolId,realPath);
		return "redirect:/idol/idolList";
	}
	
	/*idol 파일 리스트 부분*/
	@RequestMapping(value="/idol/idolFileList",method = RequestMethod.GET)
	public String idolFileList(Model model,HttpSession session,@RequestParam(value="idolId", required=true) int idolId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/member/login";
		}
		logger.debug("idolFileList(HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolId) 메서드 idolId is {}",idolId);
		// 가져온 아이디 값으로 파일 목록 검색
		IdolAndIdolFile idolAndIdolFile = idolService.selectIdolAndIdolFile(idolId);
		// 가져온 map 객체 확인
		logger.debug("idolFileList(HttpSession session,@RequestParam(value=\"idolId\", required=true) int idolAndIdolFile) 메서드 idolId is {}",idolAndIdolFile);
		model.addAttribute("idolAndIdolFile", idolAndIdolFile);
		return "/idol/idolFileList";
	}
	
	/*idol 파일 다운로드 부분*/
	@RequestMapping(value="/idol/idloFileDownload")
	public ModelAndView idolFileDownload(HttpServletRequest request, HttpServletResponse reponse
										,HttpSession session
										,@RequestParam(value="fileName") String fileName
										,@RequestParam(value="fileExt") String fileExt) {
		logger.debug("idolFileDownload(...) 메서드 fileName is {}",fileName);
		logger.debug("idolFileDownload(...) 메서드 fileExt is {}",fileExt);
		// controller -> service -> dao 규칙을 맞추기위해 호출
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources\\upload\\";
		return idolService.idolFileDownload(request,realPath,fileName,fileExt);
	}
}
