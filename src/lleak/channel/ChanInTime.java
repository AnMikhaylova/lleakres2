/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak.channel;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс для представления состояния канала в заданный момент времени
 *
 * @author tassy
 */
public class ChanInTime {
    private ArrayList<ChanCol> varlist;
    private double time;
    private String stime;
    private ArrayList<double[]> columns; // список массивов значений столбцов, кроме первого (время) и второго (индекс точки)
    private Map<String, double[]> namedcols; // для поиска по ключу - имени переменной

    /**
     * Конструктор класса
     *
     * @param nx количество точек по х
     * @param stime время (строка)
     * @param varlist список столбцов
     */
    public ChanInTime(int nx, String stime, ArrayList<ChanCol> varlist) {
        this.stime = stime;
        this.varlist = varlist;
        time = Double.parseDouble(stime);
        int nc = varlist.size()-2; // первые два столбца - t и j - игнорируются
        columns = new ArrayList<>();
        namedcols = new TreeMap<>();
        for(int i=0;i<nc;++i){
            double [] da = new double[nx];
            columns.add(da);
            // помещаем в словарь ссылку на массив с ключом имя переменной
            namedcols.put(varlist.get(i+2).getVarname(), da);
        }
    }
    
    /**
     * Чтение данных из строки с заданным индексом
     * @param index индекс 
     * @param line строка из исходного файла
     */
    public void readFromLine(int index, String line){
        String[] arr = line.trim().split("\\s+");
        for(int i=2;i<varlist.size();++i){
            columns.get(i-2)[index] = Double.parseDouble(arr[i]);
        }
    }

    public ArrayList<ChanCol> getVarlist() {
        return varlist;
    }

    public double getTime() {
        return time;
    }

    public String getStime() {
        return stime;
    }

    public ArrayList<double[]> getColumns() {
        return columns;
    }

    public Map<String, double[]> getNamedcols() {
        return namedcols;
    }

}
