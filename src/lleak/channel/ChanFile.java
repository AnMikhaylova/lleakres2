/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lleak.channel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс, представляющий данные из расчетного файла в виде массива (списка) состояний в каждый момент времени
 * @author tassy
 */
public class ChanFile {
    private final String chname;
    private ArrayList<ChanCol> columns; // метаданные по столбцам
    private int nt; // количество шагов по времени
    private int nx; // количество точек по х
    private int nc; // количество столбцов
    private ArrayList<ChanInTime> data;

    public ChanFile(int nt, int nx, String chname, ArrayList<ChanCol> columns) {
        this.chname = chname;
        this.columns = columns;
        this.nt = nt;
        this.nx = nx;
        this.nc = columns.size();
        data = new ArrayList<>(nt); // инициализируем по количеству шагов по времени
        readChan();
    }
    
    /**
     *  Чтение файла, заполнение структур данных
     */
    private void readChan(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(chname));
            String line;
            // цикл по количеству шагов по времени
            for(int i=0; i<nt; ++i){
                // первая строка для каждого шага - для определения времени
                line = br.readLine();
                String[] arr = line.trim().split("\\s+");
                ChanInTime cp = new ChanInTime(nx, arr[0], columns);
                cp.readFromLine(0, line);
                for(int j=1; j<nx; ++j){
                    line = br.readLine();
                    cp.readFromLine(j, line);
                }
                data.add(cp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChanFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChanFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(br != null)try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ChanFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getChname() {
        return chname;
    }

    public ArrayList<ChanCol> getColumns() {
        return columns;
    }

    public int getNt() {
        return nt;
    }

    public int getNx() {
        return nx;
    }

    public int getNc() {
        return nc;
    }

    public ArrayList<ChanInTime> getData() {
        return data;
    }
    
}
