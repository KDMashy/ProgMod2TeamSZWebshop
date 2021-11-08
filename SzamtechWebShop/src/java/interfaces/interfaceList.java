package interfaces;

import model.*;
import java.util.*;

public interface interfaceList {
    
    Integer userLogin(String name, String password, ArrayList<Vevo> vList, ArrayList<Admin> aList);
    Boolean adminLogin(String name, String password, String code, ArrayList<Admin> aList);
    
}
