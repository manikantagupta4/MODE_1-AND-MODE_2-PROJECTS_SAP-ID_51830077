package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.web.controller.beans.AccountBlockRequest;

public interface AccountService {
public List<Account> findAll();
public List<Account> findAllBlocked();
public Account findById(Long id);
public void transfer(Long toAccount,Long fromAccount,Double amount,String name);
public void withdraw(Long fromAccount,Double amount,String name);
public void deposit(Long toAccount,Double amount,String name);
public Account createAccount(Account account);
public void deleteAccount(Long accountNumber);
public Account updateAccount(Account account);
public Account blockAccount(Long accountNumber,AccountBlockRequest account);
}
