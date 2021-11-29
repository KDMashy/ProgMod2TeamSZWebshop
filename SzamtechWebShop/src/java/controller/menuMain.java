package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class menuMain extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String kepLink = "/SzamtechWebShop/menuMain";
        String basket = "/SzamtechWebShop/kosar";
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
                        "            <a href=\""+kepLink+"\" class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
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
                                + "<div class=\"header_atmenet\">\n" +
                                    "        </div>\n" +
                            "    </header>\n" +
                            "    <main class=\"index_main\">\n" +
                            "        <div class=\"index_fix_hatter\">\n" +
                            "            <div class=\"index_promo_teglalapok\">\n" +
                            "                <div class=\"index_promo_teglalap_1\">\n" +
                            "                    <p>Megbízhatóak vagyunk</p>\n" +
                            "                </div>\n" +
                            "                <div class=\"index_promo_teglalap_2\">\n" +
                            "                    <p>Esküszöm, még soha nem loptam</p>\n" +
                            "                </div>\n" +
                            "                <div class=\"index_promo_teglalap_3\">\n" +
                            "                    <p>Cégünk, mindig az ön rendelkezésére áll (asszonyom)</p>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div id=\"kekhatter\">\n" +
                            "            <div id=\"slider\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide1\" checked>\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide2\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide3\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide4\">\n" +
                            "                <div id=\"slides\">\n" +
                            "                   <div id=\"overflow\">\n" +
                            "                      <div class=\"inner\">\n" +
                            "                         <div class=\"slide slide_1\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_2\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_3\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_4\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                      </div>\n" +
                            "                   </div>\n" +
                            "                </div>\n" +
                            "                <div id=\"controls\">\n" +
                            "                   <label for=\"slide1\"></label>\n" +
                            "                   <label for=\"slide2\"></label>\n" +
                            "                   <label for=\"slide3\"></label>\n" +
                            "                   <label for=\"slide4\"></label>\n" +
                            "                </div>\n" +
                            "                <div id=\"bullets\">\n" +
                            "                   <label for=\"slide1\"></label>\n" +
                            "                   <label for=\"slide2\"></label>\n" +
                            "                   <label for=\"slide3\"></label>\n" +
                            "                   <label for=\"slide4\"></label>\n" +
                            "                </div>\n" +
                            "             </div>\n" +
                            "        </div>\n" +
                            "    </main>\n" +
                            "    <footer>\n" +
                            "        <section class = \"bemutatkozas\">\n"
                                + "<div class=\"footer_atmenet\">\n" +
"            </div>\n" +
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
                            "            <a href=\""+kepLink+"\" class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\" class=\"fill\">Bejelentkezés</button>\n" +
                            "            </form>\n" +
                            "        </nav>\n"
                                + "<div class=\"header_atmenet\">\n" +
                                    "        </div>\n" +
                            "    </header>\n" +
                            "    <main class=\"index_main\">\n" +
                            "        <div class=\"index_fix_hatter\">\n" +
                            "            <div class=\"index_promo_teglalapok\">\n" +
                            "                <div class=\"index_promo_teglalap_1\">\n" +
                            "                    <p>Megbízhatóak vagyunk</p>\n" +
                            "                </div>\n" +
                            "                <div class=\"index_promo_teglalap_2\">\n" +
                            "                    <p>Esküszöm, még soha nem loptam</p>\n" +
                            "                </div>\n" +
                            "                <div class=\"index_promo_teglalap_3\">\n" +
                            "                    <p>Cégünk, mindig az ön rendelkezésére áll (asszonyom)</p>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div id=\"kekhatter\">\n" +
                            "            <div id=\"slider\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide1\" checked>\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide2\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide3\">\n" +
                            "                <input type=\"radio\" name=\"slider\" id=\"slide4\">\n" +
                            "                <div id=\"slides\">\n" +
                            "                   <div id=\"overflow\">\n" +
                            "                      <div class=\"inner\">\n" +
                            "                         <div class=\"slide slide_1\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_2\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_3\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                         <div class=\"slide slide_4\">\n" +
                            "                            <div class=\"slide-content\">\n" +
                            "                               <h2></h2>\n" +
                            "                               <p></p>\n" +
                            "                            </div>\n" +
                            "                         </div>\n" +
                            "                      </div>\n" +
                            "                   </div>\n" +
                            "                </div>\n" +
                            "                <div id=\"controls\">\n" +
                            "                   <label for=\"slide1\"></label>\n" +
                            "                   <label for=\"slide2\"></label>\n" +
                            "                   <label for=\"slide3\"></label>\n" +
                            "                   <label for=\"slide4\"></label>\n" +
                            "                </div>\n" +
                            "                <div id=\"bullets\">\n" +
                            "                   <label for=\"slide1\"></label>\n" +
                            "                   <label for=\"slide2\"></label>\n" +
                            "                   <label for=\"slide3\"></label>\n" +
                            "                   <label for=\"slide4\"></label>\n" +
                            "                </div>\n" +
                            "             </div>\n" +
                            "        </div>\n" +
                            "    </main>\n" +
                            "    <footer>\n" +
                            "        <section class = \"bemutatkozas\">\n"
                                + "<div class=\"footer_atmenet\">\n" +
"            </div>\n" +
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
