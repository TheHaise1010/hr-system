package com.example.demo.controllers;

import com.example.demo.daos.CargoDao;
import com.example.demo.models.Cargo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cargo")
public class CargoServlet extends HttpServlet {
    private CargoDao cargoDao;

    @Override
    public void init() {
        cargoDao = new CargoDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listCargos(request, response);
                    break;
                case "create":
                    createCargo(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateCargo(request, response);
                    break;
                case "delete":
                    deleteCargo(request, response);
                    break;
                case "showCreateForm":
                    showCreateForm(request, response);
                    break;
                default:
                    listCargos(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new IOException(ex);
        }
    }

    private void listCargos(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Cargo> cargos = cargoDao.getAllCargos();
        request.setAttribute("cargos", cargos);
        try {
            request.getRequestDispatcher("/views/Cargo/list-cargos.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/views/Cargo/create-cargo.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
    private void createCargo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cargo = request.getParameter("cargo");
        String descripcionCargo = request.getParameter("descripcionCargo");
        boolean jefatura = Boolean.parseBoolean(request.getParameter("jefatura"));

        Cargo cargoObj = new Cargo();
        cargoObj.setCargo(cargo);
        cargoObj.setDescripcionCargo(descripcionCargo);
        cargoObj.setJefatura(jefatura);

        cargoDao.addCargo(cargoObj);
        response.sendRedirect("cargo?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cargo existingCargo = cargoDao.getCargoById(id);
        request.setAttribute("cargo", existingCargo);
        try {
            request.getRequestDispatcher("/views/edit-cargo.jsp").forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void updateCargo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cargo = request.getParameter("cargo");
        String descripcionCargo = request.getParameter("descripcionCargo");
        boolean jefatura = Boolean.parseBoolean(request.getParameter("jefatura"));

        Cargo cargoObj = new Cargo();
        cargoObj.setIdCargo(id);
        cargoObj.setCargo(cargo);
        cargoObj.setDescripcionCargo(descripcionCargo);
        cargoObj.setJefatura(jefatura);

        cargoDao.updateCargo(cargoObj);
        response.sendRedirect("cargos?action=list");
    }

    private void deleteCargo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cargoDao.deleteCargo(id);
        response.sendRedirect("cargos?action=list");
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
