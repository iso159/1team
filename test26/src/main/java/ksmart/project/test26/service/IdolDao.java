package ksmart.project.test26.service;

import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/*아이돌 전체리스트 띄우는부분*/
	public List<Idol> seleteIdol(){
		return sqlSessionTemplate.selectList("ksmart.project.test26.service.IdolMapper.selectIdol");
	}
	
	/*아이돌 한명정보 띄우는부분*/
	public List<Idol> seleteOneIdol(int idolId) {
		return sqlSessionTemplate.selectList("ksmart.project.test26.service.IdolMapper.selectIdolOne", idolId);
	}
	
	/*아이돌 수정*/
	public void updateIdol(Idol idol) {
		sqlSessionTemplate.update("ksmart.project.test26.service.IdolMapper.updateIdol", idol);
	}
}
