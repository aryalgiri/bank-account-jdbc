package com.vastika.service;

import com.vastika.model.AccountBalance;

import java.util.List;

public interface BalanceService {

  void createBalanceTable();

  int saveOrUpdateBalanceInfo(AccountBalance balance);
    /* int saveBalanceInfo(int balance);
    int updateBalanceInfo(AccountBalance balance);
    void deleteBalanceInfo(int accountHolderInfoId);*/

  AccountBalance getBalanceByAccountHolderInfoID(int accountHolderInfoId);

  List<AccountBalance> getAllBalanceInfo();
}
