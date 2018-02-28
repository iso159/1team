package ksmart.project.test26.idol.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ksmart.project.test26.idol.service.Idol;

@Service
@Transactional
public class IdolService {
	
	@Autowired
	private IdolDao idolDao;
	
	private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	
	/*해당 아이돌 파일 리스트 띄움*/
	public IdolAndIdolFile selectIdolAndIdolFile(int idolId){
		logger.debug("selectIdolAndIdolFile(int idolId) 메서드 idolId is {}",idolId);
		IdolAndIdolFile idolAndIdolFile = idolDao.selectIdolAndIdolFile(idolId);
		logger.debug("selectIdolAndIdolFile(int idolId) 메서드 idolAndIdolFile is {}",idolAndIdolFile);
		return idolAndIdolFile;
	}
	
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
	public Map<String, Object> getIdolOne(int idolId) {
		// idolId 확인
		logger.debug("getIdolOne(int idolId) 메서드 idolId is {}",idolId);
		List<Idol> list = idolDao.selectIdolOne(idolId);
		// list 객체안에 정보 확인
		logger.debug("getIdolOne(int idolId) 메서드 list is {}",list);
		// idolId로 해당 파일정보 불러옴
		IdolAndIdolFile idolAndIdolFile = idolDao.selectIdolAndIdolFile(idolId);
		logger.debug("selectIdolAndIdolFile(int idolId) 메서드 idolAndIdolFile is {}",idolAndIdolFile);
		// idol 정보와 idol 파일 정보를 담음
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("file", idolAndIdolFile);
		return map;
	}
	
	/*아이돌 수정*/
	public void modifyIdol(Idol idol) {
		// idol 객체안에 정보 확인
		logger.debug("modifyIdol(Idol idol) 메서드 idol is {}",idol);
		idolDao.updateIdol(idol);
	}
	
	/*아이돌 추가*/
	public void addIdol(IdolCommand idolCommand, String path) {
		// idolCommand 객체안에 정보 확인
		logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 idolCommand is {}",idolCommand);
		//1.아이돌 추가
		Idol idol = new Idol();
		idol.setIdolName(idolCommand.getIdolTitle());
		// idol 객체안에 정보 확인
		logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 idol is {}",idol);
		idolDao.insertIdol(idol);
		// 만약 파일이 안들어 왔을경우 확인
		boolean isfind = false;
		for(MultipartFile l : idolCommand.getFile()) {
			// .isEmpty() 를 통해 파일이 들어왔을경우 false를 대입
			isfind = l.isEmpty();
		}
		// 파일이 안들어왔을경우 실행하지 않음
		if(isfind==false) {
			// lastIdolId 구함
			int lastIdolId = idolDao.selectLastId();
			logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 lastIdolId is {}",lastIdolId);
			//2.들어온 파일 정보 입력
			for(MultipartFile file : idolCommand.getFile()) {
				IdolFile idolFile = new IdolFile();
				//2-0.마지막에 넣은 아이디 값
				idolFile.setIdolId(lastIdolId);
				//2-1.파일 이름
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString();
				logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 fileName is {}",fileName);
				idolFile.setFileName(fileName);
				//2-2.파일 확장자
				String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
				logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 fileExt is {}",fileExt);
				idolFile.setFileExt(fileExt);
				//2-3.파일 사이즈
				long fileSize = file.getSize();
				logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 fileSize is {}",fileSize);
				idolFile.setFileSize(fileSize);;
				//2-4.파일 저장
				
				//폴더 없을경우 폴더 생성
				
				//path 확인 
				logger.debug("addIdol(IdolCommand idolCommand, String path) 메서드 path is {}",path);
				File temp = new File(path+"\\upload\\"+fileName);
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
		}
	
	/*아이돌 삭제부분*/
	public void removeidol(int idolId, String path) {
		//idolId 확인
		logger.debug("removeidol(int idolId) 메서드 idolId is {}",idolId);
		//삭제하기 전에 파일 있는지 확인
		if(idolDao.selectIdolAndIdolFile(idolId) != null) {
			IdolAndIdolFile idolAndIdolFile = idolDao.selectIdolAndIdolFile(idolId);
			List<IdolFile> list = idolAndIdolFile.getFile();
			for(IdolFile i : list) {
				String fileName = i.getFileName();
	    		File file = new File(path+"\\upload\\"+fileName);
	    			if(file.exists() == true){
	    			file.delete();
	    		}
			}
			idolDao.deleteIdolFile(idolId);
		}
		idolDao.deleteIdol(idolId);
	}
	
	/*아이돌 파일 다운로드 부분*/
	public ModelAndView idolFileDownload(HttpServletRequest request,String path, String fileName, String fileExt) {
		logger.debug("idolFileDownload(String path, String fileName) 메서드 실행 paht is {}", path);
		logger.debug("idolFileDownload(String path, String fileName) 메서드 실행 fileName is {}", fileName);
		logger.debug("idolFileDownload(String path, String fileName) 메서드 실행 fileExt is {}", fileExt);
		idolDao.idolFileDownload();
		// 경로 + 다운받을 파일이름을 file에 입력
		File file = new File(path+fileName);
		logger.debug("idolFileDownload(String path, String fileName) 메서드 실행 file is {}", file);
		// 입력한 파일을 읽을수 없다면 if블록실행
		if(!file.canRead()) {
			logger.debug("{} 파일을 찾지 못했습니다.",file);
			return new ModelAndView("fileDownloadView", "file",file);
		}
		// 원본 파일명 request에 셋팅
		request.setAttribute("fileName", fileName);
		// 확장자명을 더해서 파일 셋팅
		File reFile = new File(path+fileName+fileExt);
		logger.debug("idolFileDownload(String path, String fileName) 메서드 실행 reFile is {}", reFile);
		try {
			// 파일이 있다면 if블록실행
			if(file.exists()) {
				// 확장자명을 더한 파일명으로 수정
				file.renameTo(reFile);
				// 확장자명을 더한 파일을 request에 셋팅
				request.setAttribute("reFile", reFile);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("fileDownloadView", "file",reFile);
	}
}
