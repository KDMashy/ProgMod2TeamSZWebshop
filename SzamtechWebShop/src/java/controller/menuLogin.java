package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class menuLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
                        "            <a href='index.html' class='logo'><img src='res/logo.png' alt='logo helye'></a>\n" +
                        "            <form action='menuPoints' method='post'>\n" +
                        "                <button type='submit' name = 'menup' onclick='form.action='''>Kezdőlap</button>\n" +
                        "                <button type='submit' name = 'menup' onclick='form.action='''>Termékek</button>\n" +
                        "                <button type='submit' name = 'menup' onclick='form.action='''>Támogatóink</button>\n" +
                        "                <button type='submit' name = 'menup' onclick='form.action='menuLogin''>Bejelentkezés</button>\n" +
                        "            </form>\n" +
                        "\n" +
                        "            <div class='szolgaltatasok'>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='res/login.png' alt='login kép'>\n" +
                        "                </a>\n" +
                        "                <a href='' class='funkciok'>\n" +
                        "                    <img src='res/basket.png' alt='kosár kép'>\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <main class='logreg'>\n" +
                        "        <div class='regisztracio'>  \n" +
                        "            <h2>Regisztráció</h2><br>   \n" +
                        "            <form action='reg' method='post'>    \n" +
                        "                <label><b>Felhasználónév</b><br><br></label>    \n" +
                        "                <input type='text' name='name' id='registerName'>    \n" +
                        "                <br><br>    \n" +
                        "                <label><b>Jelszó</b><br><br></label>    \n" +
                        "                <input type='password' name='password' id='registerPasw'>    \n" +
                        "                <br><br>\n" +
                        "                <label><b>Email</b><br><br></label>    \n" +
                        "                <input type='text' name='email' id='registerEmail'>\n" +
                        "                <br><br>    \n" +
                        "                <input type='submit' id='log' value='Regisztráció' class='bekuld'>  \n" +
                        "            </form>     \n" +
                        "        </div>\n" +
                        "        <div class='bejelentkezes'>  \n" +
                        "            <h2>Bejelentkezés</h2><br>   \n" +
                        "            <form action='logAcc' method='post'>    \n" +
                        "                <label><b>Felhasználónév    \n" +
                        "                </b> \n" +
                        "                <br><br>      \n" +
                        "                </label>    \n" +
                        "                <input type='text' name='name' id='registerName'>    \n" +
                        "                <br><br>    \n" +
                        "                <label><b>Jelszó     \n" +
                        "                </b>    \n" +
                        "                <br><br>   \n" +
                        "                </label>    \n" +
                        "                <input type='password' name='password' id='registerPasw'>    \n" +
                        "                <br><br>    \n" +
                        "                <input type='submit' id='log' value='bejelentkezés' class='bekuld'>  \n" +
                        "            </form>     \n" +
                        "        </div>    \n" +
                        "    </main>\n" +
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
