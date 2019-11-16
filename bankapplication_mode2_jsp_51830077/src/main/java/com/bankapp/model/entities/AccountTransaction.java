package com.bankapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="transaction_table")
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Double amount;
private String type;
@JsonIgnore
@JoinColumn(name="accountNumber_fk")
@ManyToOne
private Account account;

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public AccountTransaction(Double amount, String type) {
	super();
	this.amount = amount;
	this.type = type;
}
@Override
public String toString() {
	return "AccountTransaction [id=" + id + ", amount=" + amount + ", type=" + type + "]";
}
public AccountTransaction() {
	// TODO Auto-generated constructor stub
}
}
