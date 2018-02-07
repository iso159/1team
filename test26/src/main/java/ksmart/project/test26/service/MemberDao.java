package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository를 적으면 객체가 미리 생성되서 CountryDao를 AutoWired로 객체에 주입할수있음
@Repository
public class MemberDao {
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;
   // 쿼리 경로를 상수로 입력
   private final String namespace = "ksmart.project.test26.service.MemberMapper.";

   // country insert
   public void insertMember(Member member) {
      sqlSessionTemplate.insert(namespace + "insertMember", member);
   }

   public Member selectOneMember(int member) {
      return sqlSessionTemplate.selectOne(namespace + "selectMember", member);
   }

   public void updateMember(Member memberNo) {
      sqlSessionTemplate.selectList(namespace + "updateMember", memberNo);
   }

   public void deleteMember(int memberNo) {
      sqlSessionTemplate.selectList(namespace + "deleteMember", memberNo);
   }
}