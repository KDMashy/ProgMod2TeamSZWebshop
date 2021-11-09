package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import service.WebShopService;

public class Register extends HttpServlet {

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
        WebShopService wbservice = new WebShopService();
        String VevoName = request.getParameter("name");
        String VevoEmail = request.getParameter("email");
        String VevoPassw = request.getParameter("password");
        
        Boolean saved = wbservice.RegAcc(VevoName, VevoEmail, VevoPassw);
        VevoPassw = wbservice.encrypt(VevoPassw);
        
        HttpSession session = request.getSession();
        session.setAttribute("name", VevoName);
        session.setAttribute("email", VevoEmail);
        session.setAttribute("password", VevoPassw);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + saved + "</h1>");
            out.println("<h2>Welcome " + VevoName + "</h2>");
            /*out.println("<form action='TESTSERVLET'>");
            out.println("<input type='submit' value='TESTSERVLET' />");
            out.println("</form>");*/
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /*public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String n = request.getParameter("name");
            out.print("Welcome"+n);
            
            Cookie ck = new Cookie("username", n);
            response.addCookie(ck);
            
            out.print("<form action='logAcc'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");
            
            out.close();
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }*/

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
