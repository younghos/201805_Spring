package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-placeHolder.xml"})
public class PlaceHolderTest {

	@Resource(name="placeHolder")
	private PlaceHolder placeHolder;
	
	/**
	* Method : PlaceHolderTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 
	*/
	@Test
	public void PlaceHolderTest() {
		/***Given***/
		

		/***When***/
		
		/***Then***/
		assertNotNull(placeHolder);
		assertEquals("pc24", placeHolder.getUser());
		assertEquals("java", placeHolder.getPassword());
		assertEquals("oracle.jdbc.driver.OracleDriver", placeHolder.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", placeHolder.getUrl());
	}

}
