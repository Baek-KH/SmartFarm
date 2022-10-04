package com.spring.farm.line.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("line")
public class LineController {
	
	
	@RequestMapping("/list.do")
	public String list() {
		System.out.println("listController.list()");
		
		
		
		return "line/list";
		
		
	}
	
	
}
