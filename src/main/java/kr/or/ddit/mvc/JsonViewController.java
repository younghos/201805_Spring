package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class JsonViewController {

	@ModelAttribute
	public void modelAttribute(Model model) {
		// 컬렉션 object정보를 json 문자열로 생성
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		// {rangers : ["brown", "cony", "sally"]};

		model.addAttribute("rangers", rangers);

	}

	// json 응답을 생성하는 url 요청
	// 레인져스 정보를 json으로 응답을 생성
	// http://localhost:8081/rangersJsonView
	@RequestMapping("/rangersJsonView")
	public String rangersJsonView() {
		// "{rangers : [{name:'cony', id:'rabbit}, {name:'brown', id:'bear'}]"

		// json을 생성하는 view(bean id와 동일한 이름을 return)
		return "jsonView";

		// controller에서 리턴하는 viewName(jsonView)를 처리하기 위해
		// 처리해줄 viewResolver를 우선순위에 따라서
		// 1. beanNameViewResolver를 통해 view를 생성하려고 시도하게됨
		// 2. jsonView라고 하는 이름의 빈이 있는지를 확인 ==> 존재
		// 3. 해당 viewName과 동일한 이름의 빈이 있으므로
		// InternalResourceViewResolver 까지 가지 않고 beanNameViewResolver
		// 에서 처리하게 됨

		// 만약 viewName이 'hello'인 경우라면
		// 처리해줄 viewResolver를 우선순위에 따라
		// 1. beanNameViewResolver를 통해 view를 생성하려고 시도하게됨
		// 2. jsonView라고 하는 이름의 빈이 있는지를 확인 ==> 존재하지 않음
		// <bean id="hello" ..... 이런 빈이 있는지 확인
		// 3. 다음 우선순위인 internalResourceViewResolver가 처리하게됨
		// interanlResourceViewResolver는 해당 리소스(hello.jsp)가 있는지 여부를
		// 상관하지 않고 prefix, suffix를 무조건 반영하여 forward 함
		// 그렇기 때문에 오타 또는 존재하지 않는 파일(.jsp)을 리턴하게 되면 에러가 발생함
		// 그런 이유로 internalResourceViewResolver는 viewResolver 설정시
		// 우선순위를 최하위로 둔다.
	}
	
	@RequestMapping("/rangersJsonViewObj")
	public View rangersJsonViewObj() {
		
		// json 생성을 담당하는 view 
		return new MappingJackson2JsonView();
	}

}
