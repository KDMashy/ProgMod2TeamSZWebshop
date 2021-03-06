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

public class listVasarlasok extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        
        HttpSession session = request.getSession();
        String name = session.getAttribute("name").toString();
        String basket = "/SzamtechWebShop/kosar";
        String kepLink = "/SzamtechWebShop/menuMain";
        
        ArrayList<Vasarlas> vasarlasok = wbservice.getVasarlasokByName(name);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                        "            <a href='"+kepLink+"'class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezd??lap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Term??kek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">T??mogat??ink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Profil</button>\n" +
                        "            </form>\n" +
                        "            <div class='szolgaltatasok'>\n" +
                        "                <a href='"+basket+"' class='funkciok'>\n" +
                        "                    <img src='RES/basket1.png' alt='kos??r k??p'>\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class=\"tamogatoinkMain\">\n"
                    + "<div class='tamogatoinkPH'></div>" +
                        "        <table class=\"theme\">\n" +
                        "            <thead>\n" +
                        "                <th>Sz??mla</th>\n" +
                        "                <th>Fizet??si m??d</th>\n" +
                        "                <th>??sszeg</th>\n" +
                        "                <th>Ir??ny??t??sz??m</th>\n" +
                        "                <th>V??ros</th>\n" +
                        "                <th>Utca - H??zsz??m</th>\n" +
                        "                <th>Id??pont</th>\n" +
                        "                <th>Egy??b</th>\n" +
                        "                <th>Lemond??s</th>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n");
            for (Vasarlas v : vasarlasok){
                if (v.getFelhasznalo().contains("anonym") == Boolean.FALSE) {
                    out.print(  "            <tr>\n" +
                            "                    <td style='text-align: center'>"+v.getSzamla()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getFizMod()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getOsszeg()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getIRSzam()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getVaros()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getUtcaHSzam()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getIdopont()+"</td>\n" +
                            "                    <td style='text-align: center'>"+v.getEgyeb()+"</td>\n");
                    if (v.getEgyeb().equals("DELETED")) {
                        out.print("              <td style='text-align: center'>"+v.getEgyeb()+"</td>\n \n" +
                                  "          </tr>\n");
                    } else {
                        out.print("              <td style='text-align: center'>\n " +
                                  "              <form action='lemond' method='post'><button type='submit' name='lemondas' value='"+v.getSorSzam()+"'>V??s??rl??s lemond??sa</button></form>\n" +
                                  "              </td>\n \n" +
                                  "          </tr>\n");
                    }     
                }
            }
            out.print(  "            </tbody>\n" +
                        "        </table>\n" +
                        "        <hr>\n"
                    + "<div class='tamogatoinkPH'></div>" +
                        "    </main>\n" +
                        "    <footer>\n" +
                        "        <section class = \"bemutatkozas\">\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>El??rhet??s??gek:</h3>\n" +
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
                        "                    <p class=\"footer_elerhetoseg_szoveg\">7620 P??cs PTE - TTK</p>\n" +
                        "                </div>  \n" +
                        "            </div>\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>Inform??ci??k r??lunk: </h3>\n" +
                        "                <br><br>\n" +
                        "                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Doloribus, tempore!</p>\n" +
                        "                <br>\n" +
                        "                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolorem blanditiis ipsum, nulla dicta facere eius quos quae quasi nihil tenetur?</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "            <div class=\"footer_info_box\">\n" +
                        "                <h3>T??mogat??int: </h3>\n" +
                        "                <br><br>\n" +
                        "                <div class = \"footer_tamogatok\">\n" +
                        "                    <p>lel??p??nk a p??nzel kft</p>\n" +
                        "                    <br>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </section>\n" +
                        "    </footer>" +
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
