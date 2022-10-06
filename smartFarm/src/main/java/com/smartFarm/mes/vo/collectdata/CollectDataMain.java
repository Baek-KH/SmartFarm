package com.smartFarm.mes.vo.collectdata;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectDataMain {

	public static void main(String[] args) {
	
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		CollectDataService CollectDataService = (CollectDataService) container.getBean("collectDataService");
		
		CollectDataVO vo = new CollectDataVO();
		vo.setPro_qty(123);
		vo.setPro_price(123);
		vo.setTitle("title");
		CollectDataService.getCollectData(vo);
		
		CollectDataVO collectdata = CollectDataService.getCollectData(vo);
		for(CollectDataVO collectdata) {
			System.out.println(collectdata.toString());
		}
		container.close();
	}

}
