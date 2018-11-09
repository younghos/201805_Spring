package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserDaoTest extends ServiceDaoTestConfig{

	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	private final String TEST_USER_ID = "testUser";
	
	@Before
	public void setup(){
		userDao.deleteUser(TEST_USER_ID);
	}
	
	@Test
	public void getSelectUserAllTest() {
		/***Given : 주어진 상황***/
		
		/***When : 어떤 동작 수행(메소드)***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println("list : "+list);
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(105, list.size());
	}
	
	@Test
	public void getSelectUserTest(){
		/***Given***/

		/***When***/
		UserVo userVo = userDao.selectUser("brown");

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
		
		UserVo userVo2 = userDao.selectUser(userVo);
		
		/***Then***/
		assertNotNull(userVo2);
		assertEquals("브라운", userVo2.getName());
		assertEquals("brown", userVo2.getUserId());
	}
	
	// 게시글 입력
	// 제목, 내용 -> board 클래스
	// 첨부파일 -> boardFile 클래스
	
	@Test
	public void getSelectUserPageListTest(){
		/***Given***/

		/***When***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		List<UserVo> pageList = userDao.selectUserPageList(pageVo);
		
		/***Then***/
		assertEquals(10, pageList.size());

	}
	
	/**
	* Method : getUserCntTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest(){
		/***Given***/

		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		/***Then***/
		assertEquals(105, totalUserCnt);
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
//		userVo.setProfile("/path");

		/***When***/
		int insertCnt = userDao.insertUser(userVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
//	/**
//	* Method : deleteUserTest
//	* 작성자 : pc24
//	* 변경이력 :
//	* Method 설명 : 사용자 삭제 테스트
//	*/
//	@Test
//	public void deleteUserTest(){
//		/***Given***/
//		String userId = "testUser";
//
//		/***When***/
//		int deleteCnt = userDao.deleteUser(userId);
//		
//		/***Then***/
//		assertEquals(1, deleteCnt);
//	}
	
	@Test
	public void updateUserTest(){
		/***Given***/
		// userVo 생성
		UserVo userVo = new UserVo();
//		userVo.setProfile("null");
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
		int updateCnt = userDao.updateUser(userVo);
		
		/***Then***/
		assertEquals(1, updateCnt);

	}

}
