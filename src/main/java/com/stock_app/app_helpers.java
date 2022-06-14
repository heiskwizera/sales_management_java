/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stock_app;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author hekwizera
 */
public class app_helpers {

    Boolean Field = true;

    public Boolean validateFields(JTextField[] listFields) {

        for (JTextField item : listFields) {
            if (item.getText().isEmpty()) {
                Field = false;
                item.setBackground(Color.PINK);
            } else {
                item.setBackground(Color.WHITE);
                Field = true;
            }
        }

        return Field;

    }

    public void resetFields(JTextField[] listFields) {
        for (JTextField item : listFields) {
            item.setText("");
        }

    }

    public void sizeWindow(Window win) {
        Dimension geek = Toolkit.getDefaultToolkit().getScreenSize();
        int w = win.getWidth();
        int h = win.getHeight();
        int x = (geek.width - w) / 2;
        int y = (geek.height - h) / 2;
        win.setLocation(x, y);

    }

    public void ClearPassFields(JTextField[] c) {
        for (JTextField items : c) {
            items.setText("");
            items.setBackground(Color.WHITE);
        }
    }

    public void msg(String Message, int info) {
        JOptionPane.showMessageDialog(null, Message, "DEV S.M APP", info);
    }

    public int RecordId(JTable routesData) {
        int[] routeRow = routesData.getSelectedRows();
        int row = routeRow[0];
        Object identity = routesData.getValueAt(row, 0);
        String id = String.valueOf(identity);
        int value = Integer.parseInt(id);
        return value;
    }

    public void setColor(JPanel pane) {
        pane.setBackground(new Color(41, 57, 80));
    }

    public void resetColor(JPanel[] pane, JPanel[] indicators) {
        for (JPanel pane1 : pane) {
            pane1.setBackground(new Color(23, 35, 51));
        }
        for (JPanel indicator : indicators) {
            indicator.setOpaque(false);
        }

    }

    public String generatePassword() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    void Logout(Component xx) {
        new app_start().setVisible(true);
        xx.setVisible(false);
        
    }

}
