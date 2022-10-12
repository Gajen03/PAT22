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
public class StatsManager {
    
     public static String getCoach(String teamName) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        ResultSet getCoachNameQuery = database.query("SELECT Coach FROM Teams WHERE Teams.Name = '"+teamName+"';");

        return DB.toString(getCoachNameQuery);
        
    }
    
}
