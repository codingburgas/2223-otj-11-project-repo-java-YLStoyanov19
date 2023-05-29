package com.example.chess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static String connectionString = "jdbc:sqlserver://GL029\\sqlexpress;databaseName=JavaProject;integratedSecurity=true";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }
}