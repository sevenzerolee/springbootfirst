package org.sevenzero.springbootfirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 处理跨域问题
@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
public class EchartsTestController {
	
	private static final Logger log = Logger.getLogger(EchartsTestController.class);
	
	@RequestMapping("/get")
	public Data getUser() {
		
		log.info("get data");
		
		List<Chars> list = new ArrayList<>();
		list.add(new Chars("A", 5));
		list.add(new Chars("B", 15));
		list.add(new Chars("C", 25));
		list.add(new Chars("D", 35));
		list.add(new Chars("E", 45));
		
		Data data = new Data("异步数据加载示例", "Sales", list);
		
		return data;
	}

}

class Data {

	private String text;
	private String topic;
	private List<Chars> list;
	
	Data(){}
	
	Data(String text, String topic, List<Chars> list){
		this.text = text;
		this.topic = topic;
		this.list = list;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Chars> getList() {
		return list;
	}

	public void setList(List<Chars> list) {
		this.list = list;
	}

}

class Chars {
	
	private String name;
	private int number;
	
	Chars(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
