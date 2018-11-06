package kr.or.ddit.file.util;

public class FileUtil {

	// FileUtil.getFileExt(String fileName);
	// 확장자가 있을 경우 '.'을 포함한 확장자 값을 리턴
	// 확장자가 없을 경우 "" whitespace 리턴
	// 테스트 값 : sally.png ==> .png
	// 테스트 값 : sally ==> ""

	/**
	 * Method : getFileExt 작성자 : pc24 변경이력 :
	 * 
	 * @param fileName
	 * @return Method 설명 : 파일 확장자 추출
	 */
	public static String getFileExt(String fileName) {

		int index = fileName.lastIndexOf(".");

		if (index != -1) {
			String ext = fileName.substring(index);
			return ext;
		} else {
			return "";
		}
	}
}
