package com.vastika.dao;

import com.vastika.model.AccountBalance;
import com.vastika.model.AccountHolder;
import com.vastika.util.DBUtil;
import com.vastika.util.QueryUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BalanceDaoImpl implements BalanceDao {


    @Override
    public void createBalanceTable() {
        try (
                Connection con = DBUtil.getConnection();
                Statement st = con.createStatement()
        ) {
            st.executeUpdate(QueryUtil.ACCOUNT_BALANCE_TABLE_CREATE_SQL);
            System.out.println("account balance table created!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int saveBalanceInfo(AccountBalance balance) {
        AccountBalance balance1 = new AccountBalance();
        int balanceSaved = 0;

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_BALANCE_SQL)
        ) {
            ps.setDouble(1, balance.getDepositAmount());
            ps.setDouble(2, balance.getWithdrawAmount());
            ps.setInt(3, balance.getAccountHolderInfoId());
            ps.setDouble(4, balance.getAccountBalance());

            balanceSaved = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balanceSaved;

    }

    @Override
    public int saveBalanceInfo(int balance1) {
        AccountBalance balance = new AccountBalance();
        int balanceSaved = 0;

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_BALANCE_SQL)
        ) {
            ps.setDouble(1, balance.getDepositAmount());
            ps.setDouble(2, balance.getWithdrawAmount());
            ps.setInt(3, balance.getAccountHolderInfoId());

            balanceSaved = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balanceSaved;
    }

    @Override
    public int updateBalanceInfo(AccountBalance balance) {
        int balanceUpdated = 0;

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_BALANCE_SQL)
        ) {
            ps.setDouble(1, balance.getDepositAmount());
            ps.setDouble(2, balance.getWithdrawAmount());
            ps.setDouble(3, balance.getAccountBalance());
            ps.setInt(4, balance.getAccountHolderInfoId());

            balanceUpdated = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balanceUpdated;
    }

    /*    @Override
        public void deleteBalanceInfo(int accountHolderInfoId) {
            try (
                    Connection con = DBUtil.getConnection();
                    PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_BALANCE_SQL)
            ) {

                ps.setInt(1, accountHolderInfoId);

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    */
    @Override
    public AccountBalance getBalanceByAccountHolderInfoID(int accountHolderInfoId) {
        AccountBalance balance = new AccountBalance();

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_USER_INFO_ID_SQL)
        ) {
            ps.setInt(1, accountHolderInfoId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                balance.setAccountHolderInfoId(rs.getInt("account_holder_info_id"));
                balance.setDepositAmount(rs.getDouble("deposit_amount"));
                balance.setWithdrawAmount(rs.getDouble("withdraw_amount"));
                balance.setAccountBalance(rs.getDouble("account_balance"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    @Override
    public List<AccountBalance> getAllBalanceInfo() {
        List<AccountBalance> balanceList = new ArrayList<>();
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_BALANCE_SQL)
        ) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AccountBalance balance = new AccountBalance();
                balance.setAccountHolderInfoId(rs.getInt("account_holder_info_id"));
                balance.setDepositAmount(rs.getDouble("deposit_amount"));
                balance.setWithdrawAmount(rs.getDouble("withdraw_amount"));
                balance.setAccountBalance(rs.getDouble("account_balance"));

                balanceList.add(balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balanceList;
    }
}
