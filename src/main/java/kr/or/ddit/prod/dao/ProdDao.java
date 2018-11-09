package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProdDao implements ProdDaoInf{

	@Override
	public List<ProdVo> selectProdPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> pageList = session.selectList("prod.selectProdPageList", pageVo);
		session.close();
		
		return pageList;
	}

	@Override
	public int getProdCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalProdCnt = session.selectOne("prod.getProdCnt");
		session.close();
		
		return totalProdCnt;
	}

	@Override
	public ProdVo selectProdDetail(String prod_id) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVo prodVo = session.selectOne("prod.selectProdDetail", prod_id);
		
		session.close();
		
		return prodVo;
	}

}
