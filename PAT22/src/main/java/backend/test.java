/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import DBBackend.DB;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gajendran
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        DB database = new DB();
        ResultSet getgameIDRS = database.query("SELECT Game.GameID FROM Game  ORDER BY GameID DESC LIMIT 1;");
        getgameIDRS.next();
        System.out.println(getgameIDRS.getInt("GameID")); 
    }
    
    


}