/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import DBBackend.DB;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gajendran
 */
public class UserManager {
    
    
    public static void addUser(String username,String password) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        database.update("INSERT INTO Users(usernames,password) VALUES ('"+username+"', '"+password+"');");
   
    }
    public static boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        ResultSet getUsernameAndPassword = database.query("SELECT COUNT(*) FROM Users WHERE usernames = '"+username+"' AND password = '"+password+"';");
        getUsernameAndPassword.next();
        int check = getUsernameAndPassword.getInt(1);
        
        return check == 1;
 
    }
}
