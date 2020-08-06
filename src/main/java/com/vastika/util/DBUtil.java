package com.vastika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static final String URL="jdbc:mysql://bank-account-app.cf3itk3bbcdw.us-east-2.rds.amazonaws.com/bank_account_db?serverTimezone=UTC";
    public static final String USER_NAME="root";
    public static final String PASSWORD="root1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}

