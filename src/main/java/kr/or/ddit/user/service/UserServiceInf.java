package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserServiceInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String user_id);
	
	public UserVo selectUser(UserVo userVo);
	
	/**
	* Method : selectUserPageList
	* 작성자 : pc24
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	public Map<String, Object> selectUserPageList(PageVo pageVo);
	
	/**
	* Method : getUserCnt
	* 작성자 : pc24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	public int getUserCnt();
	
	/**
	* Method : insertUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	public int insertUser(UserVo userVo);
	
	/**
	* Method : deleteUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	public int deleteUser(String userId);
	
	/**
	* Method : updateUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 수정
	*/
	public int updateUser(UserVo userVo);
}
