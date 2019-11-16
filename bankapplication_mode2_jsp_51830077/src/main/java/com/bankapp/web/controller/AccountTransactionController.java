package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankapp.config.SecUser;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.beans.TransferBean;
import com.bankapp.web.controller.beans.WithdrawAndDepositBean;

@Controller
public class AccountTransactionController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping(path="deposit")
public String depositPost(WithdrawAndDepositBean depositBean,@AuthenticationPrincipal SecUser user){
	accountService.deposit(depositBean.getAccountNumber(), depositBean.getAmount(),user.getName());
	System.out.println("-------------------------------------");
	System.out.println(depositBean.getAccountNumber());
	return "success";
}
	@GetMapping(path="withdrawOrDeposit")
	public String withdrawGet(ModelMap map){
		map.addAttribute("withdrawAndDepositBean", new WithdrawAndDepositBean());
		return "WithdrawAndDeposit";
	}
	@PostMapping(path="withdraw")
public String withdrawPost(WithdrawAndDepositBean depositBean,@AuthenticationPrincipal SecUser user){
	accountService.withdraw(depositBean.getAccountNumber(), depositBean.getAmount(),user.getName());
	return "success";
}
	@GetMapping(path="transfer")
	public String tranferGet(ModelMap map){
		map.addAttribute("transferBean", new TransferBean());
		return "transferPage";
	}
	@PostMapping(path="transfer")
public String transferPost( TransferBean transferBean,@AuthenticationPrincipal SecUser user){
	accountService.transfer(transferBean.getToaccount(), transferBean.getFromaccount(), transferBean.getAmount(), user.getName());
	return "success";
}
	
}
