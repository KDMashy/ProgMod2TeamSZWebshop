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

public class forgotPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String kepLink = "/SzamtechWebShop/menuMain";
        String basket = "/SzamtechWebShop/kosar";
        
        String getEmail = request.getParameter("forgotEmail");
        
        WebShopService wbservice = new WebShopService();
        ArrayList<Vevo> vevok = wbservice.getVevok();
        
        Vevo v = new Vevo();
        Boolean IGEN = Boolean.FALSE;
        for (Integer i = 0; i < vevok.size(); i++) {
            if (vevok.get(i).getVevoEmail().equals(getEmail) == Boolean.TRUE) {
                v = vevok.get(i);
                IGEN = Boolean.TRUE;
                break;
            }
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("KERESENDO", v);
        
        if (IGEN) {
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
                            "</head>\n" +
                            "<body>\n" +
                            "    <header>\n" +
                            "        <nav>\n" +
                            "            <a href=\""+kepLink+"\" class=\"logo\"><img src=\"RES/logo.png\" alt=\"logo helye\"></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezd??lap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Term??kek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">T??mogat??ink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Bejelentkez??s</button>\n" +
                            "            </form>\n" +
                            "        </nav>\n" +
                            "    </header>\n" +
                            "    <main>\n" +
                            "        <div class='bejelentkezes'>\n" +
                            "            <form action='NEWPassword' method='post'>\n"
                                    + "     <label style='color: #08ffd1'><b>Eml??keztet?? k??rd??s: "+v.getBiztonsagiKerdes()+"</b></label><br><br>\n"
                                    + "     <label style='color: #08ffd1'><b>Adja meg az eml??keztet?? k??rd??sre v??lasz??t:</b></label><br><br>\n"
                                    + "     <input type='text' name='forgotValasz'><br><br>\n"
                                    + "     <label style='color: #08ffd1'><b>Adja meg ??j jelszav??t:</b></label><br><br>\n"
                                    + "     <input type='password' name='forgotPasw'><br><br>\n"
                                    + "     <input type='submit' value='??j jelsz?? k??r??se' class='bekuld'>"
                                    + "</form>\n" +
                            "        </div>\n" +
                            "    </main>\n" +
                            "    <footer>\n" +
                            "        <section class = \"bemutatkozas\" >\n" +
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
        } else {
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
                        "            <a href='"+kepLink+"' class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                        "            <form method='post'>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezd??lap</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Term??kek</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">T??mogat??ink</button>\n" +
                        "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\" class=\"fill\">Bejelentkez??s</button>\n" +
                        "            </form>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class='logreg'>\n" +
                        "        <div class='regisztracio'>  \n" +
                        "            <h2>Regisztr??ci??</h2><br>   \n" +
                        "            <form action='reg' method='post'>    \n" +
                        "                <label><b>Felhaszn??l??n??v</b><br><br></label>    \n" +
                        "                <input type='text' name='name' id='registerName'>    \n" +
                        "                <br><br>    \n" +
                        "                <label><b>Jelsz??</b><br><br></label>    \n" +
                        "                <input type='password' name='password' id='registerPasw'>    \n" +
                        "                <br><br>\n" +
                        "                <label><b>Email</b><br><br></label>    \n" +
                        "                <input type='text' name='email' id='registerEmail'>\n" +
                        "                <br><br>    \n" +
                        "                <input type='submit' id='log' value='Regisztr??ci??' class='bekuld'>  \n" +
                        "            </form>     \n"
                                + "<form action='elfelejtettJelszo' method='post' style='margin-top: 25px;'><input type='submit' value='Elfelejtett jelsz??' class='bekuld'></form>\n" +
                        "        </div>\n" +
                        "        <div class='bejelentkezes'>  \n" +
                        "            <h2>Bejelentkez??s</h2><br>   \n" +
                        "            <h2>Hib??s felhaszn??l??n??v, vagy jelsz??</h2>\n" +
                        "            <form action='logAcc' method='post'>    \n" +
                        "                <label><b>Felhaszn??l??n??v    \n" +
                        "                </b> \n" +
                        "                <br><br>      \n" +
                        "                </label>    \n" +
                        "                <input type='text' name='name' id='registerName'>    \n" +
                        "                <br><br>    \n" +
                        "                <label><b>Jelsz??     \n" +
                        "                </b>    \n" +
                        "                <br><br>   \n" +
                        "                </label>    \n" +
                        "                <input type='password' name='password' id='registerPasw'>    \n" +
                        "                <br><br>    \n" +
                        "                <input type='submit' id='log' value='bejelentkez??s' class='bekuld'>  \n" +
                        "            </form>     \n" 
                                + "<form action='elfelejtettJelszo' method='post' style='margin-top: 25px;'><input type='submit' value='Elfelejtett jelsz??' class='bekuld'></form>\n" +
                        "        </div>    \n" +
                        "        </div>    \n" +
                        "    </main>\n" +
                        "    <footer>\n" +
                            "    <section class = \"bemutatkozas\" style='margin-top:100px;'>\n" +
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
                            "    </section>\n" +
                            "</footer>" +
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
