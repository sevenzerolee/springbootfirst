package org.sevenzero.springbootfirst.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lb
 * 
 * 注入配置文件中的配置
 *
 *
 */
@Component
public class MyProperties {
	
	@Value("${org.sevenzero.name}")
	private String name;
	
	@Value("${org.sevenzero.id}")
	private String id;

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
