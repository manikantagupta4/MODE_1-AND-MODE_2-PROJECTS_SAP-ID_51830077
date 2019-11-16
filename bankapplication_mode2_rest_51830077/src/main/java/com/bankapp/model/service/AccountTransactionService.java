package com.bankapp.model.service;

import com.bankapp.model.entities.AccountTransaction;

public interface AccountTransactionService {
	public AccountTransaction findByIdAndAccountAccountNumber(Long transId,Long accId);

}
