package com.demo.jdbc;

import java.sql.*;
//jdbc can connect only to rdbms
public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "root");
        System.out.println("Connection is created");

    }
}
