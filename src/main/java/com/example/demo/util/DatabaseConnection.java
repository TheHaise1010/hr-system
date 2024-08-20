package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "1234";

    public static Connection getConnection() {
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true";
        connection = DriverManager.getConnection(url, "root", "1234");
    } catch (ClassNotFoundException e) {
        System.out.println("No se encontró la clase del driver JDBC de MySQL. Asegúrate de que el driver JDBC de MySQL esté correctamente incluido en tu proyecto.");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Ocurrió un error al intentar conectarse a la base de datos. Aquí están los detalles del error:");
        e.printStackTrace();
    }
    return connection;
}
}