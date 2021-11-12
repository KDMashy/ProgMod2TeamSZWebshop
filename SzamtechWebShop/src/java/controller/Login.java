package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;

public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebShopService wbservice = new WebShopService();
        request.setCharacterEncoding("UTF-8");
        String lName = request.getParameter("name");
        String lPassword = request.getParameter("password");
        
        Integer Login = wbservice.LoginAcc(lName, lPassword);
        
        lPassword = wbservice.encrypt(lPassword);
        
        HttpSession session = request.getSession();
        
        
        if (Login == 1) {
            response.setContentType("text/html;charset=UTF-8");
            session.setAttribute("name", lName);
            session.setAttribute("password", lPassword);
            session.setAttribute("Type", Login);
            response.sendRedirect("menuProfil");
        } else if (Login == 2) {
            session.setAttribute("name", lName);
            session.setAttribute("password", lPassword);
            session.setAttribute("Type", Login);
            response.sendRedirect("adminSite");
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
                        "            <a href='index.html' class='logo'><img src='RES/logo.png' alt='logo helye'></a>\n" +
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
                        "            <h2>Hibás felhasználónév, vagy jelszó</h2>\n" +
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
                        "    <footer>\n" +
                            "    <section class = \"bemutatkozas\">\n" +
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
