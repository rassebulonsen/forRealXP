/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.ElectiveSubject;
import model.Student;
import model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class UserStory3Test {
    
            
//        Person stu;
    Student stu;
//    ElectiveSubject elec = new ElectiveSubject("","",);
    
    public UserStory3Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       stu = new Student(1, "Thomas","JepsenMoneymaker",11,"jep@cph.dk","123", 0,0,0,0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMakeChoice() {
        stu.setFirstPri1(3);
        stu.setFirstPri2(5);
        stu.setSecondPri1(7);
        stu.setSecondPri2(9);
        
        assertEquals(3, stu.getFirstPri1ElectiveSubjID());
        assertEquals(5, stu.getFirstPri2ElectiveSubjID());
        assertEquals(7, stu.getSecondPri1ElectiveSubjID());
        assertEquals(9, stu.getSecondPri2ElectiveSubjID());
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}