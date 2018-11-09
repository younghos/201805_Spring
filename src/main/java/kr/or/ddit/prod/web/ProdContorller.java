package kr.or.ddit.prod.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/prod")
@Controller
public class ProdContorller {

	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@RequestMapping(value= {"/prodPageList"}, method= {RequestMethod.GET})
	public String prodList(PageVo pageVo, Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "prod/prodPagingList";
	}
	
	@RequestMapping(value= {"/prodDetail"}, method= {RequestMethod.GET})
	public String prodDetail(@RequestParam("prodId")String prodId, Model model) {
		
		ProdVo prodVo = prodService.selectProdDetail(prodId);
		System.out.println("prodVo : " + prodVo);
		
		model.addAttribute(prodVo);
		
		return "prod/prodDetail";
	}
	
	@RequestMapping("/prodPageListHtml")
	public String prodPageListHtml(PageVo pageVo, Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "prod/pageListHtml";
	}
	
	@RequestMapping("/prodPagenationHtml")
	public String prodPagenationHtml(PageVo pageVo, Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "prod/pagenationHtml";
	}
	
	@RequestMapping("/prodPageListJson")
	public String prodprodPageListJson(PageVo pageVo, Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	
}
