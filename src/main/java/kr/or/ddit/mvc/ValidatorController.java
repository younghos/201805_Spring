package kr.or.ddit.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserVoJsr;
import kr.or.ddit.user.model.UserVoValidator;

@RequestMapping("/validator")
@Controller
public class ValidatorController {

	// 1. validator를 테스트할 view(/WEB-INF/view/validator/view.jsp)
	// HttpMethod : get방식
	@RequestMapping(value= {"/view"}, method= {RequestMethod.GET})
	public String view() {
		return "validator/view";
	}
	
	// 2. view에서 입력한 값을 처리할 method
	// 검증절차에서 문제가 있을 경우 최초 테스트 view로 가서 메세지를 출력
	// 검증절차에서 문제가 없을 경우 result.jsp로 이동
	// HttpMethod : post방식
	
	// BindingResult 객체는 검증하고자하는 vo객체 뒤에 메소드 인자로 넣어야함
	// ★메서드 인자 순서 주의★
	@RequestMapping(value= {"/validate"}, method= {RequestMethod.POST})
	public String validate(UserVo userVo, BindingResult bindingResult, Model model) {
		new UserVoValidator().validate(userVo, bindingResult);
		if(bindingResult.hasErrors()) {
			return "validator/view";
		}
		model.addAttribute("userVo",userVo);
		return "validator/result";
	}
	
	@RequestMapping(value= {"/validateJsr"}, method= {RequestMethod.POST})
	public String validateJsr(@Valid UserVoJsr userVoJsr, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "validator/view";
		}
		model.addAttribute("userVoJsr",userVoJsr);
		return "validator/result";
	}
	
}
