package com.example.demo.daos;

import com.example.demo.models.Empleado;
import com.example.demo.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {

    public List<Empleado> getAllEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM Empleados";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setNumeroDui(resultSet.getString("numeroDui"));
                empleado.setNombrePersona(resultSet.getString("nombrePersona"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleado.setNumeroTelefono(resultSet.getString("numeroTelefono"));
                empleado.setCorreoInstitucional(resultSet.getString("correoInstitucional"));
                empleado.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public void addEmpleado(Empleado empleado) throws SQLException {
        String query = "INSERT INTO Empleados (numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado.getNumeroDui());
            statement.setString(2, empleado.getNombrePersona());
            statement.setString(3, empleado.getUsuario());
            statement.setString(4, empleado.getNumeroTelefono());
            statement.setString(5, empleado.getCorreoInstitucional());
            statement.setDate(6, new Date(empleado.getFechaNacimiento().getTime()));
            statement.executeUpdate();
        }
    }

    public boolean duiExists(String numeroDui) throws SQLException {
        String query = "SELECT COUNT(*) FROM Empleados WHERE numeroDui = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, numeroDui);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    public Empleado getEmpleadoById(String id) throws SQLException {
        Empleado empleado = null;
        String query = "SELECT * FROM Empleados WHERE numeroDui = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                    empleado.setNumeroDui(resultSet.getString("numeroDui"));
                    empleado.setNombrePersona(resultSet.getString("nombrePersona"));
                    empleado.setUsuario(resultSet.getString("usuario"));
                    empleado.setNumeroTelefono(resultSet.getString("numeroTelefono"));
                    empleado.setCorreoInstitucional(resultSet.getString("correoInstitucional"));
                    empleado.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                }
            }
        }
        return empleado;
    }

    public void updateEmpleado(Empleado empleado) throws SQLException {
        String query = "UPDATE Empleados SET numeroDui = ?, nombrePersona = ?, usuario = ?, numeroTelefono = ?, correoInstitucional = ?, fechaNacimiento = ? WHERE idEmpleado = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado.getNumeroDui());
            statement.setString(2, empleado.getNombrePersona());
            statement.setString(3, empleado.getUsuario());
            statement.setString(4, empleado.getNumeroTelefono());
            statement.setString(5, empleado.getCorreoInstitucional());
            statement.setDate(6, new Date(empleado.getFechaNacimiento().getTime()));
            statement.setInt(7, empleado.getIdEmpleado());
            statement.executeUpdate();
        }
    }

    public void deleteEmpleado(String id) throws SQLException {
        String query = "DELETE FROM Empleados WHERE numeroDui = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }
}
