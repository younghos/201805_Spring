package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	// @RequestMapping이 붙은 메서드가 실행되기 전에 먼저 실행됨
	// 해당 컨트롤러에서 공통적으로 사용될 속성이 있을 경우
	// 중복을 피하기위해 @modleAttribute 어노테이션을 적용한
	// 메서드를 통해 코드 중복을 막을 수 있음
	@ModelAttribute
	public void setup(Model model) {
		logger.debug("{}", "setup");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("rangers",rangers);
	}
	
	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
		for(String ranger : rangers) {
			logger.debug("ranger : {}", ranger);
		}
		rangers.add("james");
		
		return "mvc/view";
	}
	
	@RequestMapping("/mvc/view2")
	public String mvcView2() {
		return "mvc/view2";
	}
}
