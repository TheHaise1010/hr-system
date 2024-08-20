package com.example.demo.daos;

import com.example.demo.models.Cargo;
import com.example.demo.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDao {

    public List<Cargo> getAllCargos() throws SQLException {
        List<Cargo> cargos = new ArrayList<>();
        String query = "SELECT * FROM Cargos";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(resultSet.getInt("idCargo"));
                cargo.setCargo(resultSet.getString("cargo"));
                cargo.setDescripcionCargo(resultSet.getString("descripcionCargo"));
                cargo.setJefatura(resultSet.getBoolean("jefatura"));
                cargos.add(cargo);
            }
        }
        return cargos;
    }

    public void addCargo(Cargo cargo) throws SQLException {
        String query = "INSERT INTO Cargos (cargo, descripcionCargo, jefatura) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cargo.getCargo());
            statement.setString(2, cargo.getDescripcionCargo());
            statement.setBoolean(3, cargo.isJefatura());
            statement.executeUpdate();
        }
    }

    public Cargo getCargoById(int id) throws SQLException {
        Cargo cargo = null;
        String query = "SELECT * FROM Cargos WHERE idCargo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cargo = new Cargo();
                    cargo.setIdCargo(resultSet.getInt("idCargo"));
                    cargo.setCargo(resultSet.getString("cargo"));
                    cargo.setDescripcionCargo(resultSet.getString("descripcionCargo"));
                    cargo.setJefatura(resultSet.getBoolean("jefatura"));
                }
            }
        }
        return cargo;
    }

    public void updateCargo(Cargo cargo) throws SQLException {
        String query = "UPDATE Cargos SET cargo = ?, descripcionCargo = ?, jefatura = ? WHERE idCargo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cargo.getCargo());
            statement.setString(2, cargo.getDescripcionCargo());
            statement.setBoolean(3, cargo.isJefatura());
            statement.setInt(4, cargo.getIdCargo());
            statement.executeUpdate();
        }
    }

    public void deleteCargo(int id) throws SQLException {
        String query = "DELETE FROM Cargos WHERE idCargo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
