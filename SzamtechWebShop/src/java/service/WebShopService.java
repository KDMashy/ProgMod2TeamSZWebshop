package service;

import java.sql.*;

public class WebShopService{
    
    public Boolean RegAcc(String name, String email, String password){
        password = encrypt(password);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "root", "");
            String sql = "insert into vevo (VevoNev,VevoPassword,VevoEmail) values('"+name+"','"+password+"','"+email+"')";
            PreparedStatement prestm = con.prepareStatement(sql);
            prestm.execute();
            return Boolean.TRUE;
        } catch (Exception ex){
            return Boolean.FALSE;
        }
    }
    private static String encrypt(String password){
        password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return password;
    }
}
