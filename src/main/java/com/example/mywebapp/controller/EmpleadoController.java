package com.example.mywebapp.controller;

import com.example.mywebapp.dao.EmpleadoDao;
import com.example.mywebapp.model.Empleado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/empleados")
public class EmpleadoController extends HttpServlet {
    private EmpleadoDao empleadoDao;

    @Override
    public void init(){
        empleadoDao = new EmpleadoDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listEmpleados(request, response);
                    break;
                case "create":
                    createEmpleado(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmpleado(request, response);
                    break;
                case "delete":
                    deleteEmpleado(request, response);
                    break;
                default:
                    listEmpleados(request, response);
                    break;
            }
        } catch (SQLException | ServletException ex) {
            throw new IOException(ex);
        }
    }

    private void listEmpleados(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Empleado> empleados = empleadoDao.getAllEmpleados();
        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("/views/empleado/list-empleados.jsp").forward(request, response);
    }

    private void createEmpleado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String numeroDui = request.getParameter("numeroDui");
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));

        Empleado empleado = new Empleado();
        empleado.setNumeroDui(numeroDui);
        empleado.setNombrePersona(nombrePersona);
        empleado.setUsuario(usuario);
        empleado.setNumeroTelefono(numeroTelefono);
        empleado.setCorreoInstitucional(correoInstitucional);
        empleado.setFechaNacimiento(fechaNacimiento);

        empleadoDao.addEmpleado(empleado);
        response.sendRedirect("empleados?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado existingEmpleado = empleadoDao.getEmpleadoById(id);
        request.setAttribute("empleado", existingEmpleado);
        request.getRequestDispatcher("/views/edit-empleado.jsp").forward(request, response);
    }

    private void updateEmpleado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String numeroDui = request.getParameter("numeroDui");
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        empleado.setNumeroDui(numeroDui);
        empleado.setNombrePersona(nombrePersona);
        empleado.setUsuario(usuario);
        empleado.setNumeroTelefono(numeroTelefono);
        empleado.setCorreoInstitucional(correoInstitucional);
        empleado.setFechaNacimiento(fechaNacimiento);

        empleadoDao.updateEmpleado(empleado);
        response.sendRedirect("empleados?action=list");
    }

    private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empleadoDao.deleteEmpleado(id);
        response.sendRedirect("empleados?action=list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
