package ksmart.project.test26.idol.service;

import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.movie.service.MovieDao;

//@Repository를 적게되면 객체가 미리 생성되서 IdolDao를 AutoWired로 객체에 주입할수있음
@Repository
public class IdolDao {
	//@Autowired를 통해서 new를 사용하지 않고 서버실행할때 been객체를 통해 생성된걸 사용
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Logger 를 이용해서 콘솔창으로 확인
	private static final Logger logger = LoggerFactory.getLogger(IdolDao.class);
	private final String nameSpace = "ksmart.project.test26.idol.service.IdolMapper.";
	
	/*아이돌 전체리스트 띄우는부분*/
	public List<Idol> selectIdolList(){
		// idol 전체 리스트를 리턴 받아서 list 에대입
		List<Idol> list = sqlSessionTemplate.selectList(nameSpace + "selectIdolList");
		// idol 전체 리스트가 list에 받아 졌는지 출력
		logger.debug("selectIdolList() 메서드 list is {}",list);
		return list;
	}
	
	/*아이돌 한명정보 띄우는부분*/
	public List<Idol> selectIdolOne(int idolId) {
		// 받아온 idolId 출력
		logger.debug("selectIdolOne(int idolId) 메서드 idolId is {}",idolId);
		// idolId 값을 받아서 해당 정보 출력
		List<Idol> list = sqlSessionTemplate.selectList(nameSpace + "selectIdolOne", idolId);
		logger.debug("selectIdolOne(int idolId) 메서드 list is {}", list);
		return list;
	}
	
	/*아이돌 수정*/
	public void updateIdol(Idol idol) {
		// 받아온 idlo 객체 확인
		logger.debug("updateIdol(Idol idol) 메서드 idol is {}",idol);
		// idol 객체 정보를 확인 하고 데이터베이스 수정
		sqlSessionTemplate.update(nameSpace + "updateIdol", idol);
	}
	
	/*아이돌 추가*/
	public void insertIdol(Idol idol) {
		// 받아온 idol 객체 확인
		logger.debug("insertIdol(Idol idol) 메서드 idol is {}",idol);
		// idol 객체 정보를 확인 하고 데이터베이스 수정
		sqlSessionTemplate.insert(nameSpace + "insertIdol", idol);
	}
	
	/*아이돌 삭제부분*/
	public void deleteIdol(int idolId) {
		// 받아온 idolId 확인
		logger.debug("deleteIdol(int idolId) 메서드 idolId is {}",idolId);
		// idolId 확인하고 해당 정보 삭제
		sqlSessionTemplate.delete(nameSpace + "deleteIdol", idolId);
	}
}
