package kr.or.ddit.ioc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {
	
	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	
	public static void main(String[] args) {
		
		// 스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:kr/or/ddit/ioc/application-context.xml"
		});
		
		// 스프링 컨테이너에서 boardDao 스프링 빈을 요청(DL : Dependency Lookup)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		
		for(BoardVo bv : boardList) {
			logger.debug("boardVo : {}", bv.toString());
//			System.out.println("boardVo : " + bv.toString());
		}
		
		System.out.println();
		// 스프링 컨테이너에서 boardService 스프링 빈을 요청 후 selectBoardList
		// 결과를 logger를 이용해 console 출력
		BoardServiceInf boardService = context.getBean("boardService", BoardServiceInf.class);
		boardList = boardService.selectBoardList();
		
		for(BoardVo bv : boardList) {
			logger.debug("boardVo : {} ", bv.toString());
		}
		
		System.out.println();
		//생성자 주입을 통해 생성된 boardService 스프링 빈을 요청
		BoardServiceInf boardServiceConst = context.getBean("boardServiceConst", BoardServiceInf.class);
		boardList = boardServiceConst.selectBoardList();
		
		for(BoardVo bv : boardList) {
			logger.debug("boardVo : {} ", bv.toString());
		}
		
		System.out.println();
		// spring scope-prototype test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);
		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);
		
		logger.debug("spring prototype bean test : {}",boardDaoPrototype1==boardDaoPrototype2);
		
		System.out.println();
		// spring scope-singleton test
		BoardDaoInf boardDaoSingleton1 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		BoardDaoInf boardDaoSingleton2 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		
		logger.debug("spring prototype bean test : {}",boardDaoSingleton1==boardDaoSingleton2);
	}
}
