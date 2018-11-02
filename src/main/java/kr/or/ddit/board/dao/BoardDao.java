package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;
// 어노테이션을 통한 빈 등록
// bean 어노테이션은 : @Controller, @Service, @Repository, @Component
// @Controller : controller
// @Service : service
// @Respository : dao
// @Component : 일반적인 객체
// @Controller, @Service, @Respository 어노테이션은 @Component 어노테이션 기반으로 확장

// 어노테이션 자체가 특별한 기능을 담고 있는것은 아님
// 개발에 자주 사용되는 모듈을 분리하여 명명한것에 불과
/**
* BoardDao.java
*
* @author pc24
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* pc24 최초 생성
*
* </pre>
*/
// 이름을 생략하면 클래스 첫 글자를 소문자로 한 이름이 spring bean 이름이 됨
@Repository("boardDao")
public class BoardDao implements BoardDaoInf{

	@Override
	public List<BoardVo> selectBoardList() {
		// db에서 조회해 온 데이터라고 가정하자
		BoardVo boardvo = new BoardVo(1, "자유게시판", "brown");
		BoardVo boardvo2 = new BoardVo(1, "공지사항", "cony");
		BoardVo boardvo3 = new BoardVo(1, "FAQ", "sally");
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList.add(boardvo);
		boardList.add(boardvo2);
		boardList.add(boardvo3);
		
		return boardList;
	}

}
