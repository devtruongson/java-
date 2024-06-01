/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import thread.Connect;

/**
 *
 * @author truon
 */
public class UserController {

    public UserController() {

    }

    public void CreateUser(String email, String password, String name, int age, String address, String job, JFrame parent) {
        try {
            Connect connect = new Connect();
            Connection con = connect.getConn();

            boolean userExit = checkUserExit(email);
            if (userExit) {
                JOptionPane.showMessageDialog(parent, "Email da ton tai!");
                return;
            }

            String query = "insert into user (email, password, name, age, address, job) values (?,?,?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, address);
            pstmt.setString(6, job);

            int row = pstmt.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(parent, "Ban da them thanh cong nguoi dung");
                notify();
            }
        } catch (Exception e) {
            System.out.println("Err: " + e);
        }
    }

    public ResultSet getAllUser(String query) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet users = null;

        try {
            Connect connect = new Connect();
            con = connect.getConn();
            pstmt = con.prepareStatement(query);
            users = pstmt.executeQuery();
            return users;
        } catch (Exception e) {
            System.out.println("Err: " + e);
            return null;
        }
    }

    public void updateUser(String email, String password, String name, int age, String address, String job, int id, JFrame parent) {
        try {
            Connect connect = new Connect();
            Connection con = connect.getConn();

            String query = "update user set email = ?, password = ?, name = ? , age = ? , address = ?, job = ? where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, address);
            pstmt.setString(6, job);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(parent, "Ban da cap nhat thanh cong!");
            notify();
        } catch (Exception e) {
            System.out.println("Err: " + e);
        }
    }

    public void DeleteUser(int id,JFrame parent) {
        try {
            Connect connect = new Connect();
            Connection con = connect.getConn();

            String query = "delete from user where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(parent, "Ban da xoa thanh cong!");
            notify();
        } catch (Exception e) {
            System.out.println("Err: " + e);
        }
    }

    public boolean checkUserExit(String email) {
        boolean isExit = false;
        try {

            Connect connect = new Connect();
            Connection con = connect.getConn();

            String query = "select * from user where email = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isExit = true;
            }
        } catch (Exception e) {

        }

        return isExit;
    }
}
