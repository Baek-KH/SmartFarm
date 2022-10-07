package com.smartFarm.web.pip.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartFarm.mes.dao.pip.PipDAO;
import com.smartFarm.mes.vo.pip.PipVO;
import com.smartFarm.web.pip.PipService;


@Service("pipServie")
public class PipServiceImpl implements PipService {
	
	@Autowired
	private PipDAO pipDAO;
	
	@Override
	public void insertpip(PipVO vo) {
		pipDAO.insertPip(vo);
	}

	@Override
	public void deletepip(PipVO vo) {
		pipDAO.deletePip(vo);
	}

	@Override
	public void updatepip(PipVO vo) {
		pipDAO.updatePip(vo);	
	}

	@Override
	public PipVO getPip(PipVO vo) {
		return pipDAO.getPip(vo);
	}												

	@Override
	public List<PipVO> getPipList(PipVO vo) {
		return pipDAO.getPipList(vo);
	}

}
