package controller.createThings;

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
import model.*;
import service.*;

public class tremekekVasarlasa extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        ArrayList<KosarElem> Kosar = (ArrayList<KosarElem>)session.getAttribute("kosar");
        ArrayList<Termek> termekek = wbservice.getTermekek();
        ArrayList<String> vtm = new ArrayList<>();
        ArrayList<Integer> vtmInt = new ArrayList<>();
        ArrayList<String> stringData = new ArrayList<>();
        Integer elfogad = Integer.parseInt(request.getParameter("accept"));
        
        if (elfogad == 1) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssZ");
            String ido = dateFormat.format(date);

            for (KosarElem ke: Kosar){
                vtm.add(ke.getName());
                vtmInt.add(ke.getAmount());
            }
            Short MINDIG = 1;
            
            String egyeb = request.getParameter("egyebInfoByFelh");
            egyeb += "<-MEGJEGYZÉS/";
            for (Integer i = 0; i < vtm.size(); i++) {
                Termek t = wbservice.getTermek(vtm.get(i), termekek);
                egyeb += "//--SZÁMLA ITEM: "+vtm.get(i)+"--"+t.getTermekAr()+" Ft--Mennyiség: "+vtmInt.get(i)+"--/";
            }
            stringData.add(session.getAttribute("name").toString());
            stringData.add(request.getParameter("fizmod"));
            stringData.add(request.getParameter("varos"));
            stringData.add(request.getParameter("hszam"));
            stringData.add(egyeb);
            stringData.add(request.getParameter("irszam"));
        
            Boolean saved = wbservice.createSzamla(stringData, MINDIG, ido, vtmInt, vtm);

            response.sendRedirect("listVasarlasok");
        } else {
            response.sendRedirect("kosar");
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
