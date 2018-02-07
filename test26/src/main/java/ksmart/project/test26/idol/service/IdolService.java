package ksmart.project.test26.idol.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.project.test26.idol.service.Idol;
import ksmart.project.test26.movie.service.MovieService;

@Repository
@Service
@Transactional
public class IdolService {
	
	@Autowired
	private IdolDao idolDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	public List<Idol> checkIdolList() {
		List<Idol> list = idolDao.selectIdolList();
		// list 객체안에 정보 확인
		logger.debug("checkIdolList() 메서드 list is {}",list);
		return list;
	}
	
	public List<Idol> checkIdolOne(int idolId) {
		// idolId 확인
		logger.debug("checkIdolOne(int idolId) 메서드 idolId is {}",idolId);
		List<Idol> list = idolDao.selectIdolOne(idolId);
		// list 객체안에 정보 확인
		logger.debug("checkIdolOne(int idolId) 메서드 list is {}",list);
		return list;
	}
	
	public void modifyIdol(Idol idol) {
		// idol 객체안에 정보 확인
		logger.debug("modifyIdol(Idol idol) 메서드 idol is {}",idol);
		idolDao.updateIdol(idol);
	}
	
	public void addIdol(Idol idol) {
		// idol 객체안에 정보 확인
		logger.debug("addIdol(Idol idol) 메서드 idol is {}",idol);
		idolDao.insertIdol(idol);
	}
	
	public void removeMovie(int idolId) {
		//idolId 확인
		logger.debug("removeMovie(int idolId) 메서드 idolId is {}",idolId);
		idolDao.deleteIdol(idolId);
	}
}
