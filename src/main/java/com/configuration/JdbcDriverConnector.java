package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDriverConnector {
    private Connection connection;
    private static final  String USERNAME="root";
    private static final  String PASSWORD="03041984";
    private static final  String BASE_URL="jdbc:mysql://localhost:3306/";
    private static final String DATA_BASE_NAME="mydb";

    public void dbDriverSetUp(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            connection= DriverManager.getConnection(BASE_URL + DATA_BASE_NAME, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public Connection getConnection(){return connection;}
}
