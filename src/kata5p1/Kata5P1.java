/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

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
    }
    
}
