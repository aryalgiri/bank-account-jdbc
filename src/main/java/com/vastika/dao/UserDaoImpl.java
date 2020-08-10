package com.vastika.dao;

import com.vastika.model.AccountHolder;
import com.vastika.model.AccountInfo;
import com.vastika.util.DBUtil;
import com.vastika.util.QueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


  @Override
  public void createUserTable() {
    try (
        Connection con = DBUtil.getConnection();
        Statement st = con.createStatement()
    ) {
      st.executeUpdate(QueryUtil.ACCOUNT_HOLDER_TABLE_CREATE_SQL);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int saveUserInfo(AccountHolder user) {
    int saved = 0;

    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_USER_SQL)
    ) {
      ps.setString(1, user.getAccountHolderName());
      ps.setString(2, user.getAddress());
      ps.setLong(3, user.getMobileNo());
      ps.setString(4, user.getUniqueIdType());

      saved = ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return saved;
  }

  @Override
  public int updateUserInfo(AccountHolder user) {
    int updated = 0;
    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_USER_SQL)
    ) {
      ps.setString(1, user.getAccountHolderName());
      ps.setString(2, user.getAddress());
      ps.setLong(3, user.getMobileNo());
      ps.setString(4, user.getUniqueIdType());
      ps.setInt(5, user.getId());

      updated = ps.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.toString());
    }
    return updated;
  }

  @Override
  public void deleteUserInfo(int id) {
    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_USER_SQL)
    ) {
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public AccountHolder getUserById(int id) {
    AccountHolder user = new AccountHolder();

    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_USER_ID_SQL)
    ) {
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        user.setId(rs.getInt("id"));
        user.setAccountHolderName(rs.getString("account_holder_name"));
        user.setAddress(rs.getString("address"));
        user.setMobileNo(rs.getLong("mobile_no"));
        user.setUniqueIdType(rs.getString("unique_id_type"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;

  }

  @Override
  public List<AccountHolder> getAllUserInfo() {

    List<AccountHolder> userList = new ArrayList<>();
    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_USER_SQL)
    ) {
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        AccountHolder user = new AccountHolder();
        user.setId(rs.getInt("id"));
        user.setAccountHolderName(rs.getString("account_holder_name"));
        user.setAccountHolderName(rs.getString("address"));
        user.setMobileNo(rs.getLong("mobile_no"));
        user.setUniqueIdType(rs.getString("unique_id_type"));

        userList.add(user);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userList;
  }

  @Override
  public AccountInfo getAccountInfoByUserID(int id) {
    AccountInfo accountInfo = new AccountInfo();

    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.GET_ACCOUNT_INFO_BY_USER_ID_SQL)
    ) {
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        accountInfo.setId(rs.getInt("id"));
        accountInfo.setAccountHolderName(rs.getString("account_holder_name"));
        accountInfo.setAddress(rs.getString("address"));
        accountInfo.setMobileNo(rs.getLong("mobile_no"));
        accountInfo.setAccountBalance(rs.getInt("account_balance"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return accountInfo;
  }

  @Override
  public List<AccountInfo> getAccountsInfo() {
    List<AccountInfo> accountInfoList=new ArrayList<>();

    try (
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_ACCOUNTS_INFO_SQL)
    ) {
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(rs.getInt("id"));
        accountInfo.setAccountHolderName(rs.getString("account_holder_name"));
        accountInfo.setAddress(rs.getString("address"));
        accountInfo.setMobileNo(rs.getLong("mobile_no"));
        accountInfo.setAccountBalance(rs.getInt("account_balance"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return accountInfoList;
  }
}