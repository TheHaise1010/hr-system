package com.example.demo.models;

public class Cargo {
    private int idCargo;
    private String cargo;
    private String descripcionCargo;
    private boolean jefatura;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        if (idCargo <= 0) {
            throw new IllegalArgumentException("ID debe ser positivo");
        }
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public boolean isJefatura() {
        return jefatura;
    }

    public void setJefatura(boolean jefatura) {
        this.jefatura = jefatura;
    }
}