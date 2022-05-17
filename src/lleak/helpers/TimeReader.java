/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak.helpers;

import java.util.ArrayList;

/**
 *
 * @author tassy
 */
public class TimeReader extends DefaultReader {

    private int nt = 0;
    private ArrayList<TimeInterval> timeIntervals = new ArrayList<>();

    public TimeReader() {

    }

    public TimeReader(String path) {
        readFile(path);
        nt = Integer.valueOf(fileInf.get(0));
        setTimeIntervals();

    }

    private void setTimeIntervals() {
        if (fileInf == null) {
            System.out.println("Error");
        } else {

            for (int i = 1; i <= nt; i++) {
                String[] split = fileInf.get(i).split("\\s+");
                double d = Double.parseDouble(split[1].trim());
                TimeInterval ti = new TimeInterval(Integer.valueOf(split[0]), d, Double.valueOf(split[2]));
                timeIntervals.add(ti);
            }
        }
    }

    public int getNt() {
        return nt;
    }

    public ArrayList<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }

    public double getSimulationDuration() {
        if (timeIntervals.isEmpty()) {
            return 0;
        } else {
            double duration = 0;
            for (int i = 0; i < timeIntervals.size(); i++) {
                duration += timeIntervals.get(i).getIntervalDuration();
            }
            return duration;
        }
    }

    public ArrayList<Double> getPointsInTime() {

        ArrayList<TimeInterval> ti = timeIntervals;
        ArrayList<Double> arr = new ArrayList<>();
        double a = 0;
        arr.add(a);

        for (TimeInterval t : ti) {
            for (int i = 0; i < t.getNstep(); i++) {
                a += t.getTau();
                arr.add(a);
            }
        }

        return arr;
    }
    
    public int getNSteps(){
        int Nstep = 0;
        for (int i = 0; i < nt; i++)
            Nstep += timeIntervals.get(i).getNstep();
        return Nstep;
        
    }

}
