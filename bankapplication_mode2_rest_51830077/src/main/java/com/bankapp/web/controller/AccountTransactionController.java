package com.bankapp.web.controller;

import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.SecUser;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.beans.TransferRequest;
import com.bankapp.web.controller.beans.WithdrawAndDepositRequest;

@RestController
@RequestMapping(path = "api")
public class AccountTransactionController {
	@Autowired
	private AccountService accountService;

	@PutMapping("transaction/deposit")
	public String deposit(@RequestBody WithdrawAndDepositRequest req, @AuthenticationPrincipal SecUser user) {
		accountService.deposit(req.getAccountNumber(), req.getAmount(), user.getName());
		return new String("deposit done for account number:" + req.getAccountNumber() + " and amount:" + req.getAmount()
				+ " is done");

	}

	@PutMapping("transaction/withdraw")
	public String withdraw(@RequestBody WithdrawAndDepositRequest req, @AuthenticationPrincipal SecUser user) {
		
		accountService.withdraw(req.getAccountNumber(), req.getAmount(), user.getName());
		return new String("withdraw done for account number:" + req.getAccountNumber() + " and amount:" + req.getAmount()
		+ " is done");

	}
	@PutMapping("transaction/transfer")
	public String transfer(@RequestBody TransferRequest req,@AuthenticationPrincipal SecUser user) {
		accountService.transfer(req.getToaccount(), req.getFromaccount(), req.getAmount(),  user.getName());
		return new String("transfer done form account number:" + req.getFromaccount() + "to "+req.getToaccount()+" and amount:" + req.getAmount()
		+ " is done");

	}
}
