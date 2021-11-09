package service;

import interfaces.*;
import model.*;
import java.util.*;

public class function implements interfaceList{
    /**
     * Interface tovabbitas a celja ennek az osztalynak
    */
    
    //Felhasznaloi bejelentkezes
    @Override
    public Integer userLogin(String name, String password, ArrayList<Vevo> vevokLista, ArrayList<Admin> adminLista){
        try{
            for (Integer i = 0; i < vevokLista.size(); i++) {
                if (vevokLista.get(i).getVevoNev().equals(name) == Boolean.TRUE) {
                    if (vevokLista.get(i).getVevoPassword().equals(password)) {
                        return 1;
                    }
                }
            }
            return 0;
        } catch(Exception ex){
            System.err.println(ex.toString());
            return 0;
        }
    }
    
    //Admin bejelentkezes
    @Override
    public Boolean adminLogin(String name, String password, String code, ArrayList<Admin> adminLista){
        try{
            for (Integer i = 0; i < adminLista.size(); i++) {
                if (adminLista.get(i).getAdminname().equals(name) == Boolean.TRUE) {
                    if (adminLista.get(i).getAdminpassword().equals(password) == Boolean.TRUE) {
                        if (adminLista.get(i).getAdmincode().equals(code) == Boolean.TRUE) {
                            return Boolean.TRUE;
                        }
                    }
                }
            }
            return Boolean.FALSE;
        } catch(Exception ex){
            System.err.println(ex.toString());
            return Boolean.FALSE;
        }
    }
    
    //Nev validalasa egy regisztraciokor vagy bejelentkezeskor
    @Override
    public Boolean validName(String name){
        try{
            if (name.contains("drop")) return Boolean.FALSE;
            else if (name.contains("update")) return Boolean.FALSE;
            else if (name.contains("insert")) return Boolean.FALSE;
            else if (name.contains("alter")) return Boolean.FALSE;
            else if (name.contains("table")) return Boolean.FALSE;
            
            else return Boolean.TRUE;
        } catch(Exception ex){
            System.err.println(ex.toString());
            return Boolean.FALSE;
        }
    }
    
    //jelszo titkositas
    @Override
    public String encryptPassword(String password){
        password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return password;
    }
}
