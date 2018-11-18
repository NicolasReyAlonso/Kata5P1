/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiper
 */
public class CreateDataBase {
    public static void create(String filename){
        String url = "jdbc:sqlite:" + filename;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) { 
                DatabaseMetaData meta = conn.getMetaData(); 
                System.out.println("El driver es " + meta.getDriverName()); 
                System.out.println("Se ha creado una nueva BD."); 
            } 
        }catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }        
    }
    public static void addTable(String URL, String Name){
        String url = "jdbc:sqlite:"+URL;
        String sql = "CREATE TABLE IF NOT EXISTS " + Name + " (\n" 
                + " id integer PRIMARY KEY AUTOINCREMENT,\n" 
                + " direccion text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
