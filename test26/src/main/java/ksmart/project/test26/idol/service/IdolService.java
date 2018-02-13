package ksmart.project.test26.idol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.project.test26.idol.service.Idol;
import ksmart.project.test26.movie.service.MovieService;

@Service
@Transactional
public class IdolService {
	
	@Autowired
	private IdolDao idolDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	/*아이돌 전체리스트 띄우고 페이징 작업*/
	public Map<String, Object> getIdolList(Map<String, Object> map) {
		// map 객체안에 정보 확인 
		logger.debug("getListByPage(Map map) 메서드 map is {}",map);
		Integer currentPage = (Integer) map.get("currentPage");
		Integer rowPerPage = (Integer) map.get("rowPerPage");
		String idolSearchWord = (String) map.get("idolSearchWord");
		// 시작  페이지
		int startRow = (currentPage-1)*rowPerPage;
		// 페이징 작업을 통한 리스트 구함
		map.put("startRow", startRow);
		logger.debug("getListByPage(Map map) 메서드 map is {}",map);
		List<Idol> list = idolDao.selectListByPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("idolSearchWord", idolSearchWord);
		returnMap.put("rowPerPage", rowPerPage);
		returnMap.put("currentPage", currentPage);
		returnMap.put("startRow", startRow);
		returnMap.put("list", list);
		// 데이터 총갯수 구함
		int totalCount = idolDao.selectTotalCount();
		// 페이지마다 마지막 표시
		int lastPage = (int)Math.ceil((double)totalCount/(double)rowPerPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("selectIdolList", idolDao.selectIdolList());
		return returnMap;
	}
	
	/*아이돌 한명정보 띄우는부분*/
	public List<Idol> getIdolOne(int idolId) {
		// idolId 확인
		logger.debug("getIdolOne(int idolId) 메서드 idolId is {}",idolId);
		List<Idol> list = idolDao.selectIdolOne(idolId);
		// list 객체안에 정보 확인
		logger.debug("getIdolOne(int idolId) 메서드 list is {}",list);
		return list;
	}
	
	/*아이돌 수정*/
	public void modifyIdol(Idol idol) {
		// idol 객체안에 정보 확인
		logger.debug("modifyIdol(Idol idol) 메서드 idol is {}",idol);
		idolDao.updateIdol(idol);
	}
	
	/*아이돌 추가*/
	public void addIdol(Idol idol) {
		// idol 객체안에 정보 확인
		logger.debug("addIdol(Idol idol) 메서드 idol is {}",idol);
		idolDao.insertIdol(idol);
	}
	
	/*아이돌 삭제부분*/
	public void removeMovie(int idolId) {
		//idolId 확인
		logger.debug("removeMovie(int idolId) 메서드 idolId is {}",idolId);
		idolDao.deleteIdol(idolId);
	}
}
