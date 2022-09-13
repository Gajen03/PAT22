/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBBackend;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gajendran
 */
public class TestDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        DB database = new DB();
        
        database.update("INSERT INTO `gajendranDB`.`Players` (`Kit number`, `Names`, `Surnames`, `Position`) VALUES ('14', 'Saien', 'Naiker', 'CM');");
        
        
        
    }
}
