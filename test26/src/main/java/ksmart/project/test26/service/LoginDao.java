package ksmart.project.test26.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.BookController;

@Repository
public class LoginDao {
	private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String NS = "ksmart.project.test26.service.LoginMapper."; // namespace
	
	// 로그인 확인하는 메소드
	public Member loginCheck(Member member) {
		logger.debug("loginCheck 메소드확인{}",member);
		return sqlSessionTemplate.selectOne(NS+"selectCheckMember", member);
	}
	
	
}
