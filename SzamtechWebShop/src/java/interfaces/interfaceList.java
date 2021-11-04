package interfaces;

import model.*;
import java.util.*;

public interface interfaceList {
    
    Integer userLogin(String name, String password, ArrayList<Vevo> vList, ArrayList<Admin> aList, Vevo chosenOne, Admin chosenAdmin);
    Boolean adminLogin(String name, String password, String code, Admin chosenAdmin);
    
}
