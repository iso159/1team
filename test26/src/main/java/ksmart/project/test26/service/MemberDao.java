package ksmart.project.test26.service;

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
	private final String namespace = "ksmart.project.test26.service.MemberMapper.";

	// country insert
	public void insertMember(Member member) {
		logger.debug("insertMember(Member member) 메서드 member is {}", member);
		sqlSessionTemplate.insert(namespace + "insertMember", member);
	}

	public Member selectMemberOne(Member member) { // 여기 매개변수데이터타입 int
		logger.debug("selectOne(int member) 메서드 member is {}", member);
		return sqlSessionTemplate.selectOne(namespace + "selectMemberOne", member);
	}

	public void updateMember(Member memberNo) {
		logger.debug("updateMember(Member memberNo) 메서드 member is {}", memberNo);
		sqlSessionTemplate.selectList(namespace + "updateMember", memberNo);
	}

	public void deleteMember(Member member) {// 여기 매개변수데이터타입 int
		logger.debug("deleteMember(int memberNo) 메서드 member is {}", member);
		sqlSessionTemplate.selectList(namespace + "deleteMember", member);
	}

	// 로그인 확인하는 메소드
	public Member loginCheck(Member member) {
		logger.debug("loginCheck(Member member) 메서드 member is {}", member);
		return sqlSessionTemplate.selectOne(namespace + "selectCheckMember", member);
	}
}