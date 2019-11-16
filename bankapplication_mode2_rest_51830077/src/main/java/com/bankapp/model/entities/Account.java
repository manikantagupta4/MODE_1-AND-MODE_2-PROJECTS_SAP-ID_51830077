package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="account_table")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountNumber;
	private Double accountBalance;
	private String type;
	private Boolean blocked;
	
	@OneToOne(mappedBy="account",cascade=CascadeType.ALL)
	private Customer customer;

	@JsonIgnore
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<AccountTransaction> accountTransactions=new ArrayList<>();

	public void addTransaction(AccountTransaction accountTransaction){
		accountTransactions.add(accountTransaction);
		accountTransaction.setAccount(this);
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}



	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<AccountTransaction> getAccountTransactions() {
		return accountTransactions;
	}
	public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
		this.accountTransactions = accountTransactions;
	}
	public Account(Double accountBalance, String type, Boolean blocked) {
		super();
		this.accountBalance = accountBalance;
		this.type = type;
		this.blocked = blocked;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", type=" + type
				+ ", blocked=" + blocked + "]";
	}

}
