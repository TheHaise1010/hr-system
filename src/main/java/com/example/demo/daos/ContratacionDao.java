package com.example.demo.daos;

import com.example.demo.models.Contratacion;
import com.example.demo.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratacionDao {

    public List<Contratacion> getAllContrataciones() throws SQLException {
        List<Contratacion> contrataciones = new ArrayList<>();
        String query = "SELECT * FROM Contrataciones";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Contratacion contratacion = new Contratacion();
                contratacion.setIdContratacion(resultSet.getInt("idContratacion"));
                contratacion.setIdDepartamento(resultSet.getInt("idDepartamento"));
                contratacion.setIdEmpleado(resultSet.getInt("idEmpleado"));
                contratacion.setIdCargo(resultSet.getInt("idCargo"));
                contratacion.setIdTipoContratacion(resultSet.getInt("idTipoContratacion"));
                contratacion.setFechaContratacion(resultSet.getDate("fechaContratacion"));
                contratacion.setSalario(resultSet.getDouble("salario"));
                contratacion.setEstado(resultSet.getBoolean("estado"));
                contrataciones.add(contratacion);
            }
        }
        return contrataciones;
    }

    public void addContratacion(Contratacion contratacion) throws SQLException {
        String query = "INSERT INTO Contrataciones (idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, contratacion.getIdDepartamento());
            statement.setInt(2, contratacion.getIdEmpleado());
            statement.setInt(3, contratacion.getIdCargo());
            statement.setInt(4, contratacion.getIdTipoContratacion());
            statement.setDate(5, new Date(contratacion.getFechaContratacion().getTime()));
            statement.setDouble(6, contratacion.getSalario());
            statement.setBoolean(7, contratacion.isEstado());
            statement.executeUpdate();
        }
    }

    public Contratacion getContratacionById(int id) throws SQLException {
        Contratacion contratacion = null;
        String query = "SELECT * FROM Contrataciones WHERE idContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    contratacion = new Contratacion();
                    contratacion.setIdContratacion(resultSet.getInt("idContratacion"));
                    contratacion.setIdDepartamento(resultSet.getInt("idDepartamento"));
                    contratacion.setIdEmpleado(resultSet.getInt("idEmpleado"));
                    contratacion.setIdCargo(resultSet.getInt("idCargo"));
                    contratacion.setIdTipoContratacion(resultSet.getInt("idTipoContratacion"));
                    contratacion.setFechaContratacion(resultSet.getDate("fechaContratacion"));
                    contratacion.setSalario(resultSet.getDouble("salario"));
                    contratacion.setEstado(resultSet.getBoolean("estado"));
                }
            }
        }
        return contratacion;
    }

    public void updateContratacion(Contratacion contratacion) throws SQLException {
        String query = "UPDATE Contrataciones SET idDepartamento = ?, idEmpleado = ?, idCargo = ?, idTipoContratacion = ?, fechaContratacion = ?, salario = ?, estado = ? WHERE idContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, contratacion.getIdDepartamento());
            statement.setInt(2, contratacion.getIdEmpleado());
            statement.setInt(3, contratacion.getIdCargo());
            statement.setInt(4, contratacion.getIdTipoContratacion());
            statement.setDate(5, new Date(contratacion.getFechaContratacion().getTime()));
            statement.setDouble(6, contratacion.getSalario());
            statement.setBoolean(7, contratacion.isEstado());
            statement.setInt(8, contratacion.getIdContratacion());
            statement.executeUpdate();
        }
    }

    public void deleteContratacion(int id) throws SQLException {
        String query = "DELETE FROM Contrataciones WHERE idContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
