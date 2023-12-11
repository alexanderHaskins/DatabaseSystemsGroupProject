/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databasesystemsgroupproject;
import java.sql.*;
import java.util.*;

/**
 *
 * @author alexj
 */
public class Admin {
    Connection connection;
    public DisplayPublisher displayPublisher;
    public DisplayConsoles displayConsole;
    public DisplayGamesClass displayGame;
    public Admin(Connection conn){
        connection=conn;
        displayPublisher=new DisplayPublisher(conn);
        displayConsole=new DisplayConsoles(conn);
        displayGame=new DisplayGamesClass(conn);
    }
    public void addGame(){
        String InsertString="INSERT INTO game(GameID,Name,PublisherID,Genere,Rating,Description) VALUES (?,?,?,?,?,?);";
        try{
            Scanner scan = new Scanner(System.in);
            PreparedStatement pstmt = connection.prepareStatement(InsertString);
            //Get user input
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            
            System.out.print("Enter game name:");
            String gamename=scan.nextLine();
            
             System.out.print("Enter publisher id:");
            String pubid = scan.nextLine();
            
            System.out.print("Enter game genre:");
            String genre=scan.nextLine();
            
            System.out.print("Enter game rating:");
            String gameRate=scan.nextLine();
            
            System.out.print("Enter game description:");
            String gameDesc=scan.nextLine();
            //Add input to statement
            pstmt.setInt(1, Integer.parseInt(gameid));
            pstmt.setString(2, gamename);
            pstmt.setInt(3, Integer.parseInt(pubid));
            pstmt.setString(4, genre);
            pstmt.setString(5,gameRate);
            pstmt.setString(6, gameDesc);
            
            //Execute query
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
}
