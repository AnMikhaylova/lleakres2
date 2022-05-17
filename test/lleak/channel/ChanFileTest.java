/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package lleak.channel;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oam
 */
public class ChanFileTest {
    
    public ChanFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readChan method, of class ChanFile.
     */
    @Test
    public void testReadChan() {
        System.out.println("readChan");
        ArrayList<ChanCol> columns = new ArrayList<>();
        columns.add(new ChanCol(0, "t", "Время"));
        columns.add(new ChanCol(1, "j", "Индекс"));
        columns.add(new ChanCol(2, "x", "Координата"));
        columns.add(new ChanCol(3, "u", "Скорость"));
        ChanFile instance = new ChanFile(1001, 201, "/home/oam/ch1", columns);
        int index = 1000;
        double[] res = instance.getData().get(index).getColumns().get(1);
        System.out.println(res[0]);    }

}
