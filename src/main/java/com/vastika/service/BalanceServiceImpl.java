package com.vastika.service;

import com.vastika.dao.BalanceDao;
import com.vastika.dao.BalanceDaoImpl;
import com.vastika.model.AccountBalance;

import java.util.List;

public class BalanceServiceImpl implements BalanceService {
    BalanceDao balanceDao = new BalanceDaoImpl();

    @Override
    public void createBalanceTable() {
        balanceDao.createBalanceTable();
    }

    /*    @Override
        public int saveBalanceInfo(int balance) {
            balanceDao.saveBalanceInfo(balance);
            return balance;
        }
    */
    @Override
    public int saveOrUpdateBalanceInfo(AccountBalance balance) {
        int bal = 0;
        // insert successful = 1
        // insert failed = 0

        // deposit successful = 2
        // withdraw successful = 3;
        //withdraw failed = 4;

        AccountBalance balance1 = balanceDao.getBalanceByAccountHolderInfoID(balance.getAccountHolderInfoId());
        if (balance1 != null) {
            double intitalBalance = balance1.getAccountBalance();
            if (balance.getDepositAmount() > 0 && balance.getWithdrawAmount() == 0) {
                intitalBalance = intitalBalance + balance.getDepositAmount();
                bal = 2;
            } else if (balance.getWithdrawAmount() > 0 && balance.getDepositAmount() == 0) {
                if (balance.getWithdrawAmount() > intitalBalance) {
                    return 4;
                } else {
                    intitalBalance = intitalBalance - balance.getWithdrawAmount();
                    bal = 3;
                }
            }

            balance.setAccountBalance(intitalBalance);
            balance.setDepositAmount(balance.getDepositAmount());
            balance.setWithdrawAmount(balance.getWithdrawAmount());
            balanceDao.updateBalanceInfo(balance);
        } else {
            balance.setAccountBalance(balance.getDepositAmount());
            bal = balanceDao.saveBalanceInfo(balance);
        }
        return bal;
    }

    /*    @Override
    public int updateBalanceInfo(AccountBalance balance) {
        return 0;
    }

    @Override
    public void deleteBalanceInfo(int accountHolderInfoId) {

    }*/

    @Override
    public AccountBalance getBalanceByAccountHolderInfoID(int accountHolderInfoId) {
        return balanceDao.getBalanceByAccountHolderInfoID(accountHolderInfoId);
    }

    @Override
    public List<AccountBalance> getAllBalanceInfo() {
        return balanceDao.getAllBalanceInfo();
    }
}
