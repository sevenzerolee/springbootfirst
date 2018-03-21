package org.sevenzero.springbootfirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping("getOneUser")
	public User getUser() {
		return new User("TestUser", 1970);
	}
	
	/*
	 * 
	 * @RequestBody 可以把接收到的json对象转换为User对象
	 * 不带@RequestBody直接接收表单对象
	 * 
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public User getOneUser(@RequestBody User user) {
		if (null != user) {
			log.info("## " + user.getUsername() + ", " + user.getPassword());
		}
		
		return new User("OneUser", 1970);
	}
	
	@RequestMapping("getList")
	public List<DataA> getList() {
		List<DataA> list = new ArrayList<>();
		
		for (int i=0; i<5; i++) {
			list.add(new DataA("Name#" + i, "ID " + i));
		}
		
		try {
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@RequestMapping(value = "getList", method = RequestMethod.POST)
	public Id getList2(@RequestBody Name name) {
		log.info("## " + name.getName());
		
		return new Id("7");
	}

}

class Id {
	
	String id;
	
	public Id(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

class Name {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class DataA {
	
	private String name;
	private String id;
	
	DataA(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

class User {

	private String username;
	private int age;
	private String password;
	
	User(){}
	
	User(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
