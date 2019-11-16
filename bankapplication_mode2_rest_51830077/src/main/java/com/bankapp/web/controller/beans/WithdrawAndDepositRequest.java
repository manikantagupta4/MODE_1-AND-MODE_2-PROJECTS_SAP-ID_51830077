package com.bankapp.web.controller.beans;

public class WithdrawAndDepositRequest {
	
	private Long accountNumber;
	private Double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public WithdrawAndDepositRequest() {
		// TODO Auto-generated constructor stub
	}
	public WithdrawAndDepositRequest(Long accountNumber, Double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
}
