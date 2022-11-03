/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import DBBackend.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gajendran
 */
public class PlayerManager {

  

    public static void addPlayer(String name,String surname,int age,String position,int kitnumber,String gender) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        database.update("INSERT INTO Players (Players.Name,Surname,Age,Position,KitNumber,Gender) VALUES ('"+name+"', '"+surname+"', '"+age+"','"+position+"','"+kitnumber+"','"+gender+"');");
    }
    
    public static void removePlayer(String PlayerID) throws SQLException, ClassNotFoundException{
        DB database = new DB();
        database.update("DELETE FROM Stats WHERE Stats.PlayerID = '"+PlayerID+" '");
        database.update("DELETE FROM TeamPlayer WHERE TeamPlayer.PlayerID = '"+PlayerID+" '");
        database.update("DELETE FROM Players WHERE Players.PlayerID = '"+PlayerID+" '");
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
   
    public static String getPlayerID(String name,String surname) throws ClassNotFoundException, SQLException{
       DB database = new DB();
       
       ResultSet getPlayerID = database.query("SELECT Players.PlayerID FROM Players WHERE Players.Name = '"+name+"' AND Players.Surname = '"+surname+"' ;");
       String playerID = DB.toString(getPlayerID).replace("#","");
       if(playerID.equals("")){
           return "0";
       }else{
       return playerID;
           
       }
    }
    
    public static String getPlayerGoals(String playerID) throws ClassNotFoundException, SQLException{
        DB databse = new DB();
        ResultSet getGoals = databse.query("SELECT SUM(Goals) FROM Stats WHERE Stats.PlayerID = '"+playerID+"';");
      
            
        return DB.toString(getGoals).replace("#", "");
        
    }
    
    public static String getPlayerAssists(String playerID) throws ClassNotFoundException, SQLException{
        DB databse = new DB();
        ResultSet getAssists = databse.query("SELECT SUM(Assists) FROM Stats WHERE Stats.PlayerID = '"+playerID+"';");
      
            
        return DB.toString(getAssists).replace("#", "");
        
    }
    
    public static String getPlayerCards(String playerID) throws ClassNotFoundException, SQLException{
        DB databse = new DB();
        ResultSet getCards = databse.query("SELECT COUNT(Cards) FROM Stats WHERE Stats.PlayerID = '"+playerID+"'");
       
            
        return DB.toString(getCards);
       
    }
    public static String getPosition(String playerID) throws ClassNotFoundException, SQLException{
        DB databse = new DB();
        ResultSet getPos = databse.query("SELECT Position FROM Players WHERE Players.PlayerID = '"+playerID+"'");
        
            
        return DB.toString(getPos);
        
        
    }
    public static String calcOVR(String playerID) throws ClassNotFoundException, SQLException{
        
       DB databse = new DB();
      
        ResultSet getOvr = databse.query("SELECT (SUM(Goals)+SUM(Assists)+70) FROM Stats WHERE Stats.PlayerID = '" + playerID + "';");

        String ovr = DB.toString(getOvr).replace("\\n", "").replace("#", "");
        if (ovr.contains("null")) {

            return "70";
        }else{
            return DB.toString(getOvr);
        }


        
    }
    
    public static String[] getTeamPlayers(String teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet rs = database.query("SELECT COUNT(*) FROM TeamPlayer,Players WHERE TeamPlayer.TeamID = '"+teamID+"' AND TeamPlayer.PlayerID = Players.PlayerID ;");
        rs.next();
        int numRowsRS = rs.getInt(1);
        
        ResultSet dbData = database.query("SELECT Players.Name , Players.Surname,Players.Gender  FROM TeamPlayer,Players WHERE TeamPlayer.TeamID = '"+teamID+"' AND TeamPlayer.PlayerID = Players.PlayerID;");
        String[] teamPlayers = new String[numRowsRS];
        int count = 0;

      
        
        while (dbData.next()) {
            teamPlayers[count] = dbData.getString("Name") + " " + dbData.getString("Surname")+ " (" + dbData.getString("Gender")+")";
            

            count++;
        }
        
   
        return teamPlayers;
    }
   
    public static String[] getAvaliblePlayers(char teamID) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        
        Scanner sc = new Scanner(Arrays.toString(TeamManager.getTeamPlayerName(teamID))).useDelimiter(", ");
        String allFullnameStr = "";
        while(sc.hasNext()){
            allFullnameStr += sc.next().replace("[", "").replace("]", "")+"#";
        }

        Scanner fullNameSc = new Scanner(allFullnameStr.substring(0, allFullnameStr.length()-1)).useDelimiter("#");
        
        String query = "WHERE ";
        while(fullNameSc.hasNext()){
            String fullname = fullNameSc.next();
            Scanner fullNameScanner = new Scanner(fullname);
            String name = fullNameScanner.next();
            String surname = fullNameScanner.next();
            query += "Players.Name != '"+name+"' AND Players.Surname != '"+surname+"' AND ";
        }
        
        ResultSet avaliblePlayersRS = database.query("SELECT COUNT(*) FROM Players "+query+" Players.Name = Players.Name;");
        avaliblePlayersRS.next();
        int numRows = avaliblePlayersRS.getInt(1);
        
        ResultSet dbData = database.query("SELECT Players.Name,Players.Surname,Players.Gender FROM Players "+query+" Players.Name = Players.Name;");
        String[] avaliblePlayers = new String[numRows];
        int count =0;
        
        while(dbData.next()){           
            avaliblePlayers[count] = dbData.getString("Name") + " " + dbData.getString("Surname") + " (" + dbData.getString("Gender")+")";

            count++;
        }
        
        return avaliblePlayers;
    }
}
