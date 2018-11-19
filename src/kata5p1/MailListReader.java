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


import java.io.File;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**

 *

 * @author nicolasreyalonso

 */

public class MailListReader{

    public static List<String>read(String fileName){

        List<String> toRet = new ArrayList<String>();

        File b = new File(fileName);

       

        try{

        Scanner a = new Scanner(b);

        String c = "";
        String regex = "@([[a-zA-Z]{2}.]+).*[a-zA-Z]+";
        Pattern pat = Pattern.compile(regex);
        Matcher k;
        while(a.hasNextLine()){
        
            c = a.nextLine();
            k = pat.matcher(c);

            if(k.find()){
                

                toRet.add(c);

            }

        }

        

        }catch(Exception e){

            System.out.print("File not Found");

        }

        

        

        

        return toRet;

    }

}
