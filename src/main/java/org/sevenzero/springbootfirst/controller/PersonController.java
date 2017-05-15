package org.sevenzero.springbootfirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.sevenzero.springbootfirst.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	private static final Logger log = Logger.getLogger(PersonController.class);
	
	@RequestMapping("/person")
	public String person(Model model) {
		log.info("## PersonController ");
		
		Person single = new Person("Lee", 16);
		model.addAttribute("single", single);
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Lucy", 16));
		people.add(new Person("Lily", 16));
		people.add(new Person("Lune", 16));
		model.addAttribute("people", people);
		
		
		return "person";
	}

}
