package controller.listThings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;
import model.*;

public class listTermek extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        
        ArrayList<Termek> termekek = wbservice.getTermekek();
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
                        "                            <th>Termék neve</th>\n" +
                        "                            <th>Leírás</th>\n" +
                        "                            <th>Ár</th>\n" +
                        "                            <th>Kép</th>\n" +
                        "                            <th>Készleten van-e</th>\n" +
                        "                            <th>Kategória</th>\n"
                                + "                  <th>Termék törlése</th>" +
                        "                        </tr>\n" +
                        "                    </thead>\n" +
                        "                    <tbody>\n");
            for (Termek t : termekek){
                if (t.getTermekNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                        <tr>\n" +
                            "                            <td>"+t.getTermekNev()+"</td>\n" +
                            "                            <td>"+t.getTermekDesc()+"</td>\n" +
                            "                            <td>"+t.getTermekAr()+"</td>\n" +
                            "                            <td>"+t.getTermekKep()+"</td>\n" +
                            "                            <td>"+t.getTermekKeszlet()+"</td>\n" +
                            "                            <td>"+t.getTermekKatID()+"</td>\n"
                                    + "                  <td><form action='termekTorlese' method='post'>"
                                    + "<button type='submit' name='deleteTermek' value='"+t.getTermekID()+"'>Termék törlése</button>"
                                    + "</form></td>\n" +
                            "                        </tr>\n");
                }
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
