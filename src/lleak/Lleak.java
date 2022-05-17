/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak;


import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lleak.helpers.*;

/**
 *
 * @author tassy
 */
public class Lleak {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<String> readFile(String path) {
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
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Lleak.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return arr;

    }

    public static void main(String[] args) {

//        BoundsReader br = new BoundsReader(rootDir + cr.getBounds());
//        Map<Integer, String> y = br.getBoundFiles();
//
//        for (Map.Entry entry : y.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());
//        }
        String rootDir = "D:/example/";

        ConfReader cr = new ConfReader(rootDir + "mainconf.txt");

        System.out.println("\n--------Timescen-----------");

        TimeReader tr = new TimeReader(rootDir + cr.getTime());
        ArrayList<TimeInterval> timeIntervals = tr.getTimeIntervals();
        System.out.println("Dur:" + tr.getSimulationDuration());
        System.out.println("Nt:" + tr.getNt());
        timeIntervals.forEach(s -> System.out.println(s.toString()));

        System.out.println("\n--------ChanProf-----------");
        ChanProfReader cpr = new ChanProfReader(rootDir + cr.getChan());
        ArrayList<ChanProf> al = cpr.getChans();
        System.out.println("N:" + cpr.getN());
        al.forEach(c -> System.out.println(c.toString()));

        System.out.println("\n--------ch1.txt-----------");
        ChanTxtReader ctr = new ChanTxtReader(rootDir + cpr.getChans().get(0).getFile());
        System.out.println(ctr.toString());

        System.out.println("\n--------geom1.txt-----------");
        GeomReader gr = new GeomReader(rootDir + ctr.getGeom());
        ArrayList<SegmentGeom> segmentGeoms = gr.getSegmentGeoms();
        System.out.println("N:" + gr.getNSegments());
        segmentGeoms.forEach(c -> System.out.println(c.toString()));
        
        
        //System.out.println("--------ch1-----------");
        //ChanOutfileReader cor = new ChanOutfileReader(rootDir + ctr.getOutfile());
        //System.out.println(cor.getResults().get(0).toString());

        //Globals.setRPaths("D:\\Program Files\\R\\R-4.1.2\\bin\\Rscript.exe", "D:\\Program Files\\R\\R-4.1.2\\bin\\R.exe");
//        ProcessBuilder processBuilder = new ProcessBuilder("script.bat", "\"D:/Program Files/R/R-4.1.2/bin/Rscript.exe\"","D:/NetBeansProjects/lleakres/example/ch1", "C:/Users/tassy/Desktop/metaNew.csv", "0.1, 0.2, 0.5", "u, p, eps1", "d");
//        Process p;
//        BufferedReader br = null;
//        try {
//            p = processBuilder.start();
//            p.waitFor();
//            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                
//            }
//            System.out.println("Done");
//        } catch (IOException ex) {
//            Logger.getLogger(Lleak.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Lleak.class.getName()).log(Level.SEVERE, null, ex);
//        }

        

    }
}
