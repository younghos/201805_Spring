package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class ProdService implements ProdServiceInf{
	
	@Resource(name="prodDao")
	private ProdDaoInf prodDao;
	
	@Override
	public Map<String, Object> selectProdPageList(PageVo pageVo) {
		
		List<ProdVo> prodList = prodDao.selectProdPageList(pageVo); 
		
		int totalProdCnt = prodDao.getProdCnt();
		int pageCnt = (int)Math.ceil(((double)totalProdCnt/pageVo.getPageSize()));
				
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodList);
		resultMap.put("pageCnt", pageCnt);
		
		return resultMap;
	}

	@Override
	public int getProdCnt() {
		return prodDao.getProdCnt();
	}

	@Override
	public ProdVo selectProdDetail(String prod_id) {
		return prodDao.selectProdDetail(prod_id);
	}

}
