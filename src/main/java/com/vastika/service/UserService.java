package com.vastika.service;

import com.vastika.model.AccountHolder;

import com.vastika.model.AccountInfo;
import java.util.List;

public interface UserService {

  void createUserTable();

  int saveUserInfo(AccountHolder user);

  int updateUserInfo(AccountHolder user);

  void deleteUserInfo(int id);

  AccountHolder getUserById(int id);

  List<AccountHolder> getAllUserInfo();

  AccountInfo getAccountInfoByUserID(int id);

  List<AccountInfo> getAccountsInfo();


}
