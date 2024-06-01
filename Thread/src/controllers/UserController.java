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
import model.User;

/**
 *
 * @author truon
 */
public class UserController {

    public UserController() {

    }

    public void createUser(User user,JFrame parent) {
        try {
            Connect connect = new Connect();
            Connection con = connect.getConn();

            boolean userExit = checkUserExit(user.getEmail());
            if (userExit) {
                JOptionPane.showMessageDialog(parent, "Email da ton tai!");
                return;
            }

            String query = "insert into user (email, password, name, age, address, job) values (?,?,?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getAge());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getJob());

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

    public void updateUser(User user, JFrame parent) {
        try {
            Connect connect = new Connect();
            Connection con = connect.getConn();

            String query = "UPDATE user SET email = ?, password = ?, name = ?, age = ?, address = ?, job = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getAge());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getJob());
            pstmt.setInt(7, user.getId());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(parent, "Bạn đã cập nhật thành công!");
            notify();
        } catch (Exception e) {
            System.out.println("Err: " + e);
        }
    }

    public void deleteUser(int id,JFrame parent) {
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
