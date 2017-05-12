package org.sevenzero.springbootfirst.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	private static final Logger log = Logger.getLogger(PersonController.class);
	
	@RequestMapping("/person")
	public String person(Model model) {
		log.info("## PersonController ");
		
		
		return "person";
	}

}
