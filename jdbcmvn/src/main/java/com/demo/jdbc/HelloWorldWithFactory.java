package com.demo.jdbc;

import com.demo.factory.ConnectionFactory;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorldWithFactory {

    public static void main(String[] args) {

        Connection connection=null;
        try {
            connection= ConnectionFactory.getConnection();         //connection initiate

            PreparedStatement preparedStatement=connection
                    .prepareStatement("delete from emp where id=?");
            preparedStatement.setInt(1,2);

            int noOfRecordEffected= preparedStatement.executeUpdate();

            System.out.println(noOfRecordEffected);
            preparedStatement=connection.prepareStatement("select * from emp");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id")+" "+
                        rs.getString("name")+" "+rs.getInt("salary"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}