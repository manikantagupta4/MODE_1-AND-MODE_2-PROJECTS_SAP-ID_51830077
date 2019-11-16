package com.bankapp.web.controller.beans;

public class AccountBlockRequest {
	private Boolean blocked;

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	public AccountBlockRequest() {
		// TODO Auto-generated constructor stub
	}

	public AccountBlockRequest(Boolean blocked) {
		super();
		this.blocked = blocked;
	}
	
}
