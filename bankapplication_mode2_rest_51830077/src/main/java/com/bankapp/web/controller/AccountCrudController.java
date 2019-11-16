package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;
import com.bankapp.web.controller.beans.AccountBlockRequest;
import com.bankapp.web.controller.beans.AccountReq;
import com.bankapp.web.controller.beans.AccountUpdateRequest;

@RestController
@RequestMapping(path="api")
public class AccountCrudController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountTransactionService accountTransactionService;
	
	@GetMapping(path="account")
	public List<Account> getAllAccountsWhichAreNotBlocked(){
		List<Account> accounts=accountService.findAll();
		return accounts;
	}

	@GetMapping(path="account/blocked")
	public List<Account> getAllAccountsWhichAreBlocked(){
		List<Account> accounts=accountService.findAllBlocked();
		return accounts;
	}
	@GetMapping(path="account/{id}/transaction")
	public List<AccountTransaction> getAllTransactions(@PathVariable(value="id")Long id){
		Account account=accountService.findById(id);
		System.out.println("----------------------------------------------------------");
		
		List<AccountTransaction> transactions=account.getAccountTransactions();
		return transactions;
	}
	@GetMapping(path="account/{id}/transaction/{transId}")
	public AccountTransaction getTransactionByTransIdForAccountId(@PathVariable(value="id")Long id,@PathVariable(value="transId")Long transId){
		AccountTransaction  accountTransaction=accountTransactionService.findByIdAndAccountAccountNumber(transId, id);
		return accountTransaction ;
	}
	
	@GetMapping(path="account/{id}")
	public Account getAccountById(@PathVariable(value="id")Long id){
		Account account=accountService.findById(id);
		return account;
	}
	
	@GetMapping(path="account/{id}/customer")
	public Customer getCustomerByAccountId(@PathVariable(value="id")Long id){
		Account account=accountService.findById(id);
		Customer customer=account.getCustomer();
		return customer;
	}
	
	@DeleteMapping(path="account/{id}")
	public void deleteAccountById(@PathVariable(value="id")Long id){
		accountService.deleteAccount(id);
	}
	@PutMapping(path="account/{id}")
	public Account updateCustomerByAccountId(@PathVariable(name="id")Long id,@RequestBody AccountUpdateRequest account){
		Account account2=accountService.findById(id);
		account2.getCustomer().setAddress(account.getAddress());
		account2.getCustomer().setEmail(account.getEmail());
		account2.getCustomer().setName(account.getName());
		account2.getCustomer().setPhone(account.getPhone());
		accountService.updateAccount(account2);
		return account2;
	}
	@PutMapping(path="account/{id}/block")
	public Account blockAccount(@PathVariable(name="id")Long id,@RequestBody AccountBlockRequest account){
		
	Account account2=accountService.blockAccount(id,account);
		return account2;
	}
	@PostMapping(path="account")
	public Account createAccount(@RequestBody AccountReq req){
		Account account=new Account(req.getAccountBalance(), req.getType(), req.getBlocked());
		Customer customer=new Customer(req.getName(), req.getPhone(), req.getEmail(), req.getAddress());
		customer.setAccount(account);
		account.setCustomer(customer);
		accountService.createAccount(account);
	
		return account;
	}
}
