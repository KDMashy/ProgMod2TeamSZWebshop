package controller.createThings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import service.*;

public class createTermek extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        //adatok lekerese
        request.setCharacterEncoding("UTF-8");
        String TName = request.getParameter("termekName");
        String TDesc = request.getParameter("termekDesc");
        String TImg = request.getParameter("termekKepURL");
        Short bool = Short.parseShort(request.getParameter("stock"));
        Short katID = Short.parseShort(request.getParameter("KategoriaVal"));
        Integer price = Integer.parseInt(request.getParameter("termekAr"));
        
        ArrayList<String> TData = new ArrayList<>();
        TData.add(TName);
        TData.add(TDesc);
        TData.add(TImg);
        
        Boolean create = wbservice.createTermek(TData, bool, katID, price);
        if (create) {
            response.sendRedirect("listTermek");
        } else {
            response.sendRedirect("adminSite");
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
