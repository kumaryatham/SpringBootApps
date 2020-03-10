package com.config.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	ResourceRepository resourceReps;
	 
	@GetMapping("/curr-exc/from/{from}/to/{to}")
	public ExchangeValue retriveExcValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue	exchangeVal=resourceReps.findByFromAndTo(from, to);
				exchangeVal.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeVal;
	}
	
}
