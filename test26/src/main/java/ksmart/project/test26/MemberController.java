package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.GET)
	public String insertMember() {
		return "member/memberInsert";
	}

	// insert 회원가입
	@RequestMapping(value = "/member/memberInsert", method = RequestMethod.POST)
	public String insertMember(Member member) {
		memberDao.insertMember(member);
		return "redirect:/login1team/login";
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
		return "redirect:/login1team/login";
	}
}