package org.sevenzero.springbootfirst.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cross")
public class CrossOriginTestController {
	
	private static final Logger log = Logger.getLogger(CrossOriginTestController.class);
	
	@RequestMapping("/index")
	public String index(HttpSession session) {
		log.info("## " + session.getId());
		log.info("## Cross Index ");
		
		return "CrossIndex";
	}

}
