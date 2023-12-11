/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package databasesystemsgroupproject;
import java.sql.*;
import java.util.*;


/**
 *
 * @author alexj
 */
public class DatabaseSystemsGroupProject {
    //Dummy variables for testing purposes
    private static String url="jdbc:postgresql://localhost:5432/DatatabaseSystemsGroupProjectAssignment9";
    private static String user="postgres";
    private static String password="S@n0cgaP5";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected");
            Admin admin=new Admin(connection);
            //admin.displayConsole.getConsoles();
            //admin.addGame();
            
            //admin.changeGameDescription();
            //admin.changeGameName();
            //admin.changeGameRating();
            //admin.deleteGame();
            
            //admin.addConsole();
            //admin.changeConsoleCreator();
            //admin.changeConsoleName();
            admin.changeConsolePrice();
            //admin.deleteConsole();

            

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot load driver.");
        } catch (SQLException e) {
            System.out.println("SQL error");
        }
    }
    
}
