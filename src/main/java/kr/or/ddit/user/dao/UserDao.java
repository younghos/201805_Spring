package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserDaoInf{
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> list = session.selectList("user.selectUserAll");
		session.close();
		
		return list;
	}
	
	public UserVo selectUser(String user_id){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userVo = session.selectOne("user.selectUser", user_id); 
		session.close();
		
		return userVo;
	}

	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userVo2 = session.selectOne("user.selectUserByVo", userVo);
		session.close();
		
		return userVo2;
	}
	
	public List<UserVo> selectUserPageList(PageVo pageVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> pageList = session.selectList("user.selectUserPageList", pageVo);
		session.close();
		
		return pageList;
	}
	
	/**
	* Method : getUserCnt
	* 작성자 : pc24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("user.insertUser", userVo);
		
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : deleteUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("user.deleteUser", userId);
		
		session.commit();
		session.close();
		
		return deleteCnt;
	}

	/**
	* Method : updateUser
	* 작성자 : pc24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 수정 
	*/
	@Override
	public int updateUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("user.updateUser", userVo);
		
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
	
}
