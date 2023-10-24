package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/Northwind";
        String username = "postgres";
        String password = "root123";
//         connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database.");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Unable to connect to the database.", e);
        }

        return connection;
    }

//    public Connection closeConnection(){
//        try {
//            if(connection != null){
//                connection.close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }
}
