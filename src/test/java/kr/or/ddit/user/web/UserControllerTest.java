package kr.or.ddit.user.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends ControllerTestConfig{
	
	/**
	* Method : loginViewTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : loginView test
	 * @throws Exception 
	*/
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/loginView")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		//viewName
		assertEquals("login/login", viewName);
	}
	
	/**
	* Method : loginProcessTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : loginProcess Test
	 * @throws Exception 
	*/
	@Test
	public void loginProcessSuccessTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", "brown").param("pass", "brownpass")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo) mav.getModel().get("userVo");
		
		Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
		
		/***Then***/
		logger.debug("viewName : {}",viewName);
		assertEquals("main", viewName);
		
	}
	@Test
	public void loginProcessFailTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", "brown1").param("pass", "brownpass")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo) mav.getModel().get("userVo");
		
		Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
		
		/***Then***/
		logger.debug("viewName : {}",viewName);
		assertEquals("login/login", viewName);
		
	}

}
