package kr.or.ddit.file.util;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.file.util.FileUtil;

public class FileTest {

	/**
	* Method : test1
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출 테스트(확장자 있는 경우)
	*/
	@Test
	public void test1() {
		/***Given***/
		String fileName = "sally.png";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);
		/***Then***/
		assertEquals(".png", ext);
	}
	
	/**
	* Method : test2
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출 테스트(확장자 없는 경우)
	*/
	@Test
	public void test2() {
		/***Given***/
		String fileName = "sally";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);
		/***Then***/
		assertEquals("", ext);
	}
	
	/**
	* Method : test3
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출 테스트(확장자가 있는 경우, 파일명에 점이 들어가는 경우)
	*/
	@Test
	public void test3() {
		/***Given***/
		String fileName = "sally.brown.png";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);
		/***Then***/
		assertEquals(".png", ext);
	}

}
