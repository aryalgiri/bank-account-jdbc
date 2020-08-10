package com.vastika.model;

public class AccountInfo {
    private int id;
    private String accountHolderName;
    private String address;
    private long mobileNo;
    private String uniqueIdType;
    private double accountBalance;
    private String emailID; // Checking purposed



    public AccountInfo() {
    }

    public AccountInfo(int id, String accountHolderName, String address, long mobileNo, String uniqueIdType, int accountBalance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.address = address;
        this.mobileNo = mobileNo;
        this.uniqueIdType = uniqueIdType;
        this.accountBalance = accountBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNo() {

        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUniqueIdType() {
        return uniqueIdType;
    }

    public void setUniqueIdType(String uniqueIdType) {
        this.uniqueIdType = uniqueIdType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
