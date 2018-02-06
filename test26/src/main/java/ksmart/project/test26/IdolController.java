package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolController {
	
	@Autowired
	private IdolDao idolDao;
	
	/* /idol/idolList 에서 get방식 일시 idol 리스트로 연결해서 전체 띄움*/
	@RequestMapping(value="/idol/idolList", method = RequestMethod.GET)
	public String idolList(Model model,HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		List<Idol> list = idolDao.seleteIdol();
		model.addAttribute("list", list);
		return "/idol/idolList";
	}
	
	/* /idol/idolUpdate 에서 get방식 일시 한명 출력*/
	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.GET)
	public String idolOneSelete(Model model,HttpSession session,@RequestParam(value="idolId", required=true) int idolId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		//System.out.println(idolId+"<--IdolController.java idolOneSelete");
		List<Idol> list = idolDao.seleteOneIdol(idolId);
		model.addAttribute("list", list);
		return "/idol/idolUpdate";
	}
	
	/* /idol/idolUpdate 에서 post방식 일시 업데이트 부분*/
	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.POST)
	public String idelUpdate(Idol idol, HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		//System.out.println(idol);
		idolDao.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	/*idol 추가 입력 부분*/
	@RequestMapping(value="/idol/idolAdd", method = RequestMethod.GET)
	public String idolAdd(HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		return "/idol/idolAdd";
	}
	
	/*idol 추가 부분*/
	@RequestMapping(value="/idol/idolAdd", method = RequestMethod.POST)
	public String idolAdd(Idol idol,HttpSession session) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		idolDao.addIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	/*idol 삭제 부분*/
	@RequestMapping(value="/idol/idolDelete", method = RequestMethod.GET)
	public String idolDelete(HttpSession session ,@RequestParam(value="idolId", required=true) int idolId) {
		// 로그인 세션이 널이면 홈으로 리다이렉트 시킴
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login1team/login";
		}
		idolDao.deleteIdol(idolId);
		return "redirect:/idol/idolList";
	}
}
