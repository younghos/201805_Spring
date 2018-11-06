package kr.or.ddit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
// controller의 경우 service 스프링 빈을 주입받기 때문에
// service, dao에 대한 설정파일도 필요하다
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml", "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
// 스프링 컨테이너를 웹 기반에서 활용가능 한 WebApplicationContext로 생성
@WebAppConfiguration // mockMvc 객체를 사용하기위해
public class ControllerTestConfig {

	// webApplicationContext ==> mockMvc(dispatcherServlet) 생성을 위해 필요
	
	@Autowired
	private WebApplicationContext ctx;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Ignore
	@Test
	public void test() {
		
	}

}
