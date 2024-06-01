/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hoa Le
 */
public class Connect {

    private final Connection conn;

    public Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ThreadBTL";
        this.conn = DriverManager.getConnection(url, "root", "");

    }

    public ResultSet getData(String tbname) throws SQLException {
        Statement ts = this.conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from " + tbname;
        rs = ts.executeQuery(sql);
        return rs;

    }

}
