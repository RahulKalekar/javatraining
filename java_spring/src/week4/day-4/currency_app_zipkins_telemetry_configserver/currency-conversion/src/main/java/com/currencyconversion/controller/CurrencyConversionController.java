package com.currencyconversion.controller;

import com.currencyconversion.dto.CurrencyConversionBean;
import com.currencyconversion.serviceproxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RefreshScope	//for config referesh
@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${test.message}")
	private String testMessage;
//MAKE SURE THAT WHEN U ARE RUNNING : http://localhost:8100/actuator/refresh
	// IT SHOULD BE POST REQUEST
	@GetMapping("/configcheck")
	public String getConfigMessage() {
		return testMessage;
	}

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	//http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
													   @PathVariable String to,
													   @PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		logger.info("{}", response);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
}