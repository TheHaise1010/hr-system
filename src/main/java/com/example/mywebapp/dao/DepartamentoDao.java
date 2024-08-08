package com.example.mywebapp.dao;

import com.example.mywebapp.model.Departamento;
import com.example.mywebapp.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDao {

    public List<Departamento> getAllDepartamentos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM Departamento";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setIdDepartamento(resultSet.getInt("idDepartamento"));
                departamento.setNombreDepartamento(resultSet.getString("nombreDepartamento"));
                departamento.setDescripcionDepartamento(resultSet.getString("descripcionDepartamento"));
                departamentos.add(departamento);
            }
        }
        return departamentos;
    }

    public void addDepartamento(Departamento departamento) throws SQLException {
        String query = "INSERT INTO Departamento (nombreDepartamento, descripcionDepartamento) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departamento.getNombreDepartamento());
            statement.setString(2, departamento.getDescripcionDepartamento());
            statement.executeUpdate();
        }
    }

    public Departamento getDepartamentoById(int id) throws SQLException {
        Departamento departamento = null;
        String query = "SELECT * FROM Departamento WHERE idDepartamento = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    departamento = new Departamento();
                    departamento.setIdDepartamento(resultSet.getInt("idDepartamento"));
                    departamento.setNombreDepartamento(resultSet.getString("nombreDepartamento"));
                    departamento.setDescripcionDepartamento(resultSet.getString("descripcionDepartamento"));
                }
            }
        }
        return departamento;
    }

    public void updateDepartamento(Departamento departamento) throws SQLException {
        String query = "UPDATE Departamento SET nombreDepartamento = ?, descripcionDepartamento = ? WHERE idDepartamento = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departamento.getNombreDepartamento());
            statement.setString(2, departamento.getDescripcionDepartamento());
            statement.setInt(3, departamento.getIdDepartamento());
            statement.executeUpdate();
        }
    }

    public void deleteDepartamento(int id) throws SQLException {
        String query = "DELETE FROM Departamento WHERE idDepartamento = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
