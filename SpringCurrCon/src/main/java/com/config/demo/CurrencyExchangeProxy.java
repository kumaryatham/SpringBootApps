package com.config.demo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="curr-exc-service", url="localhost:8000")
//@FeignClient(name="curr-exc-service")  When ever zuul gateway mapped we ignore feign client  @ Step1 
@FeignClient(name="zull-proxy") // step 2
@RibbonClient(name ="curr-exc-service")
public interface CurrencyExchangeProxy {
	//@GetMapping("/curr-exc/from/{from}/to/{to}")  // step 1
	@GetMapping("/curr-exc-service/curr-exc/from/{from}/to/{to}") // Step 2 : When we configure Zuul app name in eureka server 
	public CurrencyConBean retriveExcValue(@PathVariable("from") String from,@PathVariable("to") String to) ;
	
}
