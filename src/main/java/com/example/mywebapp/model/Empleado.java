package com.example.mywebapp.model;

import java.util.Calendar;
import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private String numeroDui;
    private String nombrePersona;
    private String usuario;
    private String numeroTelefono;
    private String correoInstitucional;
    private Date fechaNacimiento;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        if (idEmpleado <= 0) {
            throw new IllegalArgumentException("ID debe ser positivo");
        }
        this.idEmpleado = idEmpleado;
    }
    public String getNumeroDui() {
        return numeroDui;
    }

    public void setNumeroDui(String numeroDui) {
        if (!numeroDui.matches("^[0-9]{8}-[0-9]$")) {
            throw new IllegalArgumentException("Numero DUI debe tener 8 digitos, un guion y otro digito");
        }
        this.numeroDui = numeroDui;
    }
    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        if (!numeroTelefono.matches("^[0-9]{8}$")) {
            throw new IllegalArgumentException("Numero de telefono debe tener 8 digitos");
        }
        this.numeroTelefono = numeroTelefono;
    }
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        if (!correoInstitucional.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("FOrmato de correo invalido");
        }
        this.correoInstitucional = correoInstitucional;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        if (esMayorDeEdad(fechaNacimiento)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            throw new IllegalArgumentException("La persona debe tener al menos 18 años.");
        }
    }

    private boolean esMayorDeEdad(Date fechaNacimiento) {
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH) ||
                (hoy.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH) && hoy.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad >= 18;
    }
}
