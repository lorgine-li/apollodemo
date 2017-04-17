package com.ppdai;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="test")
//@ConfigurationProperties
public class ConfigDataStatic {	
	@Value("${t1:100}")//此方式不会自动加上前缀
	private String test="100";		
	//此种方式绑定的时候会自动加上前缀
	private String t2;
	@PostConstruct
	public void init(){
		System.out.println(getTest());
		System.out.println(t2);
	}	
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
}

