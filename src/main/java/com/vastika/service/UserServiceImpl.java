package com.vastika.service;

import com.vastika.dao.BalanceDao;
import com.vastika.dao.BalanceDaoImpl;
import com.vastika.dao.UserDao;
import com.vastika.dao.UserDaoImpl;
import com.vastika.model.AccountBalance;
import com.vastika.model.AccountHolder;

import com.vastika.model.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public void createUserTable() {
        userDao.createUserTable();

    }

    @Override
    public int saveUserInfo(AccountHolder user) {
        // null object
        if (user != null) {
            //check name
            if (!user.getAccountHolderName().isEmpty() && user.getMobileNo() != 0 && !user.getAddress()
                    .isEmpty()) {
                return userDao.saveUserInfo(user);
            }
        }
        return 0;

    }

    @Override
    public int updateUserInfo(AccountHolder user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public void deleteUserInfo(int id) {
        userDao.deleteUserInfo(id);
    }

    @Override
    public AccountHolder getUserById(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<AccountHolder> getAllUserInfo() {
        return userDao.getAllUserInfo();
    }

    @Override
    public AccountInfo getAccountInfoByUserID(int id) {
        return userDao.getAccountInfoByUserID(id);
    }

    @Override
    public List<AccountInfo> getAccountsInfo() {
        return userDao.getAccountsInfo();
    }

/*  public void withdrawFunds(double withdrawAmount) {
    AccountBalance balance = new AccountBalance();

    if (withdrawAmount <= balance.getAccountBalance()) {
      balance.setAccountBalance(balance.getAccountBalance() - withdrawAmount);
      System.out.println("withdraw successful :)");
    } else {
      System.out.println("Transaction Denied: Insufficient balance!!!");
      System.out.println("+++++++++++++++++++++++");
    }
  }

  public void depositFunds(double depositAmount) {
    AccountBalance balance = new AccountBalance();

    balance.setAccountBalance(balance.getAccountBalance() + depositAmount);

    System.out.println("deposit successful :)");

  }*/
}