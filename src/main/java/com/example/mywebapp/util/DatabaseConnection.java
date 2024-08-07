package com.example.mywebapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root"; // Cambia esto a tu usuario de MySQL
    private static final String PASSWORD = "1234"; // Cambia esto a tu contraseña de MySQL

    public static Connection getConnection() throws SQLException {
        try {
            // Carga el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el controlador JDBC de MySQL", e);
        }
        // Establece la conexión a la base de datos
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}