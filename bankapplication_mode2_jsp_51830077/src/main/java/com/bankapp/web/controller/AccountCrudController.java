package com.bankapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.web.controller.beans.AccountBean;
import com.bankapp.web.controller.beans.EnterAccountNumberBean;

@Controller

public class AccountCrudController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountTransactionService accountTransactionService;
	@Autowired
	private CustomerService customerService;
	@GetMapping(path="/")
	public String home(){
		return "home";
	}
	@GetMapping(path="admin")
	public String admin(){
		return "admin";
	}
	@GetMapping(path="mgr")
	public String mgr(){
		return "mgr";
	}
	@GetMapping(path="clerk")
	public String clerk(){
		return "clerk";
	}
	@GetMapping(path="allaccounts")
	public String getAllAccountsWhichAreNotBlocked(ModelMap map){
		map.addAttribute("accounts",accountService.findAll());
		return "AccountCrudJsp's/all_accounts";
	}

	@GetMapping(path="blockedaccounts")
	public String getAllAccountsWhichAreBlocked(ModelMap map){
		map.addAttribute("accounts",accountService.findAllBlocked());
		return "blocked_accounts";
	}
	@GetMapping(path="createaccount")
	public String createaccountGet(ModelMap map){
		map.addAttribute("account",new AccountBean() );
		return "createaccount";
	}
	@PostMapping(path="createaccount")
	public String createaccountPost(ModelMap map,AccountBean bean){
		Account account=new Account(bean.getAccountBalance(),bean.getType(), false);
		Customer customer=new Customer(bean.getName(), bean.getPhone(), bean.getEmail(), bean.getAddress());
		account.setCustomer(customer);
		customer.setAccount(account);
		accountService.createAccount(account);
		return "redirect:allaccounts";
	}
	@RequestMapping(path="block")
	public String blockAccount(HttpServletRequest req){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		accountService.blockAccount(accountNumber);
		return "redirect:allaccounts";
	}
	@RequestMapping(path="unblock")
	public String unblockAccount(HttpServletRequest req){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		accountService.unblockAccount(accountNumber);
		return "redirect:blockedaccounts";
	}
	/*@RequestMapping(path="update")
	public String updateAccount(HttpServletRequest req,ModelMap map){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		Account account=accountService.findById(accountNumber);
		Customer
		map.addAttribute("account", account);

		return "createaccount";
	}*/
	@RequestMapping(path="delete")
	public String deleteAccount(HttpServletRequest req){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		accountService.deleteAccount(accountNumber);
		return "redirect:allaccounts";
	}
	@GetMapping(path="customer")
	public String getCustomerByAccountId(HttpServletRequest req,ModelMap map){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		Account account=accountService.findById(accountNumber);

		map.addAttribute("customer", account.getCustomer());
		return "allcustomers";
	}
	@GetMapping(path="update")
	public String updateAccount(ModelMap map,HttpServletRequest req){
		Long accountNumber=Long.parseLong(req.getParameter("id"));
		Account account=accountService.findById(accountNumber);
		map.addAttribute("customer", account.getCustomer());		
		return "updateaccount";
	}
	@PostMapping(path="update")
	public String updateAccountPost(ModelMap map,Customer customer){
		System.out.println(customer.getId());
		System.out.println("---------------------------------");
		Customer customer2=customerService.findById(customer.getId());
		customer2.setAddress(customer.getAddress());
		customer2.setEmail(customer.getEmail());
		customer2.setName(customer.getName());
		customer2.setPhone(customer.getPhone());
		customerService.updateCustomer(customer2);
		return "redirect:allaccounts";
	}
	@GetMapping(path="transactiondetails")
	public String gettransactiondetails(ModelMap map){
		map.addAttribute("accountNumber", new EnterAccountNumberBean());
		return "EnterAccountNumber";
	}
	@PostMapping(path="transactiondetails")
	public String gettransactiondetailsPost(ModelMap map, EnterAccountNumberBean accountNumberBean){
		Account account=accountService.findById(accountNumberBean.getAccountNumber());
		map.addAttribute("transactions", account.getAccountTransactions());
		return "transactionDetails";
	}
}
