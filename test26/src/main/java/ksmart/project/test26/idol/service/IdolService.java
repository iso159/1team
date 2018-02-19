package ksmart.project.test26.idol.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
		int totalCount = idolDao.selectTotalCount(map);
		// 페이지마다 마지막 표시
		int lastPage = (int)Math.ceil((double)totalCount/(double)rowPerPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("selectIdolList", idolDao.selectIdolList(map));
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
	public void addIdol(IdolCommand idolCommand) {
		// idolCommand 객체안에 정보 확인
		logger.debug("addIdol(IdolCommand idolCommand) 메서드 idolCommand is {}",idolCommand);
		//1.아이돌 추가
		Idol idol = new Idol();
		idol.setIdolName(idolCommand.getIdolTitle());
		// idol 객체안에 정보 확인
		logger.debug("addIdol(IdolCommand idolCommand) 메서드 idol is {}",idol);
		idolDao.insertIdol(idol);
		// lastIdolId 구함
		int lastIdolId = idolDao.selectLastId();
		logger.debug("addIdol(IdolCommand idolCommand) 메서드 lastIdolId is {}",lastIdolId);
		//2.들어온 파일 정보 입력
		for(MultipartFile file : idolCommand.getFile()) {
			IdolFile idolFile = new IdolFile();
			//2-0.마지막에 넣은 아이디 값
			idolFile.setIdolId(lastIdolId);
			//2-1.파일 이름
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();
			logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileName is {}",fileName);
			idolFile.setFileName(fileName);
			//2-2.파일 확장자
			String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileExt is {}",fileExt);
			idolFile.setFileExt(fileExt);
			//2-3.파일 사이즈
			long fileSize = file.getSize();
			logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileSize is {}",fileSize);
			idolFile.setFileSize(fileSize);;
			//2-4.파일 저장
			File temp = new File("c:\\upload\\"+fileName);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			idolDao.insertIdol(idolFile);
		}
	}
	
	/*아이돌 삭제부분*/
	public void removeMovie(int idolId) {
		//idolId 확인
		logger.debug("removeMovie(int idolId) 메서드 idolId is {}",idolId);
		idolDao.deleteIdol(idolId);
	}
}
