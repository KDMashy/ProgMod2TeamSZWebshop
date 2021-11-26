package controller;

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

public class targyOldal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        String kepLink = "/SzamtechWebShop/menuMain";
        String basket = "/SzamtechWebShop/kosar";
        ArrayList<Termek> termekek = wbservice.getTermekek();
        
        String termekName = request.getParameter("getTermek");
        Integer tid = Integer.parseInt(termekName);
        
        Termek t = new Termek();
        for (Integer i = 0; i < termekek.size(); i++) {
            if (tid == termekek.get(i).getTermekID()) {
                t = termekek.get(i);
                termekName = t.getTermekNev();
            }
        }
        
        String van = "Nincs raktáron";
        if (t.getTermekKeszlet() == 1) {
            van = "Van raktáron";
        }
        
        ArrayList<Ertekeles> ertekek = wbservice.getErtekeles(t.getTermekID());
        float atl = wbservice.ertekelesForTermek(ertekek);
        
        HttpSession session = request.getSession();
        Integer type = (Integer)session.getAttribute("Type");
        if (type == null) {
            type = 0;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (type == 1) {
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
                            "            <a href=\""+kepLink+"\"class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Profil</button>\n" +
                            "            </form>\n" +
                            "            <div class=\"szolgaltatasok\">\n" +
                            "            <a href=\""+basket+"\" class=\"funkciok\"><img src=\"RES/basket1.png\" alt=\"kosár kép\"></a>\n" +
                            "            </div>\n" +
                            "        </nav>\n"
                                    + "<nav class=\"header_atmenet\">\n" +
                            "        </nav>\n" +
                            "    </header>\n" +
                            "    <main class=\"termekleiras\">\n" +
                            "        <h1>"+t.getTermekNev()+"</h1>\n" +
                            "        <img src=\""+t.getTermekKep()+"\" alt=\"\">\n" +
                            "        <p1 class =\"adatok\">Értékelés: "+atl+"</p1>\n" +
                            "        <p1 class =\"leiras\">"+t.getTermekDesc()+"</p1>\n" +
                            "        <p2 class=\"ar\">"+t.getTermekAr()+" Ft + ÁFA</p2>\n");
                if (t.getTermekKeszlet() == 1) {
                    out.print("        <p3 class=\"raktaron\">"+van+"</p3>\n" +
                            "        <form action=\"kosarba\" style='text-align: center; margin: 20px auto'>\n" +
                            "            <input type=\"number\" name=\"amount\" min='1' value='1' required>\n" +
                            "            <button type=\"submit\" name=\"getTermek\" value=\"" + termekName + "\">Kosárhoz adás</button>\n" +
                            "        </form><h1 style='text-transform: uppercase'>Értékelés</h1>");
                } else {
                    out.print("        <p class=\"raktaron\">"+van+"</p>\n" +
                            "<h1 style='text-transform: uppercase'>Értékelés</h1>");
                }
                out.print("        <form action='termekErtekeles' method='post' "
                                    + "style='margin: 20px auto; text-align: center'>"
                                    + "<input type='number' name='ertekelt' min='1' max='5' value='5' style='margin: 20px auto'><br>"
                                    + "<textarea name='ertekelesComment' cols='70' rows='20' style='margin: 20px auto'></textarea><br>"
                                    + "<button type='submit' name='sendTermek' value='"+t.getTermekID()+"' style='margin: 20px auto; padding: 15px 30px;'>Értékelés</button><br>"
                                    + "</form>\n<h1 style='text-transform: uppercase'>Étékelések</h1>");
                for (Ertekeles ertek : ertekek){
                    out.print("<p style='text-align: center; border: 1px solid #999; padding: 30px 50px'>Értékelés:<br>"+ertek.getErtek()+"<br>Comment:<br>"+ertek.getComment()+"</p>");
                }
                out.print(  "    </main>\n" +
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
                            "</body>");
            } else {
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
                            "            <a href=\""+kepLink+"\"class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\" class=\"fill\">Bejelentkezés</button>\n" +
                            "            </form>\n" +
                            "        </nav>\n" +
                            "    </header>\n" +
                            "    <main class=\"termekleiras\">\n" +
                            "        <h1>"+t.getTermekNev()+"</h1>\n" +
                            "        <img src=\""+t.getTermekKep()+"\" alt=\"\">\n" +
                            "        <p1 class =\"adatok\">Értékelés: "+atl+"</p1>\n" +
                            "        <p1 class =\"leiras\">"+t.getTermekDesc()+"</p1>\n" +
                            "        <p2 class=\"ar\">"+t.getTermekAr()+" Ft + ÁFA</p2>\n" +
                            "        <p3 class=\"raktaron\">"+van+"</p3>\n" +
                            "        <p3>A vásárlás lehetőség csak bejelentkezés után elérhető</p3><h1 style='text-transform: uppercase'>Étékelések</h1>");
                for (Ertekeles ertek : ertekek){
                    out.print("<p style='text-align: center; border: 1px solid #999; padding: 30px 50px'>Értékelés:<br>"+ertek.getErtek()+"asd<br>Comment:<br>asd"+ertek.getComment()+"asd</p>");
                }
                out.print(  "    </main>\n" +
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
                            "</body>");
            }
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
