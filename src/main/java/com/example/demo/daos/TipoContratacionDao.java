package com.example.demo.daos;

import com.example.demo.models.TipoContratacion;
import com.example.demo.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoContratacionDao {

    public List<TipoContratacion> getAllTiposContratacion() throws SQLException {
        List<TipoContratacion> tiposContratacion = new ArrayList<>();
        String query = "SELECT * FROM TipoContratacion";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TipoContratacion tipoContratacion = new TipoContratacion();
                tipoContratacion.setIdTipoContratacion(resultSet.getInt("idTipoContratacion"));
                tipoContratacion.setTipoContratacion(resultSet.getString("tipoContratacion"));
                tiposContratacion.add(tipoContratacion);
            }
        }
        return tiposContratacion;
    }

    public void addTipoContratacion(TipoContratacion tipoContratacion) throws SQLException {
        String query = "INSERT INTO TipoContratacion (tipoContratacion) VALUES (?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tipoContratacion.getTipoContratacion());
            statement.executeUpdate();
        }
    }

    public TipoContratacion getTipoContratacionById(int id) throws SQLException {
        TipoContratacion tipoContratacion = null;
        String query = "SELECT * FROM TipoContratacion WHERE idTipoContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tipoContratacion = new TipoContratacion();
                    tipoContratacion.setIdTipoContratacion(resultSet.getInt("idTipoContratacion"));
                    tipoContratacion.setTipoContratacion(resultSet.getString("tipoContratacion"));
                }
            }
        }
        return tipoContratacion;
    }

    public void updateTipoContratacion(TipoContratacion tipoContratacion) throws SQLException {
        String query = "UPDATE TipoContratacion SET tipoContratacion = ? WHERE idTipoContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tipoContratacion.getTipoContratacion());
            statement.setInt(2, tipoContratacion.getIdTipoContratacion());
            statement.executeUpdate();
        }
    }

    public void deleteTipoContratacion(int id) throws SQLException {
        String query = "DELETE FROM TipoContratacion WHERE idTipoContratacion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
