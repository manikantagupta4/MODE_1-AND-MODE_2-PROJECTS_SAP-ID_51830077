package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.repo.AccountTransactionRepository;
@Service
public class AccountTransactionServiceImpl implements AccountTransactionService{
	@Autowired
private AccountTransactionRepository accountTransactionRepository;

@Override
public AccountTransaction findByIdAndAccountAccountNumber(Long transId, Long accId) {
	AccountTransaction accountTransaction=	accountTransactionRepository.findByIdAndAccountAccountNumber(transId, accId);
	return accountTransaction;
}


	

}
