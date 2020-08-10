package com.vastika.dao;

import com.vastika.model.AccountHolder;
import com.vastika.model.AccountInfo;

import java.util.List;

public interface UserDao {

  void createUserTable();

  int saveUserInfo(AccountHolder user);



  int updateUserInfo(AccountHolder user);

  void deleteUserInfo(int id);

  AccountHolder getUserById(int id); // returns a particular account holder details from account_holder table

  List<AccountHolder> getAllUserInfo(); // returns all account holders from account_holder_table

  AccountInfo getAccountInfoByUserID(int id); // returns a particular account details from account_holder table and account_balance table

  List<AccountInfo> getAccountsInfo(); // returns all account details from from account_holder table and account_balance table

}
