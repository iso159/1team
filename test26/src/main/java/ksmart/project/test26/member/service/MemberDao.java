package ksmart.project.test26.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository를 적으면 객체가 미리 생성되서 CountryDao를 AutoWired로 객체에 주입할수있음
@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 쿼리 경로를 상수로 입력
	private final String nameSpace = "ksmart.project.test26.member.service.MemberMapper.";

	// country insert
	public void insertMember(Member member) {
		logger.debug("insertMember(Member member) 메서드 member is {}", member);
		sqlSessionTemplate.insert(nameSpace + "insertMember", member);
	}

	public Member selectMemberOne(Member member) { // 여기 매개변수데이터타입 int
		logger.debug("selectOne(int member) 메서드 member is {}", member);
		return sqlSessionTemplate.selectOne(nameSpace + "selectMemberOne", member);
	}

	public void updateMember(Member memberNo) {
		logger.debug("updateMember(Member memberNo) 메서드 member is {}", memberNo);
		sqlSessionTemplate.selectList(nameSpace + "updateMember", memberNo);
	}

	public void deleteMember(Member member) {// 여기 매개변수데이터타입 int
		logger.debug("deleteMember(int memberNo) 메서드 member is {}", member);
		sqlSessionTemplate.selectList(nameSpace + "deleteMember", member);
	}

	// 로그인 확인하는 메소드
	public Member loginget(Member member) {
		logger.debug("loginget(Member member) 메서드 member is {}", member);
		return sqlSessionTemplate.selectOne(nameSpace + "selectgetMember", member);
	}
}