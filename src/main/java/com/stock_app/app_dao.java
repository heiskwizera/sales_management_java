/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stock_app;

import java.awt.Component;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hekwizera
 */
public class app_dao {

    Connection con = app_db.java_db();
    app_helpers helper = new app_helpers();
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet res = null;

    int count = 0;

    public void AdminLogin(String username, String password, Component page) {
        String req = "SELECT * FROM admin where username=? and password=?";
        try {
            String role = "ADMINSTRATOR";
            pst = con.prepareStatement(req);
            pst.setString(1, username);
            pst.setString(2, password);
            res = pst.executeQuery();
            while (res.next()) {
                count += 1;
            }
            if (count == 1) {
                helper.msg("Welcome " + username + " :) ", 1);
                page.setVisible(false);
                new app_home().setInfo(username, role);
            } else {
                helper.msg("Unauthorized user", count);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void addUser(String full_name, String username, String email, String role_id, String company_id) {
        String req = "INSERT INTO users (full_name,username,email,password,role_id,company_id,created_at) values(?,?,?,?,?,?,now())";
        try {
            pst = con.prepareStatement(req);
            pst.setString(1, full_name);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, helper.generatePassword());
            pst.setString(5, role_id);
            pst.setString(6, company_id);

            count = pst.executeUpdate();
            if (count > 0) {
                helper.msg("New User Added Successfully", count);
            }

        } catch (SQLException e) {
            helper.msg(e.getMessage(), count);
        }
    }

    public void addRole(String roleName) {
        String req = "INSERT INTO roles (roleName,created_at) values(?,now())";
        try {
            pst = con.prepareStatement(req);
            pst.setString(1, roleName);

            count = pst.executeUpdate();
            if (count > 0) {
                helper.msg("New role added", count);
            }

        } catch (SQLException e) {
            helper.msg(e.getMessage(), count);
        }

    }
    
    public void addCompany(String email,String phone,String url,String location_name,Blob logo){
       String req = "INSERT INTO company(email,phone,url,location_name,created_at,logo) VALUES (?,?,?,?,now(),?)";
        try {
            pst = con.prepareStatement(req);
            pst.setString(1, email);
            pst.setString(2, phone);
            pst.setString(3, url);
            pst.setString(4, location_name);
            pst.setBlob(5, logo);
            
            count = pst.executeUpdate();
            if(count>0) helper.msg("Added Company successfully", count);
        } catch (SQLException e) {
            helper.msg(e.getMessage(), count);
        }
    
    }
    
    
    
    
    
    

    public static void main(String[] args) {
        app_dao x = new app_dao();
        x.addRole("admin");
//    x.addUser("KWIZERA Fabrice", "he", "kwizerageniklenon@gmail.com", , company_id);
    }

}
