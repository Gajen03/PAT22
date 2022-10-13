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
    public static String getTopGoalScorer(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getTopGoalScorer = database.query("SELECT Players.Name,Players.Surname,Stats.Goals FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' ORDER BY Goals DESC LIMIT 1 ;");
        return DB.toString(getTopGoalScorer);
    }
    public static String getAssister(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getTopAssister = database.query("SELECT Players.Name,Players.Surname,Stats.Assists FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' ORDER BY Assists DESC LIMIT 1 ;");
        return DB.toString(getTopAssister);
    }
    public static String getMostCard(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getMostCard = database.query("SELECT Players.Name,Players.Surname,Stats.Cards FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' ORDER BY Cards DESC LIMIT 1 ;");
        return DB.toString(getMostCard);
    }
    
}
