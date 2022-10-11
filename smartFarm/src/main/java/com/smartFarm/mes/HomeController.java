package com.smartFarm.mes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index() {
		return "signIn";
	}
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	@RequestMapping("/signIn")
	public String login() {
		return "signIn";
	}
	@RequestMapping("/statusList")
	public String statusList() {
		return "statusList";
	}




}
