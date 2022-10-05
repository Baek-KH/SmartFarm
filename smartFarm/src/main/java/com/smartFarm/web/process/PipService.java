package com.smartFarm.web.process;

import java.util.List;

import com.smartFarm.mes.vo.process.PipVO;

public interface PipService {

	void insertpip(PipVO vo);
	void deletepip(PipVO vo);
	void updatepip(PipVO vo);
//	pipVO getXXX(pipVO vo);
//	List<pipVO> getXXXList (pipVO vo);		<< 임시
}
