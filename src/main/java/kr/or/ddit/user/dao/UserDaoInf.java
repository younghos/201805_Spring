package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserDaoInf {
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String user_id);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	public int getUserCnt();
	
	public int insertUser(UserVo userVo);
	
	public int deleteUser(String userId);
	
	public int updateUser(UserVo userVo);
}
