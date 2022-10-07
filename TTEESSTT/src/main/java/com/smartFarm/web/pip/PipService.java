package com.smartFarm.web.pip;

import java.util.List;

import com.smartFarm.mes.vo.pip.PipVO;

public interface PipService {

	void insertpip(PipVO vo);
	void deletepip(PipVO vo);
	void updatepip(PipVO vo);
	PipVO getPip(PipVO vo);
	List<PipVO> getPipList(PipVO vo);
	
}
