package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import service.*;

public class elfelejtettJelszo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String kepLink = "/SzamtechWebShop/menuMain";
        String basket = "/SzamtechWebShop/kosar";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Webshop</title>\n" +
                        "    <link rel=\"stylesheet\" href=\"RES/style.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "        <nav>\n" +
                        "            <a href=\""+kepLink+"\" class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Bejelentkezés</button>\n" +
                        "            </form>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main>\n" +
                        "        <div class='bejelentkezes'>\n" +
                        "            <form action='forgotPassword' method='post'>\n"
                                + "     <label style='color: #08ffd1'><b>Adja meg az email címét:</b></label><br><br>\n"
                                + "     <input type='email' name='forgotEmail'><br><br>\n"
                                + "     <input type='submit' value='Kérelem küldése' class='bekuld'>\n"
                                + "</form>\n" +
                        "        </div>\n" +
                        "    </main>\n" +
                        "    <footer>\n" +
                        "        <section class = \"bemutatkozas\">\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>Elérhetőségek:</h3>\n" +
                        "                <br>\n" +
                        "                <div class=\"footer_elerhetoseg\">\n" +
                        "                    <img src=\"RES/free-phone-icon-vector-27.jpg\" alt=\"\">\n" +
                        "                    <p class=\"footer_elerhetoseg_szoveg\">+36 20 123 4567</p>\n" +
                        "                </div>\n" +
                        "                <div class=\"footer_elerhetoseg\">\n" +
                        "                    <img src=\"RES/email-vector-icon-png-17.jpg\" alt=\"\">\n" +
                        "                    <a href=\"mailto: eznemisletezik@gmail.com\">eznemisletezik@gmail.com</a>\n" +
                        "                </div>\n" +
                        "                <div class=\"footer_elerhetoseg\">\n" +
                        "                    <img src=\"RES/gps-icon-vector-7.jpg\" alt=\"\">\n" +
                        "                    <p class=\"footer_elerhetoseg_szoveg\">7620 Pécs PTE - TTK</p>\n" +
                        "                </div>  \n" +
                        "            </div>\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>Információk rólunk: </h3>\n" +
                        "                <br><br>\n" +
                        "                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Doloribus, tempore!</p>\n" +
                        "                <br>\n" +
                        "                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolorem blanditiis ipsum, nulla dicta facere eius quos quae quasi nihil tenetur?</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>Támogatóint: </h3>\n" +
                        "                <br><br>\n" +
                        "                <div class = \"footer_tamogatok\">\n" +
                        "                    <p>lelépünk a pénzel kft</p>\n" +
                        "                    <br>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </section>\n" +
                        "    </footer>\n" +
                        "</body>\n" +
                        "</html>");
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
