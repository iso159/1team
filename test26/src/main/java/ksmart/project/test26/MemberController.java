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
import ksmart.project.test26.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.GET)
	public String insertMember() {
		logger.debug("insertMember() 메서드 member is {}");
		return "member/memberInsert";
	}

	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.POST)
	public String insertMember(Member member) {
		logger.debug("insertMember(Member member) 메서드 member is {}", member);
		memberService.addMember(member);
		return "redirect:/member/login";
	}

	// update 요청
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.POST)
	public String updateMember(Member member) { 
		memberService.modifyMember(member);
		logger.debug("updateMember(Member member) 메서드 member is {}", member);
		return "redirect:/";
	}

	// 수정페이지 요청, 한 명 조회
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.GET)
	public String selectMemberOne(Model model, @RequestParam(value = "memberNo", required = true) int member) {
		model.addAttribute("Member", memberService);
		logger.debug("selectMemberOne(Model model, @RequestParam(value = \"memberNo\", required = true) int member) 메서드 member is {}", member);
		return "member/memberUpdate";
	}

	// 회원 삭제요청
	@RequestMapping(value = "/member/memberRemove", method = RequestMethod.GET)
	public String deleteMember(HttpSession session, Member member) {
		memberService.removeMember(member);
		logger.debug("deleteMember(HttpSession session, Member member)) 메서드 member is {}", member);
		session.removeAttribute("loginMember");
		return "redirect:/member/login";
	}
	
	// 로그인요청
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		logger.debug("login(Member member, HttpSession session) 메서드 member is {}", member);
		member = memberService.loginCheck(member);
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