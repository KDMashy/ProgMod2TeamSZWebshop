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
    public Integer userLogin(String name, String password, ArrayList<Vevo> vevokLista, ArrayList<Admin> adminLista, Vevo chosenOne, Admin chosenAdmin){
        Integer exist = 0;
        try{
            for (Integer i = 0; i < vevokLista.size(); i++) {
                if (vevokLista.get(i).getVevoNev().equals(name) == Boolean.TRUE 
                  || vevokLista.get(i).getVevoEmail().equals(name) == Boolean.TRUE) {
                    exist = 1;
                    chosenOne = vevokLista.get(i);
                    break;
                } else {
                    for (Integer j = 0; j < adminLista.size(); j++) {
                        if (adminLista.get(j).getAdminname().equals(name) == Boolean.TRUE) {
                            if (adminLista.get(j).getAdminpassword().equals(password) == Boolean.TRUE) {
                                chosenAdmin = adminLista.get(j);
                                exist = 2;
                                return 2;
                            }
                        }
                    }
                    exist = 0;
                }
            }
            if (chosenOne.getVevoPassword().equals(password) && exist == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch(Exception ex){
            return 0;
        }
    }
    
    //Admin bejelentkezes
    @Override
    public Boolean adminLogin(String name, String password, String code, Admin chosenAdmin){
        try{
            if (chosenAdmin.getAdminname().equals(name) == Boolean.TRUE) {
                if (chosenAdmin.getAdminpassword().equals(password) == Boolean.TRUE) {
                    if (chosenAdmin.getAdmincode().equals(code) == Boolean.TRUE) {
                        return Boolean.TRUE;
                    } else {
                        return Boolean.FALSE;
                    }
                } else {
                    return Boolean.FALSE;
                }
            } else {
                return Boolean.FALSE;
            }
        } catch(Exception ex){
            return Boolean.FALSE;
        }
    }
}
