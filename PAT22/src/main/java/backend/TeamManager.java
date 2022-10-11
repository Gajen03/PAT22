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
public class TeamManager {
    public static String [] getTeamNames() throws SQLException, ClassNotFoundException{
         DB database = new DB();
        

        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Teams;");
        countQueryTeamPlayer.next();
        int numRows = countQueryTeamPlayer.getInt(1);


        ResultSet getTeamNames = database.query("SELECT Teams.Name  FROM Teams;");
        String[] outputTable = new String[numRows];
        int count = 0;
        
        
        while (getTeamNames.next()) {
            outputTable[count] = getTeamNames.getString("Name");
          

            count++;
        }
      
        
        return outputTable;
        // need to figure out how to use these methods in UI
    }
    
    public static String[][] getPlayersInfoForTeam(String teamName) throws SQLException, ClassNotFoundException {
        DB database = new DB();
        

        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
        countQueryTeamPlayer.next();
        int numRows = countQueryTeamPlayer.getInt(1);


        ResultSet dbData = database.query("SELECT Players.PlayerID,Players.Name , Players.Surname ,Age,Position,KitNumber FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
        String[][] outputTable = new String[numRows][6];
        int count = 0;
        while (dbData.next()) {
            outputTable[count][1] = dbData.getString("Name");
            outputTable[count][2] = dbData.getString("Surname");
            outputTable[count][3] = dbData.getString("Age");
            outputTable[count][4] = dbData.getString("Position");
            outputTable[count][5] = dbData.getString("KitNumber");

            count++;
        }
        return outputTable;
    }
    
    public static String [] getPlayerInfoHeaders(){
        String [] headers = {"PLAYER ID","NAMES","SURNAMES","AGE","POSITION","KIT NUMBER"};
        return headers;
    }
    
    public static void addTeam(String teamName,String schoolName,String coachName) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO Teams(Name,School,Coach) VALUES ('"+teamName+"', '"+schoolName+"', '"+coachName+"');");
    }

    public static String[] getPlayersNamesForTeam(String teamName) throws SQLException, ClassNotFoundException {
        DB database = new DB();
        

        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
        countQueryTeamPlayer.next();
        int numRows = countQueryTeamPlayer.getInt(1);


        ResultSet dbData = database.query("SELECT Players.PlayerID,Players.Name , Players.Surname  FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
        String[] outputTable = new String[numRows];
        int count = 0;
        while (dbData.next()) {
            outputTable[1] = dbData.getString("Name");
            outputTable[2] = dbData.getString("Surname");
          

            count++;
        }
      
        
        return outputTable;
    }
    
    public static String getCoach(String teamName) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        ResultSet getCoachNameQuery = database.query("SELECT Coach FROM Teams WHERE Teams.Name = "+teamName+";");
        
        return getCoachNameQuery.toString();
        
    }
    
    public static void addPlayerToTeam(String PlayerID,String TeamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        database.update("INSERT INTO TeamPlayer(TeamID,PlayerID) VALUES ('"+TeamID+"','"+PlayerID+"');");
       
        
    }
    
    public static void deletePlayerFromTeam(String PlayerID,String TeamID){
        
    }
    






}
