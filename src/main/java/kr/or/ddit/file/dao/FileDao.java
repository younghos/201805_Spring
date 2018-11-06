package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

// spring bean 등록 : @Repository(이름을 안붙이면 class명에서 앞글자만 소문자로 변경한 텍스트가 spring bean 이름)
@Repository // fileDao
public class FileDao implements FileDaoInf{
	
	private SqlSessionFactory sessionFactory;
	
	public FileDao() {
		sessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	}
	
	/**
	* Method : insertFile
	* 작성자 : pc24
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 정보 저장
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		SqlSessionFactory sessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		
		int insertCnt = session.insert("file.insertFile", fileVo);
		
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	// 명시적 트랜잭션 : 개발자가 commit, rollback 직접 명령
	// 선언적 트랜잭션 : 특정환경에서 트랜잭션이 이루어지도록 
	// (Service 이름을 갖은 객체의 모든 메서드에서 트랜잭션이 이루어지도록 예외가 발생하지 않으면 자동커밋 RuntimeException이 발생하면 자동 rollback)

}
