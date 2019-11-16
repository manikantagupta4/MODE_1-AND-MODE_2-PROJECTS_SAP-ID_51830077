package com.bankapp.model.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.entities.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long> {
public List<AccountTransaction> findByAccountAccountNumber(Long accountNumber);
List<AccountTransaction> findAll();
public AccountTransaction findByIdAndAccountAccountNumber(Long transId,Long accId);

}
