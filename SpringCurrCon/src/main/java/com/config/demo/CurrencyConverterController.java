package com.config.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;
	
	private ResponseEntity<CurrencyConBean> forEntity;

	@GetMapping("/curr-con/from/{from}/to/{to}/quan/{quan}")
	public CurrencyConBean currConBean(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quan) {
		
		Map<String, String> uriVariables=new HashMap<String, String>();
		
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		forEntity = new RestTemplate().getForEntity("http://localhost:8000/curr-exc/from/{from}/to/{to}",CurrencyConBean.class,uriVariables);
		
		CurrencyConBean body = forEntity.getBody();
		
		
        return new CurrencyConBean(body.getId(), from, to, body.getConversionMul(), quan,BigDecimal.valueOf(200), body.getPort());
}
	
	
	@GetMapping("/curr-con-feign/from/{from}/to/{to}/quan/{quan}")
	public CurrencyConBean currConBeanFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quan) {
		
	    CurrencyConBean body = currencyExchangeProxy.retriveExcValue(from, to);
		
        return new CurrencyConBean(body.getId(), from, to, body.getConversionMul(), quan,BigDecimal.valueOf(200), body.getPort());
}
	
}
