package ksmart.project.test26.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	public Member serviceMemberOne(Member member) {
		// 매개변수 member 값 확인
		logger.debug("getMemberOne(Member member) 메서드 member is {}", member);
		Member getMember = memberDao.selectMemberOne(member);
		return getMember;
	}

	public void addMember(Member member) {
		// 매개변수 member 값 확인
		logger.debug("addMember(Member member) 메서드 member is {}", member);
		// 입력 메서드 호출
		memberDao.insertMember(member);
	}

	public void modifyMember(Member member) {
		// 매개변수 member 값 확인
		logger.debug("modifyMember(Member member) 메서드 member is {}", member);
		// 국가 수정 메서드 호출
		memberDao.updateMember(member);
	}
	
	public void removeMember(Member member) {
		// 매개변수 member 값 확인
		logger.debug("removeMember(Member member) 메서드 member is {}",member);
		// 국가 삭제 메서드 호출
		memberDao.deleteMember(member);
	}
	
	public Member loginget(Member member) {
		Member getMember = memberDao.loginget(member);
		logger.debug("loginget(Member member) 메서드 member is {}",member);
		return getMember;		
	}

}
