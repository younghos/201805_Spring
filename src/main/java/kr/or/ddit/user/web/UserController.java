package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {

	@Resource(name = "userService")
	private UserServiceInf userService;

	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(UserVo userVo, Model model) {
		String user_id = userVo.getUserId();
		String user_pw = userVo.getPass();

		model.addAttribute("userVo", userVo);

		if (user_id.equals("brown") && user_pw.equals("brownpass")) {
			return "main";
		} else {
			return "login/login";
		}
	}

	/**
	 * Method : userAllList 작성자 : pc24 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 조회
	 */
	@RequestMapping("userAllList")
	public String userAllList(Model model) {
		List<UserVo> userList = userService.selectUserAll();

		model.addAttribute("userList", userList);

		return "user/userAllList";
	}

	/**
	 * Method : userPageList 작성자 : pc24 변경이력 :
	 * 
	 * @param model
	 * @return Method 설명 : 사용자 전체 조회(페이징처리)
	 */
	@RequestMapping("/userPageList")
	public String userPageList(/*Model model, PageVo pageVo*/) {

		// spring 컨테이너로부터 bean을 주입받기 때문에 new 연산자를 통해 생성할 필요 없음
//		PageVo pageVo = new PageVo();
//		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
//		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));

//		Map<String, Object> resultMap = service.selectUserPageList(pageVo);
//
//		// 페이지 리스트
//		List<UserVo> pageList = (List<UserVo>) resultMap.get("userList");
//
//		// 페이지 건수
//		int pageCnt = (int) resultMap.get("pageCnt");
//
//		// request 객체에 저장
//		request.setAttribute("pageList", pageList);
//		request.setAttribute("pageCnt", pageCnt);
		
//		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
//		model.addAllAttributes(resultMap);

		return "user/userPagingList";
	}
	
	@RequestMapping("/userPageListAjax")
	public String userPageListAjax(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	@RequestMapping("/userPageListAjaxHtml")
	public String userPageListAjaxHtml(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/pageListHtml";
	}
	
	@RequestMapping("/userPagenationAjaxHtml")
	public String userPagenationAjaxHtml(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/pagenationHtml";
	}
	
	
	@RequestMapping("/userDetail")
	public String userDetail(Model model, @RequestParam("userId")String userId) {
		//String userId = request.getParameter("userId");
		// => @RequestParam 어노테이션을 통해 설정
		
//		UserServiceInf service = new UserService();
//		UserVo userVo = service.selectUser(userId);
		
		UserVo userVo = userService.selectUser(userId);
		
//		request.setAttribute("userVo", userVo);
		model.addAttribute(userVo);
		
		return "user/userDetail";
	}
	
	@RequestMapping(value= {"/userForm"}, method= {RequestMethod.GET})
	public String userFormView() {
		return "user/userForm";
	}
	
	@RequestMapping(value= {"/userForm"}, method= {RequestMethod.POST})
	public String userFormInsert(UserVo userVo, @RequestPart("profilePic")MultipartFile part, HttpServletRequest request) {
		
		try {
			if(part.getSize() > 0) {
				String fileName = part.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/profile");
				
				userVo.setProfile("/profile/"+fileName);
				part.transferTo(new File(path + File.separator + fileName));
			} else {
				userVo.setProfile("");
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		
		if(insertCnt != 0) {
			return "redirect:/user/userPageList?page=1&pageSize=10";
		} else {
			return "user/userForm";
		}
	}
	
	@RequestMapping(value= {"/userUpdateForm"}, method= {RequestMethod.GET})
	public String userUpdateForm(@RequestParam("userId")String userId, Model model) {
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute(userVo);
		
		return "user/userUpdateForm";
	}
	
	@RequestMapping(value= {"/userUpdateForm"}, method= {RequestMethod.POST})
	public String userUpdate(UserVo user, @RequestPart("profilePic")MultipartFile part, HttpServletRequest request) {
		UserVo userVo = userService.selectUser(user.getUserId());
		String profile = "";
		try {
			if(part.getSize() <= 0) {
				profile = userVo.getProfile();
			} else {
				String fileName = part.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/profile");
				
				profile = "/profile/"+fileName;
				part.transferTo(new File(path + File.separator + fileName));
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		user.setProfile(profile);
		
		int updateCnt = userService.updateUser(user);
		
		if(updateCnt !=0) {
			return "redirect:/user/userPageList?page=1&pageSize=10";
		} else {
			return "user/userUpdateForm";
		}
		
	}
}
