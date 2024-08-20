package com.example.demo.controllers;

import com.example.demo.daos.TipoContratacionDao;
import com.example.demo.models.TipoContratacion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tiposcontratacion")
public class TipoContratacionServlet extends HttpServlet {
    private TipoContratacionDao tipoContratacionDao;

    @Override
    public void init() {
        tipoContratacionDao = new TipoContratacionDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listTiposContratacion(request, response);
                    break;
                case "create":
                    createTipoContratacion(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateTipoContratacion(request, response);
                    break;
                case "delete":
                    deleteTipoContratacion(request, response);
                    break;
                default:
                    listTiposContratacion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new IOException(ex);
        }
    }

    private void listTiposContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<TipoContratacion> tiposContratacion = tipoContratacionDao.getAllTiposContratacion();
        request.setAttribute("tiposContratacion", tiposContratacion);
        try {
            request.getRequestDispatcher("/views/TipoContratacion/list-tipo-contrataciones.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void createTipoContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String tipoContratacion = request.getParameter("tipoContratacion");

        TipoContratacion tipoContratacionObj = new TipoContratacion();
        tipoContratacionObj.setTipoContratacion(tipoContratacion);

        tipoContratacionDao.addTipoContratacion(tipoContratacionObj);
        response.sendRedirect("tiposcontratacion?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TipoContratacion existingTipoContratacion = tipoContratacionDao.getTipoContratacionById(id);
        request.setAttribute("tipoContratacion", existingTipoContratacion);
        try {
            request.getRequestDispatcher("/views/edit-tipocontratacion.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void updateTipoContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tipoContratacion = request.getParameter("tipoContratacion");

        TipoContratacion tipoContratacionObj = new TipoContratacion();
        tipoContratacionObj.setIdTipoContratacion(id);
        tipoContratacionObj.setTipoContratacion(tipoContratacion);

        tipoContratacionDao.updateTipoContratacion(tipoContratacionObj);
        response.sendRedirect("tiposcontratacion?action=list");
    }

    private void deleteTipoContratacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        tipoContratacionDao.deleteTipoContratacion(id);
        response.sendRedirect("tiposcontratacion?action=list");
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
