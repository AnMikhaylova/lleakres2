/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lleak.helpers;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tassy
 */
public class TimeReaderTest {
    
    public TimeReaderTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNt() {
        System.out.println("getNt");
        TimeReader instance = new TimeReader("D:/example/timescen.txt");
        int expResult = 2;
        int result = instance.getNt();
        assertEquals(expResult, result);
    }

    

    @Test
    public void testGetSimulationDuration() {
        System.out.println("getSimulationDuration");
        TimeReader instance = new TimeReader();
        double expResult = 0.0;
        double result = instance.getSimulationDuration();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPointsInTime() {
        System.out.println("getPointsInTime");
        TimeReader instance = new TimeReader();
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getPointsInTime();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNSteps() {
        System.out.println("getNSteps");
        TimeReader instance = new TimeReader();
        int expResult = 1000;
        int result = instance.getNSteps();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
