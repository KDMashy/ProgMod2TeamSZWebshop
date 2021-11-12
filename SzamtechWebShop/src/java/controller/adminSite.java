package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class adminSite extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                        "                <form action='logOut' method='post'>\n" +
                        "                    <button type='submit'>Kijelentkezés</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "        </header>\n" +
                        "        <main>\n" +
                        "            <div class='function'>\n" +
                        "                <form action='createTermek' method='post'>\n" +
                        "                    <button type='submit' onclick='form.action='listTermekekAdmin''>Termékek listázása</button><br>\n" +
                        "                    <span>Termék neve</span><br>\n" +
                        "                    <input type='text' name='termekName'><br>\n" +
                        "                    <span>Leírás</span><br>\n" +
                        "                    <textarea name='termekDesc' cols='70' rows='20'></textarea><br>\n" +
                        "                    <span>Ár</span><br>\n" +
                        "                    <input type='number' name='termekAr'><br>\n" +
                        "                    <span>Feltöltött kép neve (res mappából)</span><br>\n" +
                        "                    <input type='text' name='termekKepURL'><br>\n" +
                        "                    <span>Készlenen van-e</span><br>\n" +
                        "                    <div class='Tradio'>\n" +
                        "                        <div class='TradioIgen'>\n" +
                        "                            <span>Igen</span>\n" +
                        "                            <input type='radio' name='stock' value='0' id='Tradio' checked>\n" +
                        "                        </div>\n" +
                        "                        <div class='TradioNem'>\n" +
                        "                            <span>Nem</span>\n" +
                        "                            <input type='radio' name='stock' value='1' id='Tradio'>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <span>Kategória Választás</span><br>\n" +
                        "                    <select name='KategoriaVal' id='KatVal'>\n" +
                        "                        <option value='1'>pelda</option>\n" +
                        "                    </select><br>\n" +
                        "                    <button type='submit'>Termék létrehozása</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "            <div class='function'>\n" +
                        "                <form action='createPartner' method='post'>\n" +
                        "                    <button type='submit' onclick='form.action='listPartnerekAdmin''>Partnerek listázása</button><br>\n" +
                        "                    <span>Partner neve</span><br>\n" +
                        "                    <input type='text' name='termekName'><br>\n" +
                        "                    <span>Elérhetőség</span><br>\n" +
                        "                    <textarea name='termekDesc' cols='70' rows='10'></textarea><br>\n" +
                        "                    <button type='submit'>Partner létrehozása</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "            <div class='function'>\n" +
                        "                <form action='createGyarto' method='post'>\n" +
                        "                    <button type='submit' onclick='form.action='listGyartokAdmin''>Gyártók listázása</button><br>\n" +
                        "                    <span>Gyártó neve</span><br>\n" +
                        "                    <input type='text' name='termekName'><br>\n" +
                        "                    <span>Elérhetőség</span><br>\n" +
                        "                    <textarea name='termekDesc' cols='70' rows='10'></textarea><br>\n" +
                        "                    <span>Gyrátói garancia van-e</span><br>\n" +
                        "                    <div class='Tradio'>\n" +
                        "                        <div class='TradioIgen'>\n" +
                        "                            <span>Igen</span>\n" +
                        "                            <input type='radio' name='stock' value='0' id='Tradio' checked>\n" +
                        "                        </div>\n" +
                        "                        <div class='TradioNem'>\n" +
                        "                            <span>Nem</span>\n" +
                        "                            <input type='radio' name='stock' value='1' id='Tradio'>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <button type='submit'>Gyártó létrehozása</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "            <div class='function'>\n" +
                        "                <form action='createSzerviz' method='post'>\n" +
                        "                    <button type='submit' onclick='form.action='listSzervizAdmin''>Szervízek listázása</button><br>\n" +
                        "                    <span>Szervíz neve</span><br>\n" +
                        "                    <input type='text' name='termekName'><br>\n" +
                        "                    <span>Elérhetőség</span><br>\n" +
                        "                    <textarea name='termekDesc' cols='70' rows='10'></textarea><br>\n" +
                        "                    <button type='submit'>Szervíz létrehozása</button>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "        </main>\n" +
                        "    </div>\n" +
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
