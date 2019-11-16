package com.bankapp.model.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.exceptions.AccountNotFoundException;
import com.bankapp.model.exceptions.InSuffientFundException;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.web.controller.beans.AccountBlockRequest;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountTransactionRepository accountTransactionRepository;
	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void transfer(Long toAccount, Long fromAccount, Double amount,String name) {
		
		Account account = accountRepository.findById(fromAccount).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		if(account.getAccountBalance()<amount){
			throw new InSuffientFundException("Insuffient amount in your account");
		}
		else{
			account.setAccountBalance(account.getAccountBalance() - amount);
			AccountTransaction accountTransaction = new AccountTransaction(amount, "withdraw");
			account.addTransaction(accountTransaction);
			accountRepository.save(account);
		}
		Account account1 = accountRepository.findById(toAccount).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		account1.setAccountBalance(account1.getAccountBalance() + amount);
		AccountTransaction accountTransaction1 = new AccountTransaction(amount, "deposit");
		account1.addTransaction(accountTransaction1);
		accountRepository.save(account1);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), fromAccount, toAccount, "transfer", amount,
				name, "success");
		transactionLogRepository.save(log);

	}

	@Override
	public void withdraw(Long fromAccount, Double amount,String name) {
		Account account = accountRepository.findById(fromAccount).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		account.setAccountBalance(account.getAccountBalance() - amount);
		AccountTransaction accountTransaction = new AccountTransaction(amount, "withdraw");
		account.addTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), fromAccount, null, "withdraw", amount,name,
				"success");
		transactionLogRepository.save(log);

	}

	@Override
	public void deposit(Long toAccount, Double amount,String name) {

		Account account = accountRepository.findById(toAccount).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		account.setAccountBalance(account.getAccountBalance() + amount);

		AccountTransaction accountTransaction = new AccountTransaction(amount, "deposit");
		account.addTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), null, toAccount, "deposit", amount, name,
				"success");
		transactionLogRepository.save(log);
	}

	@Override
	public Account createAccount(Account account) {
		accountRepository.save(account);
		return account ;
	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts=accountRepository.findAll();
		List<Account> accounts1=new ArrayList<Account>();
		for(int i=0;i<accounts.size();i++){
			if(!(accounts.get(i).getBlocked())){
				accounts1.add(accounts.get(i));
			}
		}
		return accounts1 ;
	}

	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepository.deleteById(accountNumber);

	}

	@Override
	public Account updateAccount(Account account) {
		/*Account account2=accountRepository.findById(accountNumber).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		account2.setBlocked(account.getBlocked());*/
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account blockAccount(Long accountNumber, AccountBlockRequest account) {
		Account account2=accountRepository.findById(accountNumber).orElseThrow(()->new AccountNotFoundException("Account not found with this accountNumber"));
		account2.setBlocked(account.getBlocked());
		accountRepository.save(account2);
		return account2;
	}

	@Override
	public List<Account> findAllBlocked() {
		List<Account> accounts=accountRepository.findAll();
		List<Account> accounts1=new ArrayList<Account>();
		for(int i=0;i<accounts.size();i++){
			if((accounts.get(i).getBlocked())){
				accounts1.add(accounts.get(i));
			}
		}
		return accounts1 ;
	}

}
