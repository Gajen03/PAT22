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
public class Players {

    public static String[][] getData(String teamID) throws SQLException, ClassNotFoundException {
        DB database = new DB();
        

        ResultSet countQueryTeamPlayer = database.query("SELECT COUNT(*) FROM gajendranDB.Players,gajendranDB.TeamPlayer WHERE TeamID = "+teamID+";");
        countQueryTeamPlayer.next();
        int numRows = countQueryTeamPlayer.getInt(1);


        ResultSet dbData = database.query("SELECT * FROM gajendranDB.Players ;");

        String[][] data = new String[numRows][5];
        int count = 0;
        while (dbData.next()) {
            data[count][0] = dbData.getString("Name");
            data[count][1] = dbData.getString("Surname");
            data[count][2] = dbData.getString("Position");
            data[count][3] = dbData.getString("Date of Birth");
            data[count][4] = dbData.getString("Kit number");

            count++;
        }
        return data;
    }

    public static ArrayList<String> getDataList(String team, String name, String surname) throws SQLException, ClassNotFoundException {
        DB database = new DB();

        ResultSet countQuery = database.query("SELECT COUNT(*) FROM gajendranDB." + team + ";");
        countQuery.next();
        int numRows = countQuery.getInt(1);

        ResultSet getName = database.query("SELECT " + name + "," + surname + " FROM gajendranDB." + team + ";");
        getName.next();

        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i > numRows; i++) {
            list.add(name + " " + surname);
            count++;
        }

        return list;
    }
}
