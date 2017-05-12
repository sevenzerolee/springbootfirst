package org.sevenzero.springbootfirst.controller;

import org.apache.log4j.Logger;
import org.sevenzero.springbootfirst.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	private static final Logger log = Logger.getLogger(IndexController.class);
	
	@Value("${org.sevenzero.index}")
	private String index;
	
	@Autowired
	private ConfigBean config;
	
	@RequestMapping("/")
	String home() {
		log.info(index);
		log.info(config.getName());
		return "Home Index " + index + "[ " + config.getName() + "." + config.getId() + " ]";
	}
	
}
