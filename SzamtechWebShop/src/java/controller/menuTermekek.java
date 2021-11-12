package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.*;
import model.*;

public class menuTermekek extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        
        ArrayList<Termek> termekek = wbservice.getTermekek();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(  "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <title>Webshop</title>\n" +
                        "    <link rel='stylesheet' href='RES/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "        <nav>\n" +
                        "            <a href='index.html'class='logo'><img src='res/logo.png' alt='logo helye'></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\">Kezdőlap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\">Termékek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\">Támogatóink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\">Bejelentkezés</button>\n" +
                        "            </form>\n" +
                        "            <div class='szolgaltatasok'>\n" +
                        "            <a href='' class='funkciok'><img src='res/login.png' alt='login kép'></a>\n" +
                        "            <a href='' class='funkciok'><img src='res/basket.png' alt='kosár kép'></a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <div class='mainContainer'>\n" +
                        "        <aside class='leirasAside'>\n" +
                        "            <form action='szures' method='post'>\n" +
                        "                <ul>\n" +
                        "                    <li>\n" +
                        "                        <input type='checkbox' id = '1' name = '2'>\n" +
                        "                       <label for='1'>Szamitogep</label>\n" +
                        "                    </li>\n" +
                        "                    <li>\n" +
                        "                        <input type='checkbox' id = '2' name = '2'>\n" +
                        "                      <label for='2'>telefonok</label>\n" +
                        "                    </li>\n" +
                        "                    <li>\n" +
                        "                        <input type='checkbox' id = '3' name = '2'>\n" +
                        "                        <label for='3'>tabletek</label>\n" +
                        "                    </li>\n" +
                        "                </ul>\n" +
                        "                <button type='submit'>Szűrés</button>\n" +
                        "            </form>\n" +
                        "        </aside>\n" +
                        "        <main class='termekek'>\n" +
                        "            <div class = 'mainFlex'>\n");
            for (Termek t :  termekek){
                if (t.getTermekNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                <div class='termek'>\n" +
                            "                    <img src='RES/lany_geppel.jpg' alt=''>\n" + //ide majd be kell rakni a kepek URLjet, de meg nincs, anonym nem is fog megjelenni
                            "                    <div class='termekContainer'>\n" +
                            "                        <h3 class='termekAdat'>"+t.getTermekNev()+"</h3>\n" +
                            "                        <h4 class='termekAdat'>"+t.getTermekAr()+"</h4>\n" +
                            "                        <form class='termekAdat' action='termekOldal' method='post'>\n" +
                            "                           <button type='submit' name='"+t.getTermekNev()+"'>Megtekintes</button>\n" +
                            "                        </form>\n" +
                            "                    </div>\n" +
                            "                </div>\n");
                }
            }
            out.print(  "            </div>\n" +
                        "        </main>\n" +
                        "    </div>\n" +
                        "</body>");
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
