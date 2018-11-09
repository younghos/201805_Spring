package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public interface ProdDaoInf {

	public List<ProdVo> selectProdPageList(PageVo pageVo);
	
	public int getProdCnt();
	
	public ProdVo selectProdDetail(String prod_id);
	
}
