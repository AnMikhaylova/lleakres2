/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak.channel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tassy
 */
public class ChanCol {

    private int ic; // индекс столбца
    private String varname; // идентификатор 
    private String fullname; // полное название
    private static String defaultCSV = "src"+ File.separator + "data" + File.separator + "meta.csv";

    public ChanCol() {
    }

    public ChanCol(int ic, String varname, String fullname) {
        this.ic = ic;
        this.varname = varname;
        this.fullname = fullname;
    }

    public int getIc() {
        return ic;
    }

    public void setIc(int ic) {
        this.ic = ic;
    }

    public String getVarname() {
        return varname;
    }

    public void setVarname(String varname) {
        this.varname = varname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public static ArrayList<ChanCol> readCSV(String path) {
        BufferedReader br = null;
        String line;
        ArrayList<ChanCol> arr = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                ChanCol chanCol = new ChanCol(Integer.valueOf(data[0]), data[1], data[2]);
                arr.add(chanCol);

            }
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл с метаданными не найден\nБудет использован файл по умолчанию",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            //обработка исключения FileNotFoundException
            try {
                br = new BufferedReader(new FileReader(ChanCol.defaultCSV));
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    ChanCol chanCol = new ChanCol(Integer.valueOf(data[0]), data[1], data[2]);
                    arr.add(chanCol);

                }

            } catch (FileNotFoundException ex1) {
                JOptionPane.showMessageDialog(null, "Файл не найден",
                "Ошибка", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ChanCol.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода/вывода",
                "Ошибка", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ChanCol.class.getName()).log(Level.SEVERE, null, ex1);
            }

            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка ввода/вывода",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ChanCol.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка ввода/вывода",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ChanCol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return arr;

    }
}
