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

        return DB.toString(getCoachNameQuery).replace("#", " ");
        
    }
     
     // They dont work the correct way
     
    public static String getTopGoalScorer(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getTopGoalScorer = database.query("SELECT Players.Name,Players.Surname,COUNT(Goals) AS Goals FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' GROUP BY Stats.PlayerID ORDER BY Goals DESC LIMIT 1 ;");
        return DB.toString(getTopGoalScorer).replace("#", " ");
    }
    public static String getAssister(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getTopAssister = database.query("SELECT Players.Name,Players.Surname,COUNT(Assists) AS Assists FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' GROUP BY Stats.PlayerID ORDER BY Assists DESC LIMIT 1 ;");
        return DB.toString(getTopAssister).replace("#", " ");
    }
    public static String getMostCard(String gender) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getMostCard = database.query("SELECT Players.Name,Players.Surname,COUNT(Cards)AS Cards FROM Players,Stats WHERE Players.PlayerID = Stats.PlayerID AND gender = '"+gender+"' GROUP BY Stats.PlayerID ORDER BY Cards DESC LIMIT 1 ;");
        return DB.toString(getMostCard).replace("#", " ");
    }
    
    public static int[] getRHBGoals(String teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT COUNT(Goals) FROM Stats,Game WHERE Stats.GameID = Game.GameID AND TeamA = '"+teamID+"' GROUP BY Game.GameID");
       
        int[] goals = new int[10000];
        int count = 0;
        
        while (getGoals.next()) {
            goals[count] = getGoals.getInt("COUNT(Goals)") ;
          

            count++;
        }
        
        return goals;
        
    }
    
    public static int[] getOpponentGameGoals(String teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT TeamBGoals FROM Stats,Game WHERE Stats.GameID = Game.GameID AND TeamA = '"+teamID+"' GROUP BY Game.GameID");
       
        int[] goals = new int[10000];
        int count = 0;
        
        while (getGoals.next()) {
            goals[count] = getGoals.getInt("TeamBGoals") ;
          

            count++;
        }
        
        return goals;
        
    }
    
    public static String getWins(String teamID) throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        int[] RHB = getRHBGoals(teamID);
        int[] Opponent = getOpponentGameGoals(teamID);
        
        int wins = 0;
        for (int i = 0; i < RHB.length; i++) {
            
            if(RHB[i] > Opponent[i]){
                wins++;
            }
        }
        return ""+wins;
    }
    
    public static String getLosses(String teamID) throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        int[] RHB = getRHBGoals(teamID);
        int[] Opponent = getOpponentGameGoals(teamID);
        
        int losses = 0;
        for (int i = 0; i < RHB.length; i++) {
            
            if(RHB[i] < Opponent[i]){
                losses++;
            }
        }
        return ""+losses;
    }
    
    public static String getDraws(String teamID) throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        int[] RHB = getRHBGoals(teamID);
        int[] Opponent = getOpponentGameGoals(teamID);
        
        int draws= 0;
        for (int i = 0; i == RHB.length; i++) {
            
            if(RHB[i] > Opponent[i]){
                draws++;
            }
        }
        
        return ""+draws;
    }
    
    public static String getGoals(String teamID) throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        ResultSet getGoals = database.query("SELECT COUNT(Goals) FROM Stats,Game  WHERE Stats.GameID = Game.GameID AND TeamA = '"+teamID+"' ;");
        return DB.toString(getGoals).replace("#", "");
    }

    public static String getTopGoalScorerForTeam(String teamID)throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        ResultSet getTopGoalsScorer = database.query("SELECT  Players.Name,COUNT(Goals) AS Goals FROM Stats,Game,Players WHERE Stats.GameID = Game.GameID AND TeamA = '"+teamID+"' AND Stats.PlayerID = Players.PlayerID GROUP BY Players.Name ORDER BY Goals DESC LIMIT 1;");
        return DB.toString(getTopGoalsScorer).replace("#", " ");
    }
    
    public static String getTopAsssisterForTeam(String teamID)throws ClassNotFoundException, SQLException, SQLException{
        DB database = new DB();
        ResultSet getTopAssister = database.query("SELECT  Players.Name,COUNT(Assists) AS Assists FROM Stats,Game,Players WHERE Stats.GameID = Game.GameID AND TeamA = '"+teamID+"' AND Stats.PlayerID = Players.PlayerID GROUP BY Players.Name ORDER BY Assists DESC LIMIT 1;");
        return DB.toString(getTopAssister).replace("#", " ");
    }
}
