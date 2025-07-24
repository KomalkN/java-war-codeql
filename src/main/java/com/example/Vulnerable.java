package com.example;
import java.sql.*;

public class Vulnerable {
    public void getUser(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password");
        Statement stmt = conn.createStatement();
        // SQL Injection vulnerability
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + userId + "'");
        while (rs.next()) {
            System.out.println("User: " + rs.getString("name"));
        }
    }
}
