package kr.or.ddit.file.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

public class FileDaoTest extends ServiceDaoTestConfig{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 파일정보 입력 테스트
	*/
	@Test(timeout = 5000) //5초안에 테스트가 실행돼야지 성공으로 간주
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setS_file_name("565420fb-3eec-44aa-84b5-85945e331736.png");
		fileVo.setS_org_file_name("sally.png");
		fileVo.setS_file_ext(".png");
		fileVo.setS_file_path("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload");

		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}

}
