package com.vastika.createtable;

import com.vastika.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class accountHolderTable {
    public static final String ACCOUNT_HOLDER_TABLE_CREATE_SQL="create table account_holder_table(id int not null auto_increment, account_holder_name varchar(45), address varchar(255), mobile_no bigint, unique_id_type varchar(255), primary key(id))";
    public static final String ACCOUNT_BALANCE_TABLE_CREATE_SQL="create table account_balance_table(account_holder_info_id int not null, deposit_amount decimal(20,4), withdraw_amount decimal(20,4), account_balance decimal(20,4), FOREIGN KEY (account_holder_info_id) REFERENCES account_holder_table(id))";

    public static void main(String[] args) {
        try(Connection con= DBUtil.getConnection();
            Statement st=con.createStatement()
        ){
            st.executeUpdate(ACCOUNT_HOLDER_TABLE_CREATE_SQL);
            System.out.println("account holder table created!!");

            st.executeUpdate(ACCOUNT_BALANCE_TABLE_CREATE_SQL);
            System.out.println("account balance table created!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

