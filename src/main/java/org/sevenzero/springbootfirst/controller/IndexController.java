package org.sevenzero.springbootfirst.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	private static final Logger log = Logger.getLogger(IndexController.class);
	
	@Value("${org.sevenzero.name}")
	private String name;
	
	@Value("${org.sevenzero.id}")
	private String id;
	

	@RequestMapping("/")
	String home() {
		log.info(name + " " + id);
		return "Home Index " + name + ". " + id;
	}
	
}
