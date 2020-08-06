package com.vastika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final String URL="jdbc:mysql://localhost:3306/jdbc_demo_db?serverTimezone=UTC";
    public static final String USER_NAME="root";
    public static final String PASSWORD="root@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}

