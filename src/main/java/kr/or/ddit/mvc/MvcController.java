package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

//@ModelAttribute에 의해 저장된 속성이 있을 경우
// 재요청시 @ModelAttribute가 적용된 메서드를 재실행하지 않고
// 세션에 저장하여 값을 재활용(잘 변경되지 않는 값을 저장할 경우 메서드가 매번 호출되는 과부화를 줄일 수 있다.)
@SessionAttributes("rangers")
@Controller
public class MvcController { 
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	// @RequestMapping이 붙은 메서드가 실행되기 전에 먼저 실행됨
	// 해당 컨트롤러에서 공통적으로 사용될 속성이 있을 경우
	// 중복을 피하기위해 @modleAttribute 어노테이션을 적용한
	// 메서드를 통해 코드 중복을 막을 수 있음
	@ModelAttribute(value="rangers")
//	public void setup(Model model) {
	public List<String> setup(Model model) {
		logger.debug("{}", "setup");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
//		model.addAttribute("rangers",rangers);
		
		return rangers;
	}
	
	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
//		for(String ranger : rangers) {
//			logger.debug("ranger : {}", ranger);
//		}
//		rangers.add("james");
		
		return "mvc/view";
	}
	
	@RequestMapping("/mvc/view2")
	public String mvcView2() {
		return "mvc/view2";
	}
	
	//@pathVariable : 요청 url의 일부를 메서드 인자로 쉽게 받을 수 있는 어노테이션
	// http://localhost:8081/mvc/central : logger central
	@RequestMapping("/mvc/{libcd}")
	public String pathVariable(@PathVariable("libcd") String libcd) {
		logger.debug("libcd : {}", libcd);
		return "mvc/view";
	}
	
	// fileupload 테스트를 위한 view (get 방식 전송)
	@RequestMapping(value="/mvc/fileupload", method= {RequestMethod.GET})
	public String fileuploadView() {
		return "mvc/fileuploadView";
	}
	
	//fileupload (파일 전송)을 처리 하기위한 contorller method(post)
	@RequestMapping(value="/mvc/fileupload", method= {RequestMethod.POST})
	public String fileupload(@RequestPart("uploadFile") MultipartFile part, @RequestParam("userId")String userId) {
		
		logger.debug("requestParam userId : {}", userId);
		
		logger.debug("partSize : {}",part.getSize());
		logger.debug("partFileName : {}",part.getOriginalFilename());
		
		//1. file 객체 생성(경로 + 파일명 ==> 파일명 충돌방지를 위해 유니크 한 임의의 파일명을 생성)
	
		String path = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload";
		String orginalFileName = part.getOriginalFilename(); // 사용자가 업로드한 실제 파일명
		String fileExt = FileUtil.getFileExt(orginalFileName);
		String fileName = UUID.randomUUID().toString() + fileExt; // 충돌 방지를 위한 임의의 파일명
		
		File file = new File(path + File.separator + fileName);
		
		FileVo fileVo = new FileVo();
		fileVo.setS_file_name(fileName);
		fileVo.setS_file_path(path);
		fileVo.setS_org_file_name(orginalFileName);
		fileVo.setS_file_ext(fileExt);
		
		logger.debug("fileVo : {}", fileVo);
		
		try {
			if(part.getSize() > 0) {
				// 정해진 path에 업로드 파일을 작성
				part.transferTo(file);
				
				// 데이터 베이스에 첨부파일 정보 저장
				// 1. fileService 
				// 2. 로직호출
				int insertCnt = fileService.insertFile(fileVo);
				if(insertCnt != 0) {
					logger.debug("file 저장 성공");
				} else {
					logger.debug("file 저장 실패");
				}
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mvc/fileuploadView";
	}
	
	
	
}
