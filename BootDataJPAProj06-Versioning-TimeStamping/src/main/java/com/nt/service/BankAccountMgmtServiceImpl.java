package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAcccountRepository;

@Service
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	@Autowired
	private   IBankAcccountRepository  accountRepo;

	@Override
	public String registerAccount(BankAccount account) {
		//use repo
		account.setCreatedBy(System.getProperty("user.name"));
	    // save the object
		long idVal=accountRepo.save(account).getAcno();
		return   "Bank Account is opened having account number ::"+idVal;
	}

	@Override
	public String withdrawMoney(long acno, double amount) {
		//Load object
		Optional<BankAccount> opt=accountRepo.findById(acno);
		if(opt.isPresent()) {
			BankAccount account=opt.get();
			account.setBalance(account.getBalance()-amount);
			account.setUpdateBy(System.getProperty("user.name"));
			
			//update the object
			accountRepo.save(account);
			return  "Bank Account Balance is updated (withdraw)::"+account.getBalance();
		}
		return  acno+" Bank Account is not found for updation";
	}

	@Override
	public String depositeMoney(long acno, double amount) {
		//Load object
		Optional<BankAccount> opt=accountRepo.findById(acno);
		if(opt.isPresent()) {
			BankAccount account=opt.get();
			account.setBalance(account.getBalance()+amount);
			account.setUpdateBy(System.getProperty("user.name"));
			//update the object
			accountRepo.save(account);
			return  "Bank Account Balance is updated (deposit)::"+account.getBalance();
		}
		return  acno+" Bank Account is not found for updation";
	}
	
	@Override
	public String transferMoney(long srcAcno, long destAcno, double amount) {
		//use  service methods
		  String msg1=withdrawMoney(srcAcno, amount);
		  String msg2=depositeMoney(destAcno, amount);
		  if(msg1.concat(msg2).contains("not"))
			  return "Money not transffered from"+srcAcno+"...."+destAcno;
		  else
			  return "Money  transffered from "+srcAcno+"...."+destAcno;
	}

}
