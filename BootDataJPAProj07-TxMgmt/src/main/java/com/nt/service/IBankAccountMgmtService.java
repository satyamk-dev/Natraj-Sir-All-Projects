package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountMgmtService {
  public   String  registerAccount(BankAccount account);
  public   String  withdrawMoney(long acno,double amount);
  public   String  depositeMoney(long acno,double amount);
  public   String   transferMoney(long  srcAcno,long destAcno, double amount);
  
}
