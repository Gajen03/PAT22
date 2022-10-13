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
public class GamesManager {
    
    public static String getGamesPlayed(String teamName) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getTeamID = database.query("SELECT Team.TeamID FROM Teams WHERE Team.Names = '"+teamName+"' ;");
        
        ResultSet getGamePlayed = database.query("SELECT COUNT(*) FROM Game WHERE  Game.TeamA = "+ DB.toString(getTeamID)+";");
        return DB.toString(getGamePlayed);
    }
    
    public static String getOponentName(String gameID) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        ResultSet getOponentName = database.query("SELECT Teams.Name FROM Game,Team WHERE TeamB = Teams.TeamID AND GameID = '"+gameID+"';");
        return DB.toString(getOponentName);
    }
    
    public static String getGoalsScored(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT SUM(Goals) FROM Players,Games,Stats WHERE Stats.PlayerID = Player.PlayerID AND Stats.GameID = '"+gameID+"';");
        return DB.toString(getGoals);
    }
    
    public static String getGoalsScorers(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getScorers = database.query("");
        // please figure this out future gajen
    }


}
