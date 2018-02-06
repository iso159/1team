package ksmart.project.test26;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ksmart.project.test26.service.BookDao;
import ksmart.project.test26.service.LoginDao;
import ksmart.project.test26.service.Member;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private LoginDao loginDao;
	
	// 로그인요청
	@RequestMapping(value="/login1team/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		member = loginDao.loginCheck(member);
		if(member == null) {
			return "redirect:/login1team/login";
		}
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	// 로그인페이지요청
	@RequestMapping(value="/login1team/login", method = RequestMethod.GET)
	public String login() {
		logger.debug("로그인페이지 요청확인");
		return "/login1team/login";
	}
	
	//로그아웃 요청
	@RequestMapping(value="/login1team/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("로그아웃 확인");
		session.removeAttribute("loginMember");
		return "redirect:/";
	}
}