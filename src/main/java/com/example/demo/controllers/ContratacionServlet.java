package com.example.demo.controllers;

import com.example.demo.daos.*;
import com.example.demo.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/contrataciones")
public class ContratacionServlet extends HttpServlet {
    private ContratacionDao contratacionDao;
    private EmpleadoDao empleadoDao;
    private DepartamentoDao departamentoDao;
    private CargoDao cargoDao;
    private TipoContratacionDao tipoContratacionDao;

    @Override
    public void init() {
        contratacionDao = new ContratacionDao();
        empleadoDao = new EmpleadoDao();
        departamentoDao = new DepartamentoDao();
        cargoDao = new CargoDao();
        tipoContratacionDao = new TipoContratacionDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listContrataciones(request, response);
                    break;
                case "create":
                    createContratacion(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateContratacion(request, response);
                    break;
                case "delete":
                    deleteContratacion(request, response);
                    break;
                case "showCreateForm":
                    showCreateForm(request, response);
                    break;
                default:
                    listContrataciones(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new IOException(ex);
        }
    }

    private void listContrataciones(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Contratacion> contrataciones = contratacionDao.getAllContrataciones();
        request.setAttribute("contrataciones", contrataciones);
        try {
            request.getRequestDispatcher("/views/Contratacion/list-contrataciones.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Empleado> empleados = empleadoDao.getAllEmpleados();
            List<Departamento> departamentos = departamentoDao.getAllDepartamentos();
            List<Cargo> cargos = cargoDao.getAllCargos();
            List<TipoContratacion> tiposContratacion = tipoContratacionDao.getAllTiposContratacion();
            request.setAttribute("empleados", empleados);
            request.setAttribute("departamentos", departamentos);
            request.setAttribute("cargos", cargos);
            request.setAttribute("tiposContratacion", tiposContratacion);
            request.getRequestDispatcher("/views/Contratacion/create-contratacion.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }



    private void createContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idDepartamento = Integer.parseInt(request.getParameter("idDepartamento"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));
        int idTipoContratacion = Integer.parseInt(request.getParameter("idTipoContratacion"));
        Date fechaContratacion = Date.valueOf(request.getParameter("fechaContratacion"));
        double salario = Double.parseDouble(request.getParameter("salario"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));

        Contratacion contratacion = new Contratacion();
        contratacion.setIdDepartamento(idDepartamento);
        contratacion.setIdEmpleado(idEmpleado);
        contratacion.setIdCargo(idCargo);
        contratacion.setIdTipoContratacion(idTipoContratacion);
        contratacion.setFechaContratacion(fechaContratacion);
        contratacion.setSalario(salario);
        contratacion.setEstado(estado);

        contratacionDao.addContratacion(contratacion);
        response.sendRedirect("contrataciones?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Contratacion existingContratacion = contratacionDao.getContratacionById(id);

            List<Empleado> empleados = empleadoDao.getAllEmpleados();
            List<Departamento> departamentos = departamentoDao.getAllDepartamentos();
            List<Cargo> cargos = cargoDao.getAllCargos();
            List<TipoContratacion> tiposContratacion = tipoContratacionDao.getAllTiposContratacion();

            request.setAttribute("empleados", empleados);
            request.setAttribute("departamentos", departamentos);
            request.setAttribute("cargos", cargos);
            request.setAttribute("tiposContratacion", tiposContratacion);
            request.setAttribute("contratacion", existingContratacion);

            request.getRequestDispatcher("/views/Contratacion/create-contratacion.jsp").forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



    private void updateContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idDepartamento = Integer.parseInt(request.getParameter("idDepartamento"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));
        int idTipoContratacion = Integer.parseInt(request.getParameter("idTipoContratacion"));
        Date fechaContratacion = Date.valueOf(request.getParameter("fechaContratacion"));
        double salario = Double.parseDouble(request.getParameter("salario"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));

        Contratacion contratacion = new Contratacion();
        contratacion.setIdContratacion(id);
        contratacion.setIdDepartamento(idDepartamento);
        contratacion.setIdEmpleado(idEmpleado);
        contratacion.setIdCargo(idCargo);
        contratacion.setIdTipoContratacion(idTipoContratacion);
        contratacion.setFechaContratacion(fechaContratacion);
        contratacion.setSalario(salario);
        contratacion.setEstado(estado);

        contratacionDao.updateContratacion(contratacion);
        response.sendRedirect("contrataciones?action=list");
    }

    private void deleteContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        contratacionDao.deleteContratacion(id);
        response.sendRedirect("contrataciones?action=list");
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
