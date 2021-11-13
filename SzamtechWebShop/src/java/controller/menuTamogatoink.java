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

public class menuTamogatoink extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        
        ArrayList<Partner> partnerek = wbservice.getPartners();
        ArrayList<Gyarto> gyartok = wbservice.getGyartok();
        ArrayList<Szerviz> szervizek = wbservice.getszervizek();
        
        HttpSession session = request.getSession();
        Integer type = (Integer)session.getAttribute("Type");
        if (type == null) {
            type = 0;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (type == 1) {
                out.print(  "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <title>WebShop</title>\n" +
                        "    <link rel='stylesheet' href='RES/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "        <nav>\n" +
                        "            <a href='index.html'class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\">Kezdőlap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\">Termékek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\">Támogatóink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\">Profil</button>\n" +
                        "            </form>\n" +
                        "            <div class='szolgaltatasok'>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='RES/login.png' alt='login kép'>\n" +
                        "                </a>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='RES/basket.png' alt='kosár kép'>\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class=\"tamogatoinkMain\">\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "                <th>Partnerek nevei</th>\n" +
                        "                <th>Elérhetőségeik</th>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Partner p : partnerek){
                if (p.getPartnerNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                <tr>\n" +
                            "                    <td style='text-align: center'>"+p.getPartnerNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+p.getPartnerElerhetoseg()+"</td>\n" +
                            "                </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
                        "        <hr>\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "                <th>Gyártók nevei</th>\n" +
                        "                <th>Elérhetőségeik</th>\n" +
                        "                <th>Garanciát vállalnak-e</th>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Gyarto g : gyartok){
                String val = "";
                Short bool = g.getGyartoiGarancia();
                if (bool == 1) {
                    val = "Vállal";
                } else {
                    val = "Nem vállal";
                }
                if (g.getGyartoNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                <tr>\n" +
                            "                    <td style='text-align: center'>"+g.getGyartoNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+g.getGyartoElerhetoseg()+"</td>\n" +
                            "                    <td style='text-align: center'>"+val+"</td>\n" +
                            "                </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
                        "        <hr>\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "               <tr>\n" +
                        "                    <th>Szervíz nevek</th>\n" +
                        "                    <th>Elérhetőségeik</th>\n" +
                        "               </tr>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Szerviz s : szervizek){
                if (s.getSzervizNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "               <tr>\n" +
                            "                    <td style='text-align: center'>"+s.getSzervizNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+s.getSzervizElerhetoseg()+"</td>\n" +
                            "               </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
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
                        "    </footer>" +
                        "</body>\n" +
                        "</html>");
            } else {
                out.print(  "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <title>WebShop</title>\n" +
                        "    <link rel='stylesheet' href='RES/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "        <nav>\n" +
                        "            <a href='index.html'class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\">Kezdőlap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\">Termékek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\">Támogatóink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\">Bejelentkezés</button>\n" +
                        "            </form>\n" +
                        "            <div class='szolgaltatasok'>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='RES/login.png' alt='login kép'>\n" +
                        "                </a>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='RES/basket.png' alt='kosár kép'>\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class=\"tamogatoinkMain\">\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "                <th>Partnerek nevei</th>\n" +
                        "                <th>Elérhetőségeik</th>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Partner p : partnerek){
                if (p.getPartnerNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                <tr>\n" +
                            "                    <td style='text-align: center'>"+p.getPartnerNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+p.getPartnerElerhetoseg()+"</td>\n" +
                            "                </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
                        "        <hr>\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "                <th>Gyártók nevei</th>\n" +
                        "                <th>Elérhetőségeik</th>\n" +
                        "                <th>Garanciát vállalnak-e</th>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Gyarto g : gyartok){
                String val = "";
                Short bool = g.getGyartoiGarancia();
                if (bool == 1) {
                    val = "Vállal";
                } else {
                    val = "Nem vállal";
                }
                if (g.getGyartoNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "                <tr>\n" +
                            "                    <td style='text-align: center'>"+g.getGyartoNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+g.getGyartoElerhetoseg()+"</td>\n" +
                            "                    <td style='text-align: center'>"+val+"</td>\n" +
                            "                </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
                        "        <hr>\n" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "               <tr>\n" +
                        "                    <th>Szervíz nevek</th>\n" +
                        "                    <th>Elérhetőségeik</th>\n" +
                        "               </tr>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Szerviz s : szervizek){
                if (s.getSzervizNev().contains("anonym") == Boolean.FALSE) {
                    out.print(  "               <tr>\n" +
                            "                    <td style='text-align: center'>"+s.getSzervizNev()+"</td>\n" +
                            "                    <td style='text-align: center'>"+s.getSzervizElerhetoseg()+"</td>\n" +
                            "               </tr>\n");
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
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
                        "    </footer>" +
                        "</body>\n" +
                        "</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param RESponse servlet RESponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse RESponse)
            throws ServletException, IOException {
        processRequest(request, RESponse);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param RESponse servlet RESponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse RESponse)
            throws ServletException, IOException {
        processRequest(request, RESponse);
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
