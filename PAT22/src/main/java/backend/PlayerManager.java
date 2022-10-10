/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import DBBackend.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gajendran
 */
public class PlayerManager {

    public static final int AGE_13 = 0;
    public static final int AGE_14 = 1;
    public static final int AGE_15 = 2;
    public static final int AGE_16 = 3;
    public static final int AGE_OPEN = 4;
    public static final int AGE_ALL = 5;
    
    public static final int GENDER_MALE = 0;
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_ALL = 1;
    
    
//    
//    public static String[][] getPlayersInfoForTeam(String teamName) throws SQLException, ClassNotFoundException {
//        DB database = new DB();
//        
//
//        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
//        countQueryTeamPlayer.next();
//        int numRows = countQueryTeamPlayer.getInt(1);
//
//
//        ResultSet dbData = database.query("SELECT Players.PlayerID,Players.Name , Players.Surname ,Age,Position,KitNumber FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
//        String[][] outputTable = new String[numRows][6];
//        int count = 0;
//        while (dbData.next()) {
//            outputTable[count][1] = dbData.getString("Name");
//            outputTable[count][2] = dbData.getString("Surname");
//            outputTable[count][3] = dbData.getString("Age");
//            outputTable[count][4] = dbData.getString("Position");
//            outputTable[count][5] = dbData.getString("KitNumber");
//
//            count++;
//        }
//        return outputTable;
//    }
//    
//    public static String [] getPlayerInfoHeaders(){
//        String [] headers = {"PLAYER ID","NAMES","SURNAMES","AGE","POSITION","KIT NUMBER"};
//        return headers;
//    }
//    
//    public static String[] getPlayersNamesForTeam(String teamName) throws SQLException, ClassNotFoundException {
//        DB database = new DB();
//        
//
//        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
//        countQueryTeamPlayer.next();
//        int numRows = countQueryTeamPlayer.getInt(1);
//
//
//        ResultSet dbData = database.query("SELECT Players.PlayerID,Players.Name , Players.Surname  FROM Players, TeamPlayer, Teams WHERE (Teams.TeamID=TeamPlayer.TeamID AND TeamPlayer.PlayerID = Players.PlayerID) AND (Teams.Name = \'"+teamName+"\');");
//        String[] outputTable = new String[numRows];
//        int count = 0;
//        while (dbData.next()) {
//            outputTable[1] = dbData.getString("Name");
//            outputTable[2] = dbData.getString("Surname");
//          
//
//            count++;
//        }
//      
//        
//        return outputTable;
//    }
//    
    public static String[] getFilteredPlayersName(String [] names,int gender,int age) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        
        String namesInQuery = "";
        String genderInQuery = "";
        String ageInQuery = "";
        
        String query = "SELECT Name, Surname FROM Players";
        
        if(names != null){
            String namesSQL = "(";
            for (int i = 0; i < names.length; i++) {
                namesSQL += "\""+ names[i] + "\",";
            }
            namesSQL = namesSQL.substring(0, namesSQL.length()-1) + ")";
            
            
            
            query += " WHERE CONCAT(Name,' ',Surname) NOT IN " + namesSQL;
        }
        
        query +=";";
        
        ResultSet player = database.query("SELECT Name,Surname FROM Players WHERE Age >= '%2005'");
    
        return;
         // figure out what to return 
        
    }
    
    public static void addPlayer(String name,String surname,String  age,String position,int kitnumber,String gender) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        database.update("INSERT INTO Players (Players.Name,Surname,Age,Position,KitNumber,Gender) VALUES ('"+name+"', '"+surname+"', '"+age+"','"+position+"','"+kitnumber+"','"+gender+"');");
    }
    
    public static void removePlayer(String name, String surname) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        database.update("DELETE FROM Players WHERE Name = '"+name+"' AND Surname = '"+surname+"';");
    }
    
    public static String[] getAllPlayers() throws SQLException, ClassNotFoundException {
        DB database = new DB();
        

        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM Players;");
        countQueryTeamPlayer.next();
        int numRows = countQueryTeamPlayer.getInt(1);


        ResultSet dbData = database.query("SELECT Players.Name , Players.Surname  FROM Players;");
        String[] outputTable = new String[numRows];
        int count = 0;
        
        
        while (dbData.next()) {
            outputTable[count] = dbData.getString("Name") + " " + dbData.getString("Surname");
          

            count++;
        }
      
        
        return outputTable;
    }
}
