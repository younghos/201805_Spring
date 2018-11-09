package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringMessageController {

	@RequestMapping(value= {"/messageView"})
	public String messageView() {
		return "msg/view";
	}
}
