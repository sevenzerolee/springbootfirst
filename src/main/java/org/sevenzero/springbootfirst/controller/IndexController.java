package org.sevenzero.springbootfirst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/")
	String home() {
		return "Home Index";
	}
	
}
