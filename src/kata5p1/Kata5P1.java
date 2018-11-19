/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hiper
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     */
    
    //C:\Users\hiper\Documents\NetBeansProjects\Kata5P1
    public static void main(String[] args) {
        // TODO code application logic here
        SelectApp app = new SelectApp("C:\\Users\\hiper\\Documents\\NetBeansProjects\\Kata5P1\\PRUEBA.db");
        app.SelectAll("SELECT * FROM People");
        CreateDataBase.create("C:\\Users\\hiper\\Documents\\NetBeansProjects\\Kata5P1\\mail.db");
        CreateDataBase.addTable("C:\\Users\\hiper\\Documents\\NetBeansProjects\\Kata5P1\\mail.db"
               ,"email");
        SelectApp app2 =  new SelectApp("C:\\Users\\hiper\\Documents\\NetBeansProjects\\Kata5P1\\mail.db");
        List<String> Mail = MailListReader.read("C:\\Users\\hiper\\Documents\\NetBeansProjects\\Kata5P1\\email.txt");
        Iterator iter = Mail.iterator();
        while (iter.hasNext()){
            app2.insert((String)iter.next(), "INSERT INTO email(direccion) VALUES(?)");
        }
        app2.SelectAll("SELECT * FROM email");
    }
    
}
