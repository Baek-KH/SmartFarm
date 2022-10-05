package com.smartFarm.mes.commons;

import org.springframework.stereotype.Service;

@Service
public class Log4jAdvice{

	public void printLogging() {
		System.out.println("[공통로그 - Annotation기반 AOP적용 ] 비즈니스 로직 수행전 공통 기능!!!");
	}
}
