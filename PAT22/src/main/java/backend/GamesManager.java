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
    
    public static String getGamesPlayers(String teamName) throws ClassNotFoundException, SQLException{
        DB database = new DB();
        ResultSet getGamePlayers = database.query("");
    }
}
