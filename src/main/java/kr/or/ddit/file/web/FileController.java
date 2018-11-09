package kr.or.ddit.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;

@RequestMapping("/file")
@Controller
public class FileController {

	@Resource(name="userService")
	private UserServiceInf userService;
	
	@RequestMapping(value= {"/fileDownload"}, method= {RequestMethod.GET})
	public void fileDownload(@RequestParam("userId")String userId, HttpServletResponse response) throws IOException {
		UserVo userVo = userService.selectUser(userId);
		
		File file = new File(userVo.getProfile());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		int length = 0;
		
		ServletOutputStream sos = response.getOutputStream();
		
		while((length = fis.read(buffer)) != -1){
			sos.write(buffer, 0, length);
		}
		
		sos.close();
		fis.close();
		
	}
}
