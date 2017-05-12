package org.sevenzero.springbootfirst.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lb
 * 
 *         注入配置文件中的配置
 *
 */
@Component
@ConfigurationProperties(prefix = "org.sevenzero")
public class ConfigBean {

	private String name;
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
