package com.vastika.dao;

import com.vastika.model.AccountBalance;
import com.vastika.model.AccountHolder;

import java.util.List;

public interface BalanceDao {
    void createBalanceTable();

    int saveBalanceInfo(int balance);


    int updateBalanceInfo(AccountBalance balance);
    int saveBalanceInfo(AccountBalance balance);

    /*    int updateBalanceInfo(AccountBalance balance);
        void deleteBalanceInfo(int accountHolderInfoId);*/
    AccountBalance getBalanceByAccountHolderInfoID(int accountHolderInfoId);

    List<AccountBalance> getAllBalanceInfo();
}
