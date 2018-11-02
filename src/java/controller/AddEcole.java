/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Ecole;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EcoleService;

/**
 *
 * @author a
 */
@WebServlet(name = "AddEcole", urlPatterns = {"/AddEcole"})
public class AddEcole extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String tel = request.getParameter("tel");
        String adresse = request.getParameter("adresse");
        int nbrEtudiant = Integer.parseInt(request.getParameter("nbrEtudiant"));
        String operation = request.getParameter("operation");
        EcoleService es = new EcoleService();
        System.out.println(operation);
        if (operation.equals("add")) {
            es.create(new Ecole(nom, adresse, tel, nbrEtudiant));
        } else if (operation.equals("update")) {
            String id = request.getParameter("id");
            Ecole e = es.findById(Integer.parseInt(id));
            e.setNom(nom);
            e.setTel(tel);
            e.setAdresse(adresse);
            e.setNbrEtudiant(nbrEtudiant);
            es.update(e);
        }
        response.setContentType("application/json");
        Gson g = new Gson();
        g.toJson(es.findAll(), response.getWriter());

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
