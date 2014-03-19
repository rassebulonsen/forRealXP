package test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import backend.DummyBackend;
import electivexp.dto.PrioritiesInfoDTO;
import model.Priorities;
import model.PoolS;
import java.util.ArrayList;
import model.ElectiveSubject;
import model.Teacher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristijan
 */
public class Userstory4Test {
    
    public Userstory4Test() {
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
    
    @Test
    public void makePoolTest() {
        PoolS pool = new PoolS();
        assertNotNull(pool);
    }
    
    @Test
    public void addSubjectToPoolTest() {
        PoolS pool = new PoolS();
        Teacher t1 = new Teacher(1, "Torben", "?", 111, "tor@cph.dk", "cocio2013");
        ElectiveSubject es = new ElectiveSubject(7,"C#","C Sharp", t1);
        pool.addSubject(es);
        int size = pool.getSize();
        assertEquals(1, size);        
    }
    
    @Test
    public void studentStatisticTest() {
        
        DummyBackend des = new DummyBackend();
        
        ArrayList<Integer> poolA = new ArrayList<>();
        ArrayList<Integer> poolB = new ArrayList<>();
        poolA.add(7);
        poolA.add(8);
        poolB.add(9);
        poolB.add(10);

        ArrayList<PrioritiesInfoDTO> prio = des.getStudentPoolSatisfaction(poolA,poolB);

        assertNotNull(prio);
    }
}