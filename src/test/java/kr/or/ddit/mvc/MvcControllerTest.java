package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

public class MvcControllerTest extends ControllerTestConfig{

	@Test
	public void mvcViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		
		/***Then***/
		assertEquals("mvc/view", viewName);
		assertEquals(3, rangers.size());
	}
	
	@Test
	public void mvcView2Test() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view2")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		
		/***Then***/
		assertEquals("mvc/view2", viewName);
		assertEquals(3, rangers.size());
	}
	
	@Test
	public void fileuploadViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/fileupload")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("mvc/fileuploadView", mav.getViewName());
		
	}

}
