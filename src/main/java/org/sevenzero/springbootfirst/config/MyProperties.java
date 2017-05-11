package org.sevenzero.springbootfirst.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {
	
	@Value("${org.sevenzero.name}")
	private String name;
	
	@Value("${org.sevenzero.id}")
	private String id;

}
