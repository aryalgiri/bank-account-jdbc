package com.vastika.service;

import com.vastika.model.AccountBalance;

import java.util.List;

public interface BalanceService {

    void createBalanceTable();

    int saveOrUpdateBalanceInfo(AccountBalance balance);

    AccountBalance getBalanceByAccountHolderInfoID(int accountHolderInfoId);

    List<AccountBalance> getAllBalanceInfo();
}
