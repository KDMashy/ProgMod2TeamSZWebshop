package controller.listThings;

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

public class listGyarto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        
        ArrayList<Gyarto> gyartok = wbservice.getGyartok();
        HttpSession session = request.getSession();
        
        String adminName = session.getAttribute("name").toString();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(  "<!DOCTYPE html>\n" +
                        "<html lang='hu'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <title>adminSite</title>\n" +
                        "    <meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>\n" +
                        "    <link rel='stylesheet' href='CSS/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class='adminContainer'>\n" +
                        "        <header>\n" +
                        "            <h1 class='showAdminName'>"+adminName+"</h1>\n" +
                        "            <div class='function'>\n" +
                        "                <form action='backAdmin' method='post'>\n" +
                        "                    <button type='submit'>Vissza</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "        </header>\n" +
                        "        <main>\n" +
                        "            <div class='function'>\n" +
                        "                <table class='theme'>\n" +
                        "                    <thead>\n" +
                        "                        <tr>\n" +
                        "                            <td>Gyártó neve</td>\n" +
                        "                            <td>Elérhetőség</td>\n" +
                        "                            <td>Gyártói Garancia</td>\n" +
                        "                        </tr>\n" +
                        "                    </thead>\n" +
                        "                    <tbody>\n");
            for (Gyarto t : gyartok){
                out.print(  "                        <tr>\n" +
                            "                            <td>"+t.getGyartoNev()+"</td>\n" +
                            "                            <td>"+t.getGyartoElerhetoseg()+"</td>\n" +
                            "                            <td>"+t.getGyartoiGarancia()+"</td>\n" +
                            "                        </tr>\n");
            }
            out.print(  "                    </tbody>\n" +
                        "                                        </table>\n" +
                        "                                    </div>\n" +
                        "                                </main>\n" +
                        "                            </div>\n" +
                        "                        </body>\n" +
                        "                        </html>');");
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
