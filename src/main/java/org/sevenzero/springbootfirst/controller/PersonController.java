package org.sevenzero.springbootfirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.sevenzero.springbootfirst.entity.Person;
import org.sevenzero.springbootfirst.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger log = Logger.getLogger(PersonController.class);
	
	@Autowired
	private PersonMapper personMapper;
	
	@RequestMapping("/getone/{id}")
	public String getOne(Model model, 
			@PathVariable long id) {
		log.info("## " + id);
		Person p = personMapper.findById(id);
		model.addAttribute("person", p);
		
		return "person/getone";
	}
	
	// 这个对应 resources/templates/person.html 页面展示
	@RequestMapping("/test")
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
	
	@RequestMapping("/getPersonList")
	public String getPersons(Model model, 
			@RequestParam(defaultValue = "1") 
			Integer pageNum, 
			@RequestParam(defaultValue = "2") 
			Integer pageSize) {
		
		log.info("## " + pageNum + ", " + pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<Person> list = personMapper.findAll();
		PageInfo<Person> pageInfo = new PageInfo<Person>(list);
		log.info("## " + pageInfo);
		
		model.addAttribute("page", pageInfo);
		
		
		return "person/personList";
	}

}
