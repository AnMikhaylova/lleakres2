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
public class GeomReader extends DefaultReader {

    private int nSegments = 0;
    ArrayList<SegmentGeom> segmentGeoms = new ArrayList<>();

    public GeomReader() {
    }

    public GeomReader(String path) {
        readFile(path);
        String[] split = fileInf.get(0).trim().split("\\s+");
        nSegments = Integer.valueOf(split[0]);
        setSegmentGeoms();

    }

    private void setSegmentGeoms() {
        if (fileInf == null) {
            System.out.println("Error");
        } else {

            for (int i = 1; i <= nSegments; i++) {
                String[] split = fileInf.get(i).trim().split("\\s+");
                double w = Double.valueOf(split[0]);
                double h = Double.valueOf(split[1]);
                double s = Double.valueOf(split[2]);
                double xi = Double.valueOf(split[3]);
                int typ = Integer.valueOf(split[4]);
                double p1 = Double.valueOf(split[5]);
                int p2 = Integer.valueOf(split[6]);
                int code = Integer.valueOf(split[7]);
                int pump = Integer.valueOf(split[8]);

                SegmentGeom sg = new SegmentGeom(w, h, s, xi, typ, p1, p2, code, pump);
                segmentGeoms.add(sg);

            }
        }

    }

    public int getNSegments() {
        return nSegments;
    }

    public ArrayList<SegmentGeom> getSegmentGeoms() {
        return segmentGeoms;
    }

    public ArrayList<Double> getChanCoord() {
        ArrayList<SegmentGeom> sg = segmentGeoms;
        ArrayList<Double> arr = new ArrayList<>();
        double a = 0;
        arr.add(a);

        for (SegmentGeom s : sg) {
            int count = (int) (s.getW() / s.getH()); //всегда ли int?
            for (double i = 0; i < count; i ++) {
                a += s.getH();
                arr.add(a);
            }
        }

        return arr;
    }
    
    public int getNx(){
        int nx = 0;
        for (int i = 0; i < nSegments; i++)
            nx += segmentGeoms.get(i).getW() / segmentGeoms.get(i).getH();
        
        return nx;
    }

}
