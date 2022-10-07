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

<<<<<<< HEAD
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate );
//
//		return "home.jsp";
//	}

	@RequestMapping("/signUp")
	public String main() {	
		return "signUp";
	}
	@RequestMapping("/insertProduct")
    public String insertProduct() {  
        return "insertProduct";
    }
=======
>>>>>>> BKH
	@RequestMapping("/")
	public String index() {	
		return "index";
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
