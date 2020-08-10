package com.vastika.util;

public class QueryUtil {

  public static final String ACCOUNT_HOLDER_TABLE_CREATE_SQL = "create table account_holder_table"
      + " (id int not null auto_increment, account_holder_name varchar(20), address varchar(40), mobile_no bigint, unique_id_type varchar(20), primary key(id))";
  public static final String ACCOUNT_BALANCE_TABLE_CREATE_SQL = "create table IF NOT EXISTS account_balance_table(account_holder_info_id int not null, deposit_amount decimal(20,4), withdraw_amount decimal(20,4), account_balance decimal(20,4), FOREIGN KEY (account_holder_info_id) REFERENCES account_holder_table(id))";

  public static final String INSERT_USER_SQL = "insert into account_holder_table(account_holder_name, address, mobile_no, unique_id_type) values(?,?,?,?)";
  public static final String UPDATE_USER_SQL = "update account_holder_table set account_holder_name=?, address=?, mobile_no=?, unique_id_type=? where id=?";

  public static final String UPDATE_BALANCE_SQL = "update account_balance_table set deposit_amount=? , withdraw_amount=?, account_balance=? where account_holder_info_id=?";
  public static final String INSERT_BALANCE_SQL = "insert into account_balance_table( deposit_amount , withdraw_amount, account_holder_info_id, account_balance) values(?,?, ?, ?)";

  public static final String LIST_USER_SQL = "select * from account_holder_table";
  public static final String LIST_BALANCE_SQL = "select * from account_balance_table";

  public static final String DELETE_USER_SQL = "delete from account_holder_table where id=?";
  /*public static final String DELETE_BALANCE_SQL = "delete from account_balance_table where id=?";
   */
  public static final String GET_BY_USER_ID_SQL = "select * from account_holder_table where id=?";
  public static final String GET_BY_USER_INFO_ID_SQL = "select * from account_balance_table where account_holder_info_id=?";

  public static final String GET_ACCOUNT_INFO_BY_USER_ID_SQL =
      "select t1.id, t1.account_holder_name, t1.address, t1.mobile_no, t1.unique_id_type, t2.account_balance from account_holder_table t1   INNER JOIN account_balance_table t2  ON t2.account_holder_info_id=t1.id  where id=?";

  public static final String LIST_ACCOUNTS_INFO_SQL =
      "select t1.id, t1.account_holder_name, t1.address, t1.mobile_no, t1.unique_id_type, t2.account_balance from account_holder_table t1   INNER JOIN account_balance_table t2 ON t2.account_holder_info_id = t1.id;";
}
