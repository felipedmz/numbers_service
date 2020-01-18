package com.number.restservice;

public class Number {
	
	private final long id;
	private final String content;

	public Number(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
