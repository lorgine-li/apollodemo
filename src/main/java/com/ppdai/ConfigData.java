package com.ppdai;

import org.springframework.stereotype.Component;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;

@Component
public class ConfigData {	
	@ApolloConfig
	private Config config;
	public String getTest() {
		return config.getProperty("t", "100");
	}
}

