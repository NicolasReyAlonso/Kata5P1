/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiper
 */
public class SelectApp {
    private String URL;
    private Connection con;
    private boolean work;
    
    public SelectApp(String URL){
        this.URL = URL;
        connect();
        
    }
    private void connect(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:"+URL);
            work = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
            work = false;
        }
    }
    
    public void SelectAll(String sql){
        if (work){
            try (Statement stmt = con.createStatement(); 
                 ResultSet rs = stmt.executeQuery(sql)){
            
                while (rs.next()) {
                    System.out.println(rs.getInt("id") +  "\t" 
                             + rs.getString("Name") + "\t" 
                             + rs.getString("Apellido")  + "\t" 
                             + rs.getString("Departamento") + "\t");
                } 
            } catch (SQLException e) { 
                System.out.println(e.getMessage()); 
            }
        }
    }
    
}
