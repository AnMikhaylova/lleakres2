/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lleak.Lleak;

/**
 *
 * @author tassy
 */
public class DefaultReader {
    protected ArrayList<String> fileInf = null;
    
    
    public void readFile (String path) {
        FileReader fr = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
             
            fr = new FileReader(path);
            Scanner scan = new Scanner(fr);
            String s;
            
            while (scan.hasNextLine()) {
                s = scan.nextLine();
                arr.add(s);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lleak.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Lleak.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
        fileInf = arr;  
    
    }

    protected DefaultReader() {
    }

    public ArrayList<String> getFileInf() {
        return fileInf;
    }        
    

    

    

    
    
    
    
    
    
}
