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
    
    public static void addGame(String location,String RHbTeam,String OpponentTeam) throws ClassNotFoundException, SQLException{
    
        DB database = new DB();
        database.update("INSERT INTO Game(Location,TeamA,TeamB) VALUES('"+location+"','"+RHbTeam+"','"+OpponentTeam+"');");
    }
    public static void addGameGoals(String gameID,String playerID,int goals) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Goals) VALUES('"+gameID+"','"+playerID+"','"+goals+"');");

    }
    public static void addGameAssists(String gameID,String playerID,int assists) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Assists) VALUES('"+gameID+"','"+playerID+"','"+assists+"') ;");

    }
    public static void addGameCards(String gameID,String playerID,char cards) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Cards) VALUES('"+gameID+"','"+playerID+"','"+cards+"');");

    }
    
    
    
    public static String getGameID(String teamAID,String teamBID ) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGameIDRS = database.query("SELECT Game.GameID FROM Game WHERE TeamA = '"+teamAID+"' AND TeamB = '"+teamBID+"'");
        String getGameIDStr = DB.toString(getGameIDRS).replace("#", " ").replace("\n","#");
        String getGameID = getGameIDStr.substring(getGameIDStr.lastIndexOf(" ")).replace("#", "").replace(" ", "");
        
        return getGameID;
    }
    
    public static String getGoalsScored(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT SUM(Goals) FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"' AND Game.GameID = '"+gameID+"';");
        return DB.toString(getGoals);
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
    
    public static String[] populateTeamList(char teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getCount = database.query("SELECT COUNT(*)  FROM Game WHERE TeamA = '"+teamID+"'");
        int numRows = getCount.getInt(1);
        
        ResultSet getTeamB = database.query("SELECT Teams.Name FROM Game,Teams WHERE TeamA = 1 AND Teams.TeamID = TeamB ;");
    
        
        String[] results = new String[numRows];
        int count = 0;
        
        while(getTeamB.next()){
            results[count] = TeamManager.getTeamName(teamID)+" vs "+getTeamB.getString("Name");
            count++;
        }
        
        return results;
    }


}
