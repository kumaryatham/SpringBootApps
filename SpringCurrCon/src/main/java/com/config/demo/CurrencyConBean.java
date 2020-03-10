package com.config.demo;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize
public class CurrencyConBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMul;
	private BigDecimal quan;
	
	private BigDecimal totalConMul;
	
	private int port;
	
	
	public CurrencyConBean(){
		
	}
	

	public CurrencyConBean(long id2, String from2, String to2, BigDecimal valueOf, BigDecimal quan2,
			BigDecimal valueOf2, int port) {
		
		super();
		this.id = id2;
		this.from = from2;
		this.to = to2;
		this.conversionMul = valueOf;
		this.quan = quan2;
		this.totalConMul = valueOf2;
		this.port = port;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMul() {
		return conversionMul;
	}

	public void setConversionMul(BigDecimal conversionMul) {
		this.conversionMul = conversionMul;
	}

	

	public BigDecimal getTotalConMul() {
		return totalConMul;
	}

	public void setTotalConMul(BigDecimal totalConMul) {
		this.totalConMul = totalConMul;
	}


	public BigDecimal getQuan() {
		return quan;
	}


	public void setQuan(BigDecimal quan) {
		this.quan = quan;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	
	
	
	
}
