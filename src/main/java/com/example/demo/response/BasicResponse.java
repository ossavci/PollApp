package com.example.demo.response;

import java.io.Serializable;

public class BasicResponse implements Serializable {

	private static final long serialVersionUID = -2961390746573035934L;
	private boolean status;
	private String text;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BasicResponse(boolean status, String text) {
		super();
		this.status = status;
		this.text = text;
	}

}
