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

    public static final int AGE_13 = 13;
    public static final int AGE_14 = 14;
    public static final int AGE_15 = 15;
    public static final int AGE_16 = 16;
    public static final int AGE_OPEN = 17;
    public static final int AGE_ALL = 0;
    
    public static final char GENDER_MALE = 'M';
    public static final char GENDER_FEMALE = 'F';
    public static final char GENDER_ALL = 'A';
  
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
    //
    public static String[] getFilteredPlayerNames(char gender,int age) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        
        String namesInQuery = "";
        String genderInQuery = "";
        String ageInQuery = "";
        
        String query = "SELECT Players.Name, Players.Surname FROM Players";
        if(gender != PlayerManager.GENDER_ALL || age != PlayerManager.AGE_ALL){
            query += " WHERE ";
            if(gender != PlayerManager.GENDER_ALL){
                query += " Gender = " + gender;
            }
            
            
            if(gender != PlayerManager.GENDER_ALL && age != PlayerManager.AGE_ALL){
                query += " AND ";
            }
            
            
            if(age != PlayerManager.AGE_ALL){
                query += " Age = " + age;
            }
        }  
        query +=";";
    
        
        
        ResultSet dbData = database.query(query);
        String[] players = new String[10000];
        int count = 0;
        while (dbData.next()) {
            players[count] = dbData.getString("Name") + " " + dbData.getString("Surname");
            count++;
        }
      
        
        
        return players;
         // figure out what to return 
        
    }
    
    public static void addPlayer(String name,String surname,String age,String position,int kitnumber,String gender) throws SQLException, ClassNotFoundException{
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
        String[] players = new String[numRows];
        int count = 0;
        
        
        while (dbData.next()) {
            players[count] = dbData.getString("Name") + " " + dbData.getString("Surname");
          

            count++;
        }
      
        
        return players;
    }
}
