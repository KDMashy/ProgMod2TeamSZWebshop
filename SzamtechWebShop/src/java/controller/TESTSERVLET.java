/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;
import model.*;

/**
 *
 * @author domak
 */
public class TESTSERVLET extends HttpServlet {

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
        
        //szamla torles teszt
        //Boolean bool = wbservice.anonymVasarlas("asd");
        //szamla teszt
        /*ArrayList<String> stringData = new ArrayList<>();
        stringData.add("asd");
        stringData.add("asd");
        stringData.add("asd");
        stringData.add("asd");
        stringData.add("asd");
        stringData.add("asd");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
        String ido = dateFormat.format(date);
        Short x = 0;
        Boolean bool = wbservice.createSzamla(stringData, x, 3, ido, 1);*/
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TESTSERVLET</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>tesztelésre van</h1>");
            //alabbit tesztelni kell, meg nincsenek termekek xd
            /*for (Termek t : termekek){
                out.println("<h2>"+t.getTermekID()+t.getTermekNev()+"</h2>");
            }*/
            //teszteltem, anonymizálás egész listára volt
            /*ArrayList<Vevo> vevok = wbservice.getVevok();
            for (Vevo t : vevok) {
                anonym = wbservice.anonymisation(t.getVevoNev());
                out.println("<h1>Servlet TESTSERVLET at" + anonym + " " + t.getVevoNev() + "</h1>");
            }*/
            out.println("</body>");
            out.println("</html>");
        }
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
