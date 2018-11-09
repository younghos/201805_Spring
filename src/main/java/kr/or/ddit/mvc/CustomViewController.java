package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kr.or.ddit.mvc.view.TimesTablesView;

@Controller
public class CustomViewController {
	
	// http://localhost:8081/customView
	@RequestMapping("/customView")
	public View customView() {
		return new TimesTablesView();
	}
	
	@RequestMapping("/customViewBeanName")
	public String customViewBeanName(@RequestParam("table")int table, Model model) {
		model.addAttribute("table", table);
		return "timesTableView";
	}

}
