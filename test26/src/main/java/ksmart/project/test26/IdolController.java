package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolController {
	@Autowired
	private IdolDao idolDao;
	
	/*idol 리스트로 연결해서 전체 띄움*/
	@RequestMapping(value="/idol/idolList")
	public String idolList(Model model) {
		List<Idol> list = idolDao.seleteIdol();
		model.addAttribute("list", list);
		return "idol/idolList";
	}
}
