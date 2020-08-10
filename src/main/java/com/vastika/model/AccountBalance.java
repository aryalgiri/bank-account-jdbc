package com.vastika.model;

public class AccountBalance {

  private double depositAmount;
  private double withdrawAmount;
  private double accountBalance;
  private int accountHolderInfoId;

  public double getDepositAmount() {

    return depositAmount;
  }

  public void setDepositAmount(double depositAmount) {

    this.depositAmount = depositAmount;
  }

  public double getWithdrawAmount() {

    return withdrawAmount;
  }

  public void setWithdrawAmount(double withdrawAmount) {

    this.withdrawAmount = withdrawAmount;
  }

  public double getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
  }

  public int getAccountHolderInfoId() {

    return accountHolderInfoId;
  }

  public void setAccountHolderInfoId(int accountHolderInfoId) {

    this.accountHolderInfoId = accountHolderInfoId;
  }
}
