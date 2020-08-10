package com.vastika.util;


import com.vastika.dao.UserDao;
import com.vastika.dao.UserDaoImpl;
import com.vastika.model.AccountBalance;
import com.vastika.model.AccountHolder;
import com.vastika.model.AccountInfo;
import com.vastika.service.BalanceService;
import com.vastika.service.BalanceServiceImpl;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;
import java.util.List;
import java.util.Scanner;

public class AccountController {

  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    BalanceService balanceService = new BalanceServiceImpl();
    AccountBalance balance = new AccountBalance();

    balance.setAccountBalance(0);
    String decision = "";
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("What operation do you want?");
      String choice = sc.next();
      switch (choice) {
        case "createusertable":

          userService.createUserTable();
          break;
        case "createbalancetable":
          balanceService.createBalanceTable();
          System.out.println("balance table created");
          break;
        case "saveuser":
          AccountHolder saveUser = getUserData(choice, sc);
          int savedUser = userService.saveUserInfo(saveUser);
          if (savedUser >= 1) {
            System.out.println("user info saved successfully");
          } else {
            System.out.println("error in saving user to db!!!");
          }
          break;
        case "updateuser":
          AccountHolder updateUser = getUserData(choice, sc);
          int updatedUser = userService.updateUserInfo(updateUser);
          if (updatedUser >= 1) {
            System.out.println("user info updated successfully :)");
          } else {
            System.out.println("error in updating user in db!!!");
          }
          break;
        case "deleteuser":
          System.out.println("Enter account holder id: ");
          int deletedId = sc.nextInt();
          userService.deleteUserInfo(deletedId);
          System.out.println("user info is deleted :)");
          break;
        case "getuser":
          System.out.println("Enter account holder id: ");
          int getId = sc.nextInt();
          AccountHolder accountHolder = userService.getUserById(getId);
          System.out.println("Account holder id : " + accountHolder.getId());
          System.out.println("Account holder's name : " + accountHolder.getAccountHolderName());
          System.out.println("Address : " + accountHolder.getAddress());
          System.out.println("Mobile number : " + accountHolder.getMobileNo());
          System.out.println(
              "Type of unique identification  obtained : " + accountHolder.getUniqueIdType());
          break;
        case "userlist":
          List<AccountHolder> accountHolderList = userService.getAllUserInfo();
          for (AccountHolder a : accountHolderList) {
            System.out.println("Account holder id : " + a.getId());
            System.out.println("Account holder's name : " + a.getAccountHolderName());
            System.out.println("Address : " + a.getAddress());
            System.out.println("Mobile number : " + a.getMobileNo());
            System.out.println("Type of unique id  obtained : " + a.getUniqueIdType());
            System.out.println("=========================================");
          }
          break;
        case "savebalance":
          AccountBalance saveBalance = getBalanceData(choice, sc);
          double savedBalance = balanceService.saveOrUpdateBalanceInfo(saveBalance);
          if (savedBalance == 1) {
            System.out.println("Balance info saved successfully");
          } else if (savedBalance == 0) {
            System.out.println("Error in saving balance info to db!!!");
          } else if (savedBalance == 2) {
            System.out.println("Deposit successful :)");
          } else if (savedBalance == 3) {
            System.out.println("Withdraw successful :)");
          } else if (savedBalance == 4) {
            System.out.println("Insufficient balance!!!");
          }
          break;
        case "getbalance":
          System.out.println("Enter account holder's id: ");
          int getInfoId = sc.nextInt();
          balance = balanceService.getBalanceByAccountHolderInfoID(getInfoId);
          System.out.println("Account holder's info id : " + balance.getAccountHolderInfoId());
          System.out.println("Deposit amount : " + balance.getDepositAmount());
          System.out.println("Withdraw amount : " + balance.getWithdrawAmount());
          System.out.println("Available balance : " + balance.getAccountBalance());
          break;
        case "balancelist":
          List<AccountBalance> balanceList = balanceService.getAllBalanceInfo();
          for (AccountBalance b : balanceList) {
            System.out.println("Account holder's info id : " + b.getAccountHolderInfoId());
            System.out.println("Deposit amount : " + b.getDepositAmount());
            System.out.println("Withdraw amount : " + b.getWithdrawAmount());
            System.out.println("Available balance : " + b.getAccountBalance());
          }
          break;
        case "getaccount":
          System.out.println("Enter account holder's id: ");
          int accountID = sc.nextInt();
          AccountInfo accountInfo = userService.getAccountInfoByUserID(accountID);
          System.out.println("Account id: " + accountInfo.getId());
          System.out.println("Account holder's name: " + accountInfo.getAccountHolderName());
          System.out.println("Address: " + accountInfo.getAddress());
          System.out.println("Mobile number: " + accountInfo.getMobileNo());
          System.out.println("Type of unique id  obtained : " + accountInfo.getUniqueIdType());
          System.out.println("Available balance: " + accountInfo.getAccountBalance());
          break;
        case "listaccount":
          List<AccountInfo> accountList = userService.getAccountsInfo();
          for (AccountInfo a : accountList) {
            System.out.println("Account id: " + a.getId());
            System.out.println("Account holder's name: " + a.getAccountHolderName());
            System.out.println("Address: " + a.getAddress());
            System.out.println("Mobile number: " + a.getMobileNo());
            System.out.println("Type of unique id  obtained : " + a.getUniqueIdType());
            System.out.println("Available balance: " + a.getAccountBalance());
          }
          break;

        default:
          System.out.println("wrong choice!!");
      }
      System.out.println("Do you want to continue with another operation");
      decision = sc.next();
    } while (decision.equalsIgnoreCase("y"));
  }

  public static AccountHolder getUserData(String type, Scanner sc) {
    AccountHolder accountHolder = new AccountHolder();
    if (type.equals("updateuser")) {
      System.out.println("Enter id: ");
      int id = sc.nextInt();
      accountHolder.setId(id);
    }

    System.out.println("Enter account holder name:");
    String accountHolderName = sc.next();
    System.out.println("Enter address:");
    String address = sc.next();
    System.out.println("Enter mobile number:");
    long mobileNo = sc.nextLong();
    System.out.println("Enter the type of unique id presented:");
    String uniqueIdType = sc.next();

    accountHolder.setAccountHolderName(accountHolderName);
    accountHolder.setAddress(address);
    accountHolder.setMobileNo(mobileNo);
    accountHolder.setUniqueIdType(uniqueIdType);
    return accountHolder;
  }

  public static AccountBalance getBalanceData(String type, Scanner sc) {
    AccountBalance balance = new AccountBalance();

    System.out.println("Enter the account Number you wish to operate:");
    int accNo = sc.nextInt();
    System.out.println("Enter the amount you wish to deposit:");
    double depositAmount = sc.nextDouble();
    System.out.println("Enter the amount you wish to withdraw:");
    double withdrawAmount = sc.nextDouble();

    balance.setAccountHolderInfoId(accNo);
    balance.setDepositAmount(depositAmount);
    balance.setWithdrawAmount(withdrawAmount);

    return balance;
  }
}