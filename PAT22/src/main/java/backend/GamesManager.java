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
        ResultSet getGoals = database.query("SELECT SUM(Goals) FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"' AND Game.GameID = '"+gameID+"';");
        return DB.toString(getGoals);
    }
    
    public static void addGame(String location,String RHbTeam,String OpponentTeam) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet addGame = database.query("INSERT INTO Game(Location,TeamA,TeamB) VALUES('"+location+"','"+RHbTeam+"','"+OpponentTeam+"')");
    }
    
    
    
    
    
    
    
    public static String getGoalsScorers(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getScorers = database.query("SELECT Players.Name,Players.Surname FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Goals > 0;");
        return DB.toString(getScorers);
    }
    
    
    public static String getAssists(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getAssists = database.query("SELECT SUM(Assists) FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"' AND Game.GameID = '"+gameID+"';");
        return DB.toString(getAssists);
    }
    
    public static String getAssisters(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getAssister = database.query("SELECT Players.Name,Players.Surname FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Assists > 0;");
        return DB.toString(getAssister);
    }
    
    
    
    // double check these
    public static String getCards(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getCards = database.query("SELECT SUM(Cards) FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"' AND Game.GameID = '"+gameID+"';");
        return DB.toString(getCards);
    }
    
    public static String getNamesCards(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getNamesCards= database.query("SELECT Players.Name,Players.Surname FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Cards > 0;");
        return DB.toString(getNamesCards);
    }


}
