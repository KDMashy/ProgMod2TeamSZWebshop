package controller;

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

public class szures extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String searchTermek = request.getParameter("szurText");
        Short bool = Short.parseShort(request.getParameter("order"));
        String selected[] = request.getParameterValues("category");
        Integer happened = 0;
        //szukseges linkek
        String kepLink = "/SzamtechWebShop/menuMain";
        String basket = "/SzamtechWebShop/kosar";
        //szukseges listak
        ArrayList<Termek> termekek = wbservice.getTermekek();
        ArrayList<Termek> searched = new ArrayList<>();
        ArrayList<Termek> categorysed = new ArrayList<>();
        ArrayList<Kategoria> cat = wbservice.getCategoryes();
        //szovegesen szurt termekek keresese
        if (searchTermek.equals("") == Boolean.FALSE) {
            for (Termek t : termekek) {
                if (t.getTermekNev().toLowerCase().contains(searchTermek.toLowerCase())) {
                    searched.add(t);
                }
            }
            happened = 1;
        }
        
        if (happened == 1) {
            termekek = searched;
        }
        //ar szerinti rendezes
        Termek x = new Termek();
        if (bool == 0) {
            for (Integer j = 0; j < termekek.size() - 1; j++) {
                for (Integer i = j + 1; i < termekek.size(); i++) {
                    if (termekek.get(j).getTermekAr()< termekek.get(i).getTermekAr()) {
                        x = termekek.get(j);
                        termekek.set(j, termekek.get(i));
                        termekek.set(i, x);
                    }
                }
            }
        } else if (bool == 1){
            for (Integer j = 0; j < termekek.size() - 1; j++) {
                for (Integer i = j + 1; i < termekek.size(); i++) {
                    if (termekek.get(j).getTermekAr()> termekek.get(i).getTermekAr()) {
                        x = termekek.get(j);
                        termekek.set(j, termekek.get(i));
                        termekek.set(i, x);
                    }
                }
            }
        }
        //kategoria szerinti kereses
        if (Integer.parseInt(selected[0]) != 6) {
            for (Integer i = 0; i < termekek.size(); i++) {
                for (Integer j = 0; j < selected.length; j++) {
                    if (termekek.get(i).getTermekKatID() == Short.parseShort(selected[j])) {
                        categorysed.add(termekek.get(i));
                        happened = 2;
                    }
                }
            }

            if (happened == 2) {
                termekek = categorysed;
            }
        }
        
        Integer type = (Integer)session.getAttribute("Type");
        if (type == null) {
            type = 0;
        }
        
        if (type == 1) {
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
                            "            <a href='"+kepLink+"'class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuProfil'\" class=\"fill\">Profil</button>\n" +
                            "            </form>\n" +
                            "            <div class='szolgaltatasok'>\n" +
                            "            <a href='"+basket+"' class='funkciok'><img src='RES/basket.png' alt='kosár kép'></a>\n" +
                            "            </div>\n" +
                            "        </nav>\n" +
                            "    </header>\n" +
                            "    <div class='mainContainer'>\n" +
                            "        <aside class='leirasAside'>\n" +
                            "            <form action='szures' method='post'>\n" +
                            "                <br><br>\n" +
                            "                <div class=\"temek_kereses\">\n" +
                            "                    <h1>Termék keresés:</h1>\n"
                                    + "          <input type='text' name='szurText'><br>\n"
                                    + "      </div>\n" +
                            "                 <div class=\"termek_szures\">\n" +
                        "                    <h1>Termék Szűrés:</h1>\n" +
                        "                    <div class=\"ar_szerint_no_csokken\">\n" +
                        "                        <span>Ár szerint növekvő sorrend</span>\n" +
                        "                        <input type=\"radio\" name=\"order\" value=\"1\" id=\"Tradio\" checked><br>\n" +
                        "                        <span>Ár szerint csökkenő sorrend</span>\n" +
                        "                        <input type=\"radio\" name=\"order\" value=\"0\" id=\"Tradio\"><br>\n" +
                        "                    </div>\n" +
                        "                    <h4>Termék típusok:</h4>\n" +
                            "                <ul>\n");
                for (Kategoria k : cat){
                    out.print(  "                    <li>\n" +
                                "                        <input type='radio' id = '"+k.getKategoriaID()+"' name='category' value='"+k.getKategoriaID()+"'>\n" +
                                "                        <label for='"+k.getKategoriaID()+"'>"+k.getKategoriaNev()+"</label>\n" +
                                "                    </li>\n");
                }
                out.print(  "                        <li>\n" +
                                "                        <input type='radio' id = '6' name='category' value='6' checked>\n" +
                                "                        <label for='6'>Minden termék</label>\n" +
                                "                    </li>\n");
                out.print(  "                </ul>\n" +
                            "                <button type='submit'>Szűrés</button>\n" +
                            "            </form>\n" +
                            "        </aside>\n" +
                            "        <main class='termekek'>\n" +
                            "            <div class = 'mainFlex'>\n");
                for (Termek t :  termekek){
                    if (t.getTermekNev().contains("anonym") == Boolean.FALSE) {
                        out.print(  "                <div class='termek'>\n" +
                                    "                    <img src='"+t.getTermekKep()+"' alt=''>\n" +
                                    "                    <div class='termekContainer'>\n" +
                                    "                        <div class=\"termeknev\">\n" +
                                    "                            <h3 class=\"termekAdat\">"+t.getTermekNev()+"</h3>\n" +
                                    "                        </div>\n" +
                                    "                         <div class=\"nev_ar\">\n" +
                                    "                            <div class=\"h5\">\n" +
                                    "                                <h5>"+t.getTermekAr()+" FT</h5>\n" +
                                    "                            </div>"
                                                            + "  <div class=\"form\">\n" +
                                        "                        <form class='termekAdat' action='targyOldal' method='post'>\n" +
                                        "                           <button type='submit' name='getTermek' value='"+t.getTermekID()+"' class=\"liras_termek_button\">Megtekintes</button>\n" +
                                        "                        </form>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>\n");
                    }
                }
                out.print(  "            </div>\n" +
                            "        </main>\n" +
                            "    </div>\n" +
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
                            "</body>");
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
                            "            <a href='"+kepLink+"'class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
                            "            <form method='post'>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuMain'\" class=\"fill\">Kezdőlap</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTermekek'\" class=\"fill\">Termékek</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuTamogatoink'\" class=\"fill\">Támogatóink</button>\n" +
                            "                <button type=\"submit\" name = \"menup\" onclick=\"form.action='menuLogin'\" class=\"fill\">Bejelentkezés</button>\n" +
                            "            </form>\n" +
                            "        </nav>\n" +
                            "    </header>\n" +
                            "    <div class='mainContainer'>\n" +
                            "        <aside class='leirasAside'>\n" +
                            "            <form action='szures' method='post'>\n" +
                            "                <br><br>\n" +
                            "                <div class=\"temek_kereses\">\n" +
                            "                    <h1>Termék keresés:</h1>\n"
                                    + "          <input type='text' name='szurText'><br>\n"
                                    + "      </div>\n" +
                            "                 <div class=\"termek_szures\">\n" +
                        "                    <h1>Termék Szűrés:</h1>\n" +
                        "                    <div class=\"ar_szerint_no_csokken\">\n" +
                        "                        <span>Ár szerint növekvő sorrend</span>\n" +
                        "                        <input type=\"radio\" name=\"order\" value=\"1\" id=\"Tradio\" checked><br>\n" +
                        "                        <span>Ár szerint csökkenő sorrend</span>\n" +
                        "                        <input type=\"radio\" name=\"order\" value=\"0\" id=\"Tradio\"><br>\n" +
                        "                    </div>\n" +
                        "                    <h4>Termék típusok:</h4>\n" +
                            "                <ul>\n");
                for (Kategoria k : cat){
                    out.print(  "                    <li>\n" +
                                "                        <input type='radio' id = '"+k.getKategoriaID()+"' name='category' value='"+k.getKategoriaID()+"'>\n" +
                                "                        <label for='"+k.getKategoriaID()+"'>"+k.getKategoriaNev()+"</label>\n" +
                                "                    </li>\n");
                }
                out.print(  "                        <li>\n" +
                                "                        <input type='radio' id = '6' name='category' value='6' checked>\n" +
                                "                        <label for='6'>Minden termék</label>\n" +
                                "                    </li>\n");
                out.print(  "                </ul>\n" +
                            "                <button type='submit'>Szűrés</button>\n" +
                            "            </form>\n" +
                            "        </aside>\n" +
                            "        <main class='termekek'>\n" +
                            "            <div class = 'mainFlex'>\n");
                for (Termek t :  termekek){
                    if (t.getTermekNev().contains("anonym") == Boolean.FALSE) {
                        out.print(  "                <div class='termek'>\n" +
                                    "                    <img src='"+t.getTermekKep()+"' alt=''>\n" +
                                    "                    <div class='termekContainer'>\n" +
                                    "                        <div class=\"termeknev\">\n" +
                                    "                            <h3 class=\"termekAdat\">"+t.getTermekNev()+"</h3>\n" +
                                    "                        </div>\n" +
                                    "                         <div class=\"nev_ar\">\n" +
                                    "                            <div class=\"h5\">\n" +
                                    "                                <h5>"+t.getTermekAr()+" FT</h5>\n" +
                                    "                            </div>"
                                                            + "  <div class=\"form\">\n" +
                                        "                        <form class='termekAdat' action='targyOldal' method='post'>\n" +
                                        "                           <button type='submit' name='getTermek' value='"+t.getTermekID()+"' class=\"liras_termek_button\">Megtekintes</button>\n" +
                                        "                        </form>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>\n");
                    }
                }
                out.print(  "            </div>\n" +
                            "        </main>\n" +
                            "    </div>\n" +
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
