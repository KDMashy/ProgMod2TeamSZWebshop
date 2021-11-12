package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class WebShopService{
    //global variables DONT TOUCHY-TOUCHY
    /**
     * 
     * Foldokkal lett kellokeppen el szeparalva a program, ha megnyitod, ott
     * az adott cimmel kapcsolatos funkciok fognak megjelenni, minden funkcio
     * elott egy commenttel ami jelzi mi a feladata az adott funkcionak
     * 
     * A login felhasznalo es admin reszrol is ki lett szervezve interfaceba
     * a fuggvenyek interfaceList.Java-ban vannak
     * a megirasuk function.java-ban vannak
     * 
     * ahol szam a visszatero ertek, ott a servleten tobb eset kozott kell donteni
     * pl loginnal a 0 a nem letezo fehasznalo, 1 a letezik a felhasznalo es ha
     * jo a jelszo akkor bejelentkezes, ha 2 akkor admin nev lett beirva es ellenorzi
     * hogy az adott admin nev es jelszo helyes-e, ha igen akkor egy masik login feluletre visz
     * (utobbi nem ervenyes mar admin reszrol)
     * 
     * ahol TRUE vagy FALSE a visszatero ertek ott a servlet szamara jelez csak hogy mit tegyen
     * illetve visszajelzest ad hogy az adott funkcio mukodott es hiba nelkul vagy valamit
     * helytelenul adtunk meg es jelez, meg lehet szamkodokat adok neki -Klepe
    */
    
    private String DBServer = "jdbc:mysql://localhost:3306/webshop";
    private String DBUsername = "root";
    private String DBPassword = "";
    
    
    // <editor-fold defaultstate="collapsed" desc="Vevo es Admin login">
    //Belepes, ellenorzes ha admin akkor response es ujra login
    public Integer LoginAcc(String name, String password){
        password = encrypt(password);
        function f = new function();
        ArrayList<Vevo> vevokLista = getVevok();
        ArrayList<Admin> adminLista = getAdmins();
        return f.userLogin(name, password, vevokLista, adminLista);
    }
    //Admin login after update (átalakítás alatt)
    public Boolean adminLogin(String name, String password, String code){
        password = encrypt(password);
        function f = new function();
        ArrayList<Admin> adminLista = getAdmins();
        return f.adminLogin(name, password, code, adminLista);
    }
    // </editor-fold>
    
    //admin code search
    private Boolean adminCodeSearch(String code){
        ArrayList<Admin> adminLista = getAdmins();
        for (Integer i = 0; i < adminLista.size(); i++) {
            if (adminLista.get(i).getAdmincode().equals(code)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    //Regisztracio
    public Boolean RegAcc(String name, String email, String password){
        password = encrypt(password);
        ArrayList<Vevo> vevokLista = getVevok();
        ArrayList<Admin> adminLista = getAdmins();
        Boolean exist = Boolean.FALSE;
        try{
            //ellenorzes, hogy letezik-e a regisztralando felhasznalo
            for (Integer i = 0; i < vevokLista.size(); i++) {
                if (vevokLista.get(i).getVevoNev().equals(name) == Boolean.TRUE 
                        || vevokLista.get(i).getVevoEmail().equals(email) == Boolean.TRUE) {
                    exist = Boolean.TRUE;
                    break;
                } else {
                    exist = Boolean.FALSE;
                }
            }
            for (Integer i = 0; i < adminLista.size(); i++) {
                if (adminLista.get(i).getAdminname().equals(name) == Boolean.TRUE) {
                    exist = Boolean.TRUE;
                    break;
                } else {
                    exist = Boolean.FALSE;
                }
            }
            //DB meghivas, regisztralando felhasznalo adatainak mentese
            if (exist == Boolean.FALSE) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
                String sql = "insert into vevo (VevoNev,VevoPassword,VevoEmail) values('"+name+"','"+password+"','"+email+"')";
                PreparedStatement prestm = con.prepareStatement(sql);
                prestm.execute();
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Vevo es Admin betoltes">
    //Vevok betoltese
    public ArrayList<Vevo> getVevok(){
        ArrayList<Vevo> vevok = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from vevo";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Vevo vv = new Vevo();
                vv.setVevoID(rs.getInt(1));
                vv.setVevoNev(rs.getString(2));
                vv.setVevoPassword(rs.getString(3));
                vv.setVevoEmail(rs.getString(4));
                vv.setVevoSzamCim(rs.getString(5));
                vv.setVevoAdoszam(rs.getString(6));
                vv.setTorzsVasarlo(rs.getShort(7));
                vevok.add(vv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vevok;
    }
    //Admin betoltes
    private ArrayList<Admin> getAdmins(){
        ArrayList<Admin> adminList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from admin";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Admin admin = new Admin();
                admin.setAdminid(rs.getInt(1));
                admin.setAdminname(rs.getString(2));
                admin.setAdminpassword(rs.getString(3));
                admin.setAdmincode(rs.getString(4));
                adminList.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adminList;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Vevo tulajdonsagok update fuggvenyek">
    //Vevo Anonymizalasa
    public Boolean anonymisation(String name){
        Integer vid;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vevoEll(name);
            if (vid >= 0) {
                String anonym = "anonym"+vid;
                Short bool = 0;
                String sql  = "update vevo set VevoNev='"+anonym+"', "
                        + "VevoEmail='"+anonym+"', "
                        + "VevoSzamCim='"+anonym+"', "
                        + "VevoAdoszam='"+anonym+"', "
                        + "TorzsVasarlo="+bool+" where VevoID="+vid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Vevo nem szukseges tulajdonsagainak megadasa szukseg eseten
    public Boolean updateFelhasznalo(String name, String szamcim, String adszam){
        Integer vid;
        ArrayList<Vevo> vevokLista = getVevok();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vevoEll(name);
            if (vid >= 0) {
                if (szamcim.equals("")) szamcim = vevokLista.get(vid).getVevoSzamCim();
                if (adszam.equals("")) adszam = vevokLista.get(vid).getVevoAdoszam();
                String sql = "update vevo set VevoSzamCim='"+szamcim+"', VevoAdoszam='"+adszam+"' where VevoID="+vid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Vevo jelszo valtoztatas
    public Boolean changeVevoPassw(String name, String password){
        Integer vid;
        password = encrypt(password);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vevoEll(name);
            if (vid >= 0) {
                String sql = "update vevo set VevoPassword='"+password+"' where VevoID="+vid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //vevo ellenorzes
    private Integer vevoEll(String name){
        Integer vid;
        ArrayList<Vevo> vevokLista = getVevok();
        for (Integer i = 0; i < vevokLista.size(); i++) {
            if (vevokLista.get(i).getVevoNev().equals(name)) {
                vid = vevokLista.get(i).getVevoID();
                return vid;
            }
        }
        return vid = -1;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Termek letrehozas es update">
    //Termek Letrehozasa
    /**
     * @param url a kep web/RES/ mappaban valo elerhetoseget tarolja majd
     * tehat ahhoz hogy megjelenjen a kep nevet es kiterjeszteset kell majd beirni
     * mivel csak admin kezelheti majd igy lehetseges
     * 
    */
    public ArrayList<String> termekStringData(String name, String desc, String url){
        ArrayList<String> tStringData = new ArrayList<>();
        tStringData.add(name); //termek neve,         index = 0
        tStringData.add(desc); //termek leirasa,      index = 1
        tStringData.add(url);  //termek kepenek cime, index = 2
        return tStringData;
    }
    public Boolean createTermek(ArrayList<String> StringData, Short bool, Short category,
            Integer price){
        ArrayList<Termek> termekLista = getTermekek();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String name = StringData.get(0);
            String desc = StringData.get(1);
            String url = "ProgMod2TeamSZWebshop\\SzamtechWebShop\\web\\res/"+StringData.get(2);
            for (Integer i = 0; i < termekLista.size(); i++) {
                if (termekEll(name, termekLista) == -1) {
                    String sql = "insert into termek (TermekNev,TermekDesc,TermekAr,TermekKep,TermekKeszlet,TermekKatID) "
                            + "values('"+name+"','"+desc+"',"+price+",'"+url+"',"+bool+","+category+")";
                    PreparedStatement prestm = DBCon.prepareStatement(sql);
                    prestm.execute();
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        } catch(SQLException ex){
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Termekek betoltese
    /**
     * rs.get...
     * 1-ID     4-Ar        7-KatID
     * 2-Name   5-Kep
     * 3-Desc   6-Keszlet
    */
    public ArrayList<Termek> getTermekek(){
        ArrayList<Termek> termekek = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from termek";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Termek t = new Termek();
                t.setTermekID(rs.getInt(1));
                t.setTermekNev(rs.getString(2));
                t.setTermekDesc(rs.getString(3));
                t.setTermekAr(rs.getInt(4));
                t.setTermekKep(rs.getString(5));
                t.setTermekKeszlet(rs.getShort(6));
                t.setTermekKatID(rs.getShort(7));
                termekek.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return termekek;
    }
    //Termek "torles"
    public Boolean anonymTermek(String code){
        Integer tid;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            tid = termekEll(code, getTermekek());
            if (tid >= 0) {
                String name = "anonymTermek"+tid;
                String sql = "update termek set TermekNev='"+name+"' where TermekID="+tid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Termek update
    public Boolean updateTermek(Integer price, Short bool, String code){
        Integer tid;
        ArrayList<Termek> termekLista = getTermekek();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            tid = termekEll(code, getTermekek());
            if (tid >= 0) {
                if (price == 0) price = termekLista.get(tid).getTermekAr();
                if (bool == 0) bool = termekLista.get(tid).getTermekKeszlet();
                String sql = "update termek set TermekAr="+price+", TermekKeszlet="+bool+" where TermekID="+tid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //termek ellenorzes
    private Integer termekEll(String name, ArrayList<Termek> tList){
        Integer tid;
        for (Integer i = 0; i < tList.size(); i++) {
            if (tList.get(i).getTermekNev().equals(name)) {
                tid = tList.get(i).getTermekID();
                return tid++;
            }
        }
        return tid = -1;
    }
    //termek lekerese
    public Termek getTermek(String name, ArrayList<Termek> tList){
        Termek t = new Termek();
        for (Integer i = 0; i < tList.size(); i++) {
            if (tList.get(i).getTermekNev().equals(name)) {
                t = tList.get(i);
                break;
            }
        }
        return t;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Vasarlas, szamlazas, egysegarak">
    //String ertekek szamla letrehozashoz hogy attekinthetobb legyen
    public ArrayList<String> szamlaStringData(String user, String fizmod, String varos,
                    String Hszam, String egyeb, String irszam){
        ArrayList<String> szStringData = new ArrayList<>();
        szStringData.add(user); //felhasznalo         index = 0
        szStringData.add(fizmod); //fizetesi mod      index = 1
        szStringData.add(varos);  //varos neve        index = 2
        szStringData.add(Hszam); //hazszam/utca       index = 3
        szStringData.add(egyeb); //egyeb kozlendo     index = 4
        szStringData.add(irszam); //iranyitoszam      index = 5
        return szStringData;
    }
    //Vasarlas letrehozasa
    public Boolean createSzamla(ArrayList<String> stringData, Short szamla,
                            Integer sum, String date, 
                            ArrayList<Integer> mennyiseg,
                            ArrayList<String> vasaroltTermekek){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String user = stringData.get(0);
            String fizmod = stringData.get(1);
            String varos = stringData.get(2);
            String hszam = stringData.get(3);
            String egyeb = stringData.get(4);
            String irszam = stringData.get(5);
            sum = vasarlasSum(mennyiseg, vasaroltTermekek);
            String sql = "insert into vasarlas (Felhasznalo,Szamla,FizMod,Osszeg,IRSzam,Varos,UtcaHSzam,Idopont,Egyeb) "
                    + "values('"+user+"',"+szamla+",'"+fizmod+"',"+sum+",'"+irszam+"','"+varos+"','"+hszam+"',"+date+",'"+egyeb+"')";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            ArrayList<Termek> termekek = getTermekek();
            Boolean egysegar = createEgysegArak(user, termekek, mennyiseg, vasaroltTermekek, date);
            return egysegar;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //sum szamolas
    private Integer vasarlasSum(ArrayList<Integer> amount, ArrayList<String> tName){
        Integer sum = 0, tid;
        ArrayList<Termek> tList = getTermekek();
        for (Integer i = 0; i < tName.size(); i++) {
            tid = termekEll(tName.get(i), tList);
            Integer resz = (sum+tList.get(tid).getTermekAr())*amount.get(i);
            sum += resz;
        }
        return sum;
    }
    //Vasarlas lemondasa
    public Boolean delVasarlas(String name, String date){
        Integer vid;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vasarlasEll(name, date);
            if (vid >= 0) {
                String sql = "update vasarlas set Egyeb='DELETED' where Felhasznalo='"+name+"',Idopont='"+date+"'";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Egysegarak leirasa
    public Boolean createEgysegArak(String name, ArrayList<Termek> tList, 
                    ArrayList<Integer> mennyiseg,
                    ArrayList<String> vTermek,
                    String date){
        Integer vid, tid;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vasarlasEll(name, date);
            if (vid >= 0) {
                for (Integer i = 0; i < vTermek.size(); i++) {
                    tid = termekEll(name, tList);
                    Integer ar = tList.get(tid--).getTermekAr();
                    String sql = "insert into egysegarak (Vasarlas_SorSzam,Termek_TermekID,Termek_TermekAr,Termek_Mennyiseg) "
                        + "values("+vid+","+tid+","+ar+","+mennyiseg.get(i)+")";
                    PreparedStatement prestm = DBCon.prepareStatement(sql);
                    prestm.execute();
                }
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch(Exception ex){
            System.err.println(ex.toString());
            return Boolean.FALSE;
        }
    }
    //Vasarlas anonymizalasa
    public Boolean anonymVasarlas(String name, String date){
        Integer vid;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            vid = vasarlasEll(name, date);
            System.out.println(vid);
            if (vid >= 0) {
                String anonym = "Anonym"+vid;
                String sql = "update vasarlas set Felhasznalo='"+anonym+"', IRSzam='0000', "
                        + "Varos='"+anonym+"', UtcaHSzam='"+anonym+"', Egyeb='DELETED' where SorSzam="+vid+"";
                PreparedStatement prestm = DBCon.prepareStatement(sql);
                prestm.executeUpdate();
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Vasarlasok beolvasasa by name
    /**
     * 1-sorszam        6-irszam
     * 2-felhasznalo    7-varos
     * 3-szamla         8-Hszam
     * 4-fizmod         9-date
     * 5-osszeg
     */
    public ArrayList<Vasarlas> getVasarlasok(String name, String date){
        ArrayList<Vasarlas> vasarlasok = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from vasarlas where Felhasznalo='"+name+"',Idopont='"+date+"'";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Vasarlas va = new Vasarlas();
                va.setSorSzam(rs.getInt(1));
                va.setFelhasznalo(rs.getString(2));
                va.setSzamla(rs.getShort(3));
                va.setFizMod(rs.getString(4));
                va.setOsszeg(rs.getInt(5));
                va.setIRSzam(rs.getString(6));
                va.setVaros(rs.getString(7));
                va.setUtcaHSzam(rs.getString(8));
                va.setIdopont(rs.getString(9));
                vasarlasok.add(va);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vasarlasok;
    }
    //vasarlas ellenorzes
    private Integer vasarlasEll(String name, String date){
        ArrayList<Vasarlas> vList = getVasarlasok(name, date);
        Integer vid;
        for (Integer i = 0; i < vList.size(); i++) {
            if (vList.get(i).getFelhasznalo().equals(name)) {
                vid = vList.get(i).getSorSzam();
                return vid;
            }
        }
        return vid = -1;
    }
    //vasarlas lekerese
    public Vasarlas getVasarlas(String name, String date){
        ArrayList<Vasarlas> vList = getVasarlasok(name, date);
        Vasarlas v = new Vasarlas();
        for (Integer i = 0; i < vList.size(); i++) {
            if (vList.get(i).getFelhasznalo().equals(name)) {
                v = vList.get(i);
                break;
            }
        }
        return v;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Rendezes, Kereses, Kategoria szures">
    //Kereses
    public ArrayList<Termek> termekSearch(String name){
        ArrayList<Termek> termekek = getTermekek();
        ArrayList<Termek> searched = new ArrayList<>();
        String nev = "";
        try{
            for (Termek t : termekek){
                nev = t.getTermekNev();
                if (nev.equals(name) || nev.contains(name)) searched.add(t);
            }
            return searched;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return searched;
        }
    }
    //Rendezes
    public ArrayList<Termek> termekSort(Boolean bool){
        ArrayList<Termek> termekek = getTermekek();
        try{
            if (bool == Boolean.TRUE) {
                Collections.sort(termekek);
            } else {
                Collections.reverse(termekek);
            }
            return termekek;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return termekek;
        }
    }
    //Kategoria kezeles
    public ArrayList<Termek> termekKatSearch(ArrayList<Short> katID){
        ArrayList<Termek> termekek = getTermekek();
        ArrayList<Termek> searched = new ArrayList<>();
        Short tkid;
        try{
            for (Termek t : termekek){
                tkid = t.getTermekKatID();
                for (Short i = 0; i < katID.size(); i++) {
                    if (tkid == katID.get(i)) {
                        searched.add(t);
                    }
                }
            }
            return searched;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return searched;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Read Partner,Gyarto,Szerviz">
    //Partnerek beolvasasa
    public ArrayList<Partner> getPartners(){
        ArrayList<Partner> partners = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from partner";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Partner pn = new Partner(rs.getInt(1), rs.getString(2), rs.getString(3));
                pn.setPartnerAdoszam(rs.getString(4));
                partners.add(pn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partners;
    }
    //Gyartok beolvasasa
    public ArrayList<Gyarto> getGyartok(){
        ArrayList<Gyarto> gyartok = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from gyarto";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Gyarto gy = new Gyarto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getShort(4));
                gyartok.add(gy);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gyartok;
    }
    //Szerviz beolvasasa
    public ArrayList<Szerviz> getszervizek(){
        ArrayList<Szerviz> szervizek = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "select * from szerviz";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Szerviz sz = new Szerviz(rs.getInt(1), rs.getString(2), rs.getString(3));
                szervizek.add(sz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return szervizek;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Create Partner,Gyarto,Szerviz">
    //Partner mentese
    public Boolean createPartner(String name, String elerhetoseg){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "insert into partner (PartnerNev,PartnerElerhetoseg) "
                        + "values('"+name+"','"+elerhetoseg+"')";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Gyarto mentese
    public Boolean createGyarto(String name, String elerhetoseg, Boolean gyartoiGarancia){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            short bool = 0;
            if (gyartoiGarancia) bool = 1;
                else bool = 0;
            String sql = "insert into partner (GyartoNev,GyartoElerhetoseg,GyartoiGarancia) "
                    + "values('"+name+"','"+elerhetoseg+"'"+bool+")";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Szerviz mentese
    public Boolean createSzerviz(String name, String elerhetoseg){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "insert into partner (SzervizNev,SzervizElerhetoseg) "
                    + "values('"+name+"','"+elerhetoseg+"')";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    // </editor-fold>
    
    //Partnerek adoszamanak beallitasa szukseg eseten
    public Boolean updatePartnerAdoszam(String adszam, String name, String code){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection(DBServer, DBUsername, DBPassword);
            String sql = "update partner set PartnerAdoszam='"+adszam+"' where PartnerNev=" + name + "";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebShopService.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    //Password encryption
    public String encrypt(String password){
        function f = new function();
        return f.encryptPassword(password);
    }
}

