package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class UserService implements UserServiceInf{

	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	@Override
	public List<UserVo> selectUserAll() {
		return userDao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String user_id) {
		return userDao.selectUser(user_id);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return userDao.selectUser(userVo);
	}

	/**
	* Method : selectUserPageList
	* 작성자 : pc24
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		
		// 페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> userList = userDao.selectUserPageList(pageVo);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();
		int pageCnt = (int) Math.ceil(((double)totalUserCnt / pageVo.getPageSize()));
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", pageCnt);
		
		return resultMap;
	}

	@Override
	public int getUserCnt() {
		return userDao.getUserCnt();
	}

	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}
	
}
