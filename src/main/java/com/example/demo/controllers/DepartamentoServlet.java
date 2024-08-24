package com.example.demo.controllers;

import com.example.demo.daos.DepartamentoDao;
import com.example.demo.models.Departamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/departamento")
public class DepartamentoServlet extends HttpServlet {
    private DepartamentoDao departamentoDao;

    @Override
    public void init(){
        departamentoDao = new DepartamentoDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listDepartamentos(request, response);
                    break;
                case "create":
                    createDepartamento(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateDepartamento(request, response);
                    break;
                case "delete":
                    deleteDepartamento(request, response);
                    break;
                case "showCreateForm":
                    showCreateForm(request, response);
                    break;
                default:
                    listDepartamentos(request, response);
                    break;
            }
        } catch (SQLException | ServletException ex) {
            throw new IOException(ex);
        }
    }

    private void listDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Departamento> departamentos = departamentoDao.getAllDepartamentos();
        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("/views/Departamento/list-departamentos.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/views/Departamento/create-departamento.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void createDepartamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombreDepartamento = request.getParameter("nombreDepartamento");
        String descripcionDepartamento = request.getParameter("descripcionDepartamento");

        Departamento departamento = new Departamento();
        departamento.setNombreDepartamento(nombreDepartamento);
        departamento.setDescripcionDepartamento(descripcionDepartamento);

        departamentoDao.addDepartamento(departamento);
        response.sendRedirect("departamento?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Departamento existingDepartamento = departamentoDao.getDepartamentoById(id);
        request.setAttribute("departamento", existingDepartamento);
        request.getRequestDispatcher("/views/edit-departamento.jsp").forward(request, response);
    }

    private void updateDepartamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombreDepartamento = request.getParameter("nombreDepartamento");
        String descripcionDepartamento = request.getParameter("descripcionDepartamento");

        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(id);
        departamento.setNombreDepartamento(nombreDepartamento);
        departamento.setDescripcionDepartamento(descripcionDepartamento);

        departamentoDao.updateDepartamento(departamento);
        response.sendRedirect("departamentos?action=list");
    }

    private void deleteDepartamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        departamentoDao.deleteDepartamento(id);
        response.sendRedirect("departamentos?action=list");
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
