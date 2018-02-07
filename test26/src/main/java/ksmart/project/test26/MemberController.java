package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberDao;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.GET)
	public String insertMember() {
		return "member/memberInsert";
	}

	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.POST)
	public String insertMember(Member member) {
		memberDao.insertMember(member);
		return "redirect:/member/login";
	}

	// update 요청
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.POST)
	public String updateMember(Member member) { 
		memberDao.updateMember(member);
		return "redirect:/";
	}

	// 수정페이지 요청, 한 명 조회
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.GET)
	public String memberOneSelect(Model model, @RequestParam(value = "memberNo", required = true) int member) {
		Member memberSelect = memberDao.selectOneMember(member);
		model.addAttribute("Member", memberSelect);
		return "member/memberUpdate";
	}

	// 회원 삭제요청
	@RequestMapping(value = "/member/memberRemove", method = RequestMethod.GET)
	public String deleteMember(HttpSession session, @RequestParam(value = "memberNo", required = true) int memberNo) {
		memberDao.deleteMember(memberNo);
		session.removeAttribute("loginMember");
		return "redirect:/member/login";
	}
	
	// 로그인요청
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		member = memberDao.loginCheck(member);
		// 회원정보가 입력되지 않았으면 로그인화면으로 리다이렉트
		if(member == null) {
			return "redirect:/member/login";
		}	// 회원정보 입력되면 세션속성"loginMember"에 member값 넣은후 홈으로 리다이렉트
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	// 로그인페이지요청
	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login() {
		logger.debug("로그인페이지 요청확인");
		return "/member/login";
	}
	
	//로그아웃 요청
	@RequestMapping(value="/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("로그아웃 확인");
		// 세션속성 제거 후에 홈으로 리다이렉트 
		session.removeAttribute("loginMember");
		return "redirect:/";
	}
}