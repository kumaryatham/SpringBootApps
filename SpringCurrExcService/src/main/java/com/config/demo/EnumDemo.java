package com.config.demo;

import org.springframework.http.HttpStatus;

public enum EnumDemo {

    BUSINESS_ERROR(100,""), SERVER_ERROR(500,""), NETWORK_ERROR(1000,"");
	
    private int errorCode;
    private int dec;
    
    private EnumDemo(int errorCode,String des) {
    this.errorCode = errorCode;
    this.dec=dec;
    }
    
    public HttpStatus getErrorCode() {
    return HttpStatus.valueOf(errorCode);
    }
    public HttpStatus getErrorDec() {
        return HttpStatus.valueOf(dec);
        }

	
}
