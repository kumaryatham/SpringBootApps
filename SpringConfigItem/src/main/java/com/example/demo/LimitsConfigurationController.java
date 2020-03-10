package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class LimitsConfigurationController {
	
	@Autowired
	ConfigurationProp confgProp;
	
	
	@GetMapping("/limits")
	public LimitsConfiguration retriveCfg() {
		
		return new LimitsConfiguration(confgProp.getMin(), confgProp.max);
	}
	
	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallBackReturn")
	public LimitsConfiguration retriveCfgTol() {
		
		throw new RuntimeException("Not Available");
	}
	
	public LimitsConfiguration fallBackReturn() {
		
		return new LimitsConfiguration(9,999);
	}
	
	

}
