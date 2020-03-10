package com.example.demo;

import org.springframework.cloud.config.server.environment.RepositoryException;

@SuppressWarnings("serial")
public class NoSuchLabelException extends RepositoryException {

	public NoSuchLabelException(String string) {
		super(string);
	}

	public NoSuchLabelException(String string, Exception e) {
		super(string, e);
	}

}
