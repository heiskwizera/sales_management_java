/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stock_app;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hekwizera
 */
public class app_db {

    private static Connection conn = null;

    public static Connection java_db() {

        try {

            String username = "he";
            String password = "he";
            String dbName = "sales_management_db";
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            conn = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return conn;

    }

}
