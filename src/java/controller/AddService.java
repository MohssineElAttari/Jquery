/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.Service;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceService;

/**
 *
 * @author Laassili Oussama
 */
@WebServlet(name = "AddService", urlPatterns = {"/AddService"})
public class AddService extends HttpServlet {

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
        String nom = request.getParameter("nomService");
        String date = request.getParameter("date").replace("-", "/");
        String prix = request.getParameter("prix");
        String operation = request.getParameter("operation");   
        ServiceService ss = new ServiceService();
        System.out.println(operation);
        if(operation.equals("add")){
            ss.create(new Service(nom, new Date(date),Double.parseDouble(prix)));
        }else if(operation.equals("update")){
            String id=request.getParameter("id");
           Service s = ss.findById(Integer.parseInt(id));
           s.setNomService(nom);
           s.setPrix(Double.parseDouble(prix));
           s.setDate(new Date(date));
           ss.update(s);
    }
        response.setContentType("application/json");
        Gson g = new Gson();
        g.toJson(ss.findAll(), response.getWriter());
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
