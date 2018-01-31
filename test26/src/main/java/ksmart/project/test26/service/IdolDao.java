package ksmart.project.test26.service;

import java.util.List;

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
}
