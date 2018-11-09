package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest extends ServiceDaoTestConfig{
	
	// junit 실행주기
	// @BeforeClass 이 적용된 메서드 실행(최초 1회) 단, static 메서드로 선언
	// @Before 어노테이션이 적용된 메서드 실행(테스트 메서드 실행전 실행)
	// @Test 
	// @After 어노테이션이 적용된 메서드 실행(테스트 메서드 실행 후 실행)
	// @AfterClass 어노테이션이 적용된 메서드 실행(최초 1회) 단, static 메서드로 선언

	// beforeClass
	// before -> Test( selectUserAll ) -> after
	// before -> Test( selectUser(String) ) -> after
	// before -> Test( selectUser(UserVo) ) -> after
	// afterClass
	
	@Resource(name="userService")
	private UserServiceInf userService;
	private final String TEST_USER_ID = "testUser";
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		userService.deleteUser(TEST_USER_ID);
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	@Test
	public void getSelectUserAllTest() {
		/***Given : 주어진 상황***/

		/***When : 어떤 동작 수행(메소드)***/
		List<UserVo> list = userService.selectUserAll();
		System.out.println("list : "+list);
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(105, list.size());
	}
	
	@Test
	public void getSelectUserTest(){
		/***Given***/

		/***When***/
		UserVo userVo = userService.selectUser("brown");

		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	
	@Test
	public void getSelectUserByVoTest(){
		/***Given***/

		/***When***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		
		UserVo userVo2 = userService.selectUser(userVo);
		
		/***Then***/
		assertNotNull(userVo2);
		assertEquals("브라운", userVo2.getName());
		assertEquals("brown", userVo2.getUserId());
	}
	
	@Test
	public void getSelectUserPageListTest(){
		/***Given***/
		
		/***When***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		Map<String, Object> pageList = userService.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>) pageList.get("userList");
		
		/***Then***/
		assertEquals(10, userList.size());

	}
	
	/**
	* Method : insertUserTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	*/
	@Test
	public void insertUserTest(){
		/***Given***/
		// userVo 생성
		UserVo userVo = new UserVo();
		userVo.setUserId("testUser");
		userVo.setName("testName");
		userVo.setPass("testPass");
		userVo.setAddr1("testAddr1");
		userVo.setAddr2("testAddr2");
		userVo.setZipcd("11111");
		String str = "2018-10-12";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(str);
			userVo.setBirth(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		userVo.setEmail("testUser@gmail.com");
		userVo.setTel("042-1111-2222");

		/***When***/
		int insertCnt = userService.insertUser(userVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
}
