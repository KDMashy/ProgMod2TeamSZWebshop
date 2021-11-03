package service;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class WebShopService{
    
    //Belepes
    //KELL Vevo chosenOne = new Vevo();
    
    //Regisztracio
    public Boolean RegAcc(String name, String email, String password){
        password = encrypt(password);
        Boolean exist = Boolean.FALSE;
        try{
            ArrayList<Vevo> vevokLista = getVevok();
            for (Integer i = 0; i < vevokLista.size(); i++) {
                if (vevokLista.get(i).getVevoNev().equals(name) == Boolean.TRUE 
                        || vevokLista.get(i).getVevoEmail().equals(email) == Boolean.TRUE) {
                    exist = Boolean.TRUE;
                    break;
                } else {
                    exist = Boolean.FALSE;
                }
            }
            if (exist == Boolean.FALSE) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "root", "");
                String sql = "insert into vevo (VevoNev,VevoPassword,VevoEmail) values('"+name+"','"+password+"','"+email+"')";
                PreparedStatement prestm = con.prepareStatement(sql);
                prestm.execute();
            }
            return Boolean.TRUE;
        } catch (Exception ex){
            return Boolean.FALSE;
        }
    }
    //DBConnector fuggveny
    private Connection DBCon = DBConnector();
    private Connection DBConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            DBCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "root", "");
            return DBCon;
        } catch(Exception ex){
            return null;
        }
    }
    //Vevok betoltese
    public ArrayList<Vevo> getVevok(){
        ArrayList<Vevo> vevok = new ArrayList<>();
        try{
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
            return vevok;
        } catch(Exception ex){
            return null;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Read Partner,Gyarto,Szerviz">
    //Partnerek beolvasasa
    public ArrayList<Partner> getPartners(){
        ArrayList<Partner> partners = new ArrayList<>();
        try{
            String sql = "select * from partner";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Partner pn = new Partner(rs.getInt(1), rs.getString(2), rs.getString(3));
                pn.setPartnerAdoszam(rs.getString(4));
                partners.add(pn);
            }
            return partners;
        } catch(Exception ex){
            return null;
        }
    }
    //Gyartok beolvasasa
    public ArrayList<Gyarto> getGyartok(){
        ArrayList<Gyarto> gyartok = new ArrayList<>();
        try{
            String sql = "select * from gyarto";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Gyarto gy = new Gyarto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getShort(4));
                gyartok.add(gy);
            }
            return gyartok;
        } catch(Exception ex){
            return null;
        }
    }
    //Szerviz beolvasasa
    public ArrayList<Szerviz> getszervizek(){
        ArrayList<Szerviz> szervizek = new ArrayList<>();
        try{
            String sql = "select * from szerviz";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            ResultSet rs = prestm.executeQuery();
            while (rs.next()){
                Szerviz sz = new Szerviz(rs.getInt(1), rs.getString(2), rs.getString(3));
                szervizek.add(sz);
            }
            return szervizek;
        } catch(Exception ex){
            return null;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Create Partner,Gyarto,Szerviz">
    //Partner mentese
    public Boolean createPartner(String name, String elerhetoseg){
        try{
            String sql = "insert into partner (PartnerNev,PartnerElerhetoseg) values('"+name+"','"+elerhetoseg+"')";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch(Exception ex){
            return Boolean.FALSE;
        }
    }
    //Gyarto mentese
    public Boolean createGyarto(String name, String elerhetoseg, Boolean gyartoiGarancia){
        try{
            short bool = 0;
            if (gyartoiGarancia) bool = 1;
                else bool = 0;
            String sql = "insert into partner (GyartoNev,GyartoElerhetoseg,GyartoiGarancia) values('"+name+"','"+elerhetoseg+"'"+bool+")";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch(Exception ex){
            return Boolean.FALSE;
        }
    }
    //Szerviz mentese
    public Boolean createSzerviz(String name, String elerhetoseg){
        try{
            String sql = "insert into partner (SzervizNev,SzervizElerhetoseg) values('"+name+"','"+elerhetoseg+"')";
            PreparedStatement prestm = DBCon.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch(Exception ex){
            return Boolean.FALSE;
        }
    }
    // </editor-fold>
    
    private static String encrypt(String password){
        password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return password;
    }
}
