package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileServiceTest {

	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Test
	public void fileServiceTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setS_file_name("565420fb-3eec-44aa-84b5-85945e331737.png");
		fileVo.setS_org_file_name("sally.png");
		fileVo.setS_file_ext(".png");
		fileVo.setS_file_path("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload");
		
		/***When***/
		int insertCnt = fileService.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}
