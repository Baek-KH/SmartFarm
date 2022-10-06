package com.smartFarm.mes.dao.collectdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartFarm.mes.vo.collectdata.CollectDataService;
import com.smartFarm.mes.vo.collectdata.CollectDataVO;



@Service("CollectDataService")
public class CollectDataServiceImpl implements CollectDataService {
	
	@Autowired
	private CollectDataDAO collectDataDAO;
	



	@Override
	public CollectDataVO getCollectData(CollectDataVO vo) {
		return collectDataDAO.getCollectData(vo);
	}




	@Override
	public List<CollectDataVO> getCollectDataList(CollectDataVO vo) {
		// TODO Auto-generated method stub
		return (List<CollectDataVO>) collectDataDAO.getCollectData(vo);
	}

	

}
