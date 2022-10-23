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
    
  
    
    public static int addGame(String location,String RHbTeam,String OpponentTeam,String Date,int OpponentScore) throws ClassNotFoundException, SQLException{
    
        DB database = new DB();
        database.update("INSERT INTO Game(Location,TeamA,TeamB,Date,TeamBGoals) VALUES('"+location+"','"+RHbTeam+"','"+OpponentTeam+"','"+Date+"','"+OpponentScore+"');");
        
        
        ResultSet getgameIDRS = database.query("SELECT Game.GameID FROM Game  ORDER BY GameID DESC LIMIT 1;");
        getgameIDRS.next();
        int gameID = getgameIDRS.getInt("GameID");
        return gameID;
    }
    
    public static void addGameGoals(int gameID,String playerID,int goals) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Goals) VALUES('"+gameID+"','"+playerID+"','"+goals+"');");
        
        
    }
    public static void addGameAssists(int gameID,String playerID,int assists) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Assists) VALUES('"+gameID+"','"+playerID+"','"+assists+"') ;");

    }
    public static void addGameCards(int gameID,String playerID,String cards) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Stats(Stats.GameID,Stats.PlayerID,Cards) VALUES('"+gameID+"','"+playerID+"','"+cards+"');");

    }
    
    public static String getLocation(String gameID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getLocation = database.query("SELECT Location FROM Game WHERE Game.GameID = '"+gameID+"' ;");
        return DB.toString(getLocation).replace("#", "");
    }
    public static String getGoalsScored(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT SUM(Goals) FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"' AND Game.GameID = '"+gameID+"';");
        return DB.toString(getGoals).replace("#", "");
    }
    public static String getOpponentScore(String gameID ) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getRHBTeam = database.query("SELECT TeamBGoals FROM Game WHERE Game.GameID = '"+gameID+"';");
        return DB.toString(getRHBTeam).replace("#", "");
        
    }
    public static String getRHBTeamName(String gameID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getRHBTeam = database.query("SELECT Teams.Name FROM Game,Teams WHERE Game.GameID = '"+gameID+"'AND Game.TeamA = Teams.TeamID");
        return DB.toString(getRHBTeam);
    }
    
    public static String getOpponentName(String gameID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getOpponent = database.query("SELECT Teams.Name FROM Game,Teams WHERE Game.GameID = '"+gameID+"' AND Game.TeamB = Teams.TeamID");
        return DB.toString(getOpponent);
    }
    
    public static String getGoalsScorers(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getScorers = database.query("SELECT Players.Name,Players.Surname,Stats.Goals FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Goals > 0;");
        return DB.toString(getScorers).replace("#", " ");
    }

    
    public static String getAssisters(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getAssister = database.query("SELECT Players.Name,Players.Surname,Stats.Assists FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Assists > 0;");
        return DB.toString(getAssister).replace("#", " ");
    }

    
    public static String getNamesCards(String gameID ) throws  ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getNamesCards= database.query("SELECT Players.Name,Players.Surname,Stats.Cards FROM Stats,Players,Game WHERE Stats.PlayerID = Players.PlayerID AND Stats.GameID = '"+gameID+"'  AND Game.GameID = '"+gameID+"'  AND Stats.Cards != \"\";");
        return DB.toString(getNamesCards).replace("#", " ");
    }
    
    public static String getGameID(String date) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGameID= database.query("SELECT GameID FROM Game WHERE Date = '"+date+"';");
        return DB.toString(getGameID);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String[] populateTeamList(char teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getCount = database.query("SELECT COUNT(*)  FROM Game WHERE TeamA = '"+teamID+"' ;");
        getCount.next();
        int numRows = getCount.getInt(1);
        
        ResultSet getTeamB = database.query("SELECT Teams.Name,Game.Date FROM Game,Teams WHERE TeamA = 1 AND Teams.TeamID = TeamB ;");
        String[] results = new String[numRows];
        int count = 0;
        
        while(getTeamB.next()){
            results[count] = TeamManager.getTeamName(teamID).replace("#", "")+" vs "+getTeamB.getString("Name")+"("+getTeamB.getString("Date")+")";
            count++;
        }
        
        return results;
    }
    
    


}
