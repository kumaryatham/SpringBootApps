package com.config.demo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "con_from")
	private String from ;
	
	@Column(name = "con_to")
	private String to;
	
	@Column(name = "conversion_multiple")
	private BigDecimal bigDec;
	
	private int port;
	
	public ExchangeValue() {
	
	}
	
	public ExchangeValue(String from, String to, Long id, BigDecimal bigDec) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.bigDec = bigDec;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBigDec() {
		return bigDec;
	}

	public void setBigDec(BigDecimal bigDec) {
		this.bigDec = bigDec;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
	
	
}
