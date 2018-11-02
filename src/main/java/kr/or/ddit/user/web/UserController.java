package kr.or.ddit.user.web;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(UserVo userVo, Model model ) {
		String user_id = userVo.getUserId();
		String user_pw = userVo.getPass();
		
		model.addAttribute("userVo", userVo);
		
		if(user_id.equals("brown") && user_pw.equals("brownpass")) {
			return "main";
		} else {
			return "login/login";
		}
	}
}
