package com.ppdai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@Configuration
@EnableApolloConfig
public class ApollodemoApplication {
	@Autowired
	private ConfigData configData;
	@RequestMapping("/")
	public String test() {
		Config config = ConfigService.getAppConfig(); // config instance is
														// singleton for each
														// namespace and is
														// never null
		config.addChangeListener(new ConfigChangeListener() {
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				// TODO Auto-generated method stub

			}
		});
		return config.getProperty("t", "t123");
	}

	@RequestMapping("/test")
	public String test1() {
		// return demo.get();
		return configData.getTest();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApollodemoApplication.class, args);
	}
}
