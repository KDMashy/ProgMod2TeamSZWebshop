/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import service.*;

/**
 *
 * @author Krisztian
 */
@WebServlet(name = "Kosar", urlPatterns = {"/Kosar"})
public class Kosar extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        WebShopService wbservice = new WebShopService();
        String basket = "/SzamtechWebShop/kosar";
        String kepLink = "/SzamtechWebShop/menuMain";
        HttpSession session = request.getSession();
        ArrayList<KosarElem> Kosar = (ArrayList<KosarElem>)session.getAttribute("kosar"); 
        ArrayList<Termek> termekek = wbservice.getTermekek();
        
        Integer SUM = 0;
        
        Integer added = Integer.parseInt(session.getAttribute("hasItem").toString());
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Webshop</title>\n" +
                        "    <link rel=\"stylesheet\" href=\"RES/style.css\">\n" +
                        "<style>.kosarMain{\n" +
                        "    width: 70%;\n" +
                        "    margin: 0 auto; padding: 100px\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer{\n" +
                        "    width: 90%;\n" +
                        "    margin: 20px auto;\n" +
                        "    background-color: rgba(153, 153, 153, 0.08);\n" +
                        "    padding: 40px;\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable{\n" +
                        "    margin: 0 auto;\n" +
                        "    border-collapse: collapse;\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable thead{\n" +
                        "    background-color: rgba(153, 153, 153, 0.29);\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable thead th{\n" +
                        "    padding: 15px 20px;\n" +
                        "    border-bottom: 3px solid #999;\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable td{\n" +
                        "    padding: 15px 20px;\n" +
                        "    border: 2px solid #999;\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable tr{\n" +
                        "    transition: background 0.3s, color 0.3s;\n" +
                        "}\n" +
                        ".kosarMain .kosarContainer .kosarTable tr:hover{\n" +
                        "    background-color: #999;\n" +
                        "    color: #fff;\n" +
                        "}\n" +
                        ".kosarMain .vasarlasContainer{\n" +
                        "    text-align: center;\n" +
                        "    margin: 25px auto;\n" +
                        "    padding: 30px;\n" +
                        "    width: 30%;\n" +
                        "}\n" +
                        ".kosarMain .vasarlasContainer button{\n" +
                        "    padding: 15px 30px;\n" +
                        "}\n" +
                        ".kosarMain .elfogadC{\n" +
                        "    display: flex;\n" +
                        "    justify-content: space-between;\n" +
                        "    margin-bottom: 15px;\n" +
                        "}</style>"
                    + "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "        <nav>\n" +
                        "            <a href=\""+kepLink+"\" class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezd??lap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Term??kek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">T??mogat??ink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Profil</button>\n" +
                        "            </form>\n" +
                        "            <div class=\"szolgaltatasok\">\n" +
                        "            <a href=\""+basket+"\" class=\"funkciok\"><img src=\"RES/basket1.png\" alt=\"kos??r k??p\"></a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class=\"kosarMain\">\n"
                    + "<div class='tamogatoinkPH'></div>" +
                        "        <div class=\"kosarContainer\">\n"
                                + "<form action='kosarUrites' method='post' style='text-align: center'>\n" +
                        "                <button type=\"submit\">Kos??r ??r??t??se</button>\n" +
                        "            </form>" +
                        "            <table class=\"kosarTable\">\n" +
                        "                <thead>\n" +
                        "                    <tr>\n" +
                        "                        <th>Term??k neve</th>\n" +
                        "                        <th>Term??k ??ra</th>\n" +
                        "                        <th>Mennyis??g</th>\n" +
                        "                    </tr>\n" +
                        "                </thead>\n" +
                        "                <tbody>\n");
            if (added == 1) {
                for (Integer i = 0; i < Kosar.size(); i++){
                    out.print(  "                    <tr>\n" +
                                "                        <td>"+Kosar.get(i).getName()+"</td>\n");
                    for (Termek term : termekek) {
                        if (term.getTermekNev().equals(Kosar.get(i).getName()) == Boolean.TRUE) {
                            out.print("                        <td>"+term.getTermekAr()+"</td>\n");
                            SUM += (term.getTermekAr()*Kosar.get(i).getAmount());
                        }
                    }
                    out.print(  "                        <td>"+Kosar.get(i).getAmount()+"</td>\n" +
                                "                    </tr>\n");
                }
                out.print(  "                </tbody>\n" +
                            "            </table>\n"
                                    + "  <h1 style='text-align: center'>A v??g??sszeg: "+SUM+"</h1>\n" +
                            "            <div class=\"vasarlasContainer\">\n" +
                            "                <form action=\"tremekekVasarlasa\">\n" +
                            "                    <div class=\"lakhely\" style=\"border: 1px solid #999; padding: 15px\">\n" +
                            "                        <label for=\"varos\">V??ros:</label><br>\n" +
                            "                        <input type=\"text\" name=\"varos\" minlength=\"3\" required><br><br>\n" +
                            "                        <label for=\"hszam\">Utca/h??zsz??m:</label><br>\n" +
                            "                        <input type=\"text\" name=\"hszam\" minlength=\"3\" required><br><br>\n" +
                            "                        <label for=\"irszam\" minlength=\"4\" maxlength='4'>Ir??ny??t??sz??m:</label><br>\n" +
                            "                        <input type=\"text\" name=\"irszam\" min=\"1\" max=\"4\" required><br><br>\n" +
                            "                        <label for=\"area\">Egy??b k??zlend??:</label><br>\n" +
                            "                        <textarea name=\"egyebInfoByFelh\" cols=\"30\" rows=\"20\" style=\"resize: none\"></textarea><br>\n" +
                            "                    </div>\n" +
                            "                    <div class=\"fizetesimod\" style=\"border: 1px solid #999; padding: 15px\">\n" +
                            "                        <div class=\"elfogadC\">\n" +
                            "                            <label for=\"elfogad\">K??rty??s</label>\n" +
                            "                            <input type=\"radio\" name=\"fizmod\" value=\"K??rty??s\"  id=\"elfogad\" checked>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"elfogadC\">\n" +
                            "                            <label for=\"elfogad\">K??zp??nzes</label>\n" +
                            "                            <input type=\"radio\" name=\"fizmod\" value=\"K??zp??nzes\"  id=\"elfogad\">\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                    <div class=\"felhf\" style=\"border: 1px solid #999; padding: 15px\">\n" +
                            "                        <div class=\"elfogadC\">\n" +
                            "                            <label for=\"elfogad\">Elfogadom a v??s??rl??s felt??teleit</label>\n" +
                            "                            <input type=\"radio\" name=\"accept\" value=\"1\"  id=\"elfogad\">\n" +
                            "                        </div>\n" +
                            "                        <div class=\"elfogadC\">\n" +
                            "                            <label for=\"nemfogad\">Nemfogadom el a v??s??rl??s felt??teleit</label>\n" +
                            "                            <input type=\"radio\" name=\"accept\" value=\"0\" id=\"nemfogad\" checked>\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                    <button type=\"submit\">V??s??rl??s</button>\n" +
                            "                </form>\n" +
                            "            </div>\n" +
                            "        </div>\n"
                    + "<div class='tamogatoinkPH'></div>" +
                            "    </main>\n" +
                            "    <footer style='position='relative''>\n" +
                            "        <section class = \"bemutatkozas\" style='position='absolute'; bottom: 0'>\n" +
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
                            "    </footer>\n" +
                            "</body>\n" +
                            "</html>");
            } else {
                out.print(  "<td>M??g nincs adat</td>\n"
                        + "<td>M??g nincs adat</td>\n"
                        + "<td>M??g nincs adat</td>\n"
                        + "               </tbody>\n" +
                            "            </table>\n"
                                    + "  <h1 style='text-align: center'>A v??g??sszeg: "+SUM+"</h1>\n" +
                            "        </div>\n" +
                            "    </main>\n" +
                            "    <footer>\n" +
                            "        <section class = \"bemutatkozas\">\n" +
                            "            <div class=\"footer_atmenet\">\n" +
                            "            </div>\n" +
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
                            "    </footer>\n" +
                            "</body>\n" +
                            "</html>");
            }
            
            //Kosar.forEach((elem) -> out.println(" (id: " + elem.getID() + ", mennyiseg: " + elem.getAmount()+ ")"));
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
