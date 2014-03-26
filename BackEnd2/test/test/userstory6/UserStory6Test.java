/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.userstory6;

import control.NewSessionBean;
import electivexp.ElectiveManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.Person;
import model.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Integer;

/**
 *
 * @author Thomas
 */
public class UserStory6Test {
    NewSessionBean manager = lookupNewSessionBeanBean();
    ArrayList<Student> students = new ArrayList<>();
    
    public UserStory6Test() {
    }
    // Data som skal generes før hele testen
    @BeforeClass
    public static void setUpClass() {
        Person p = new Person("to", "je", 123, "toje@cph.dk", "eheh");
    }
    // Hvis der skal slettes noget efter hele testen er kørt
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    // Bliver kørt før hver test
    @Before
    public void setUp() {
        
    }
    // Køres efter hver test
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void Test() 
     {
         //hehehehe
         int subjectId=2;
         ArrayList<Integer> studentIds = new ArrayList<>();
         manager.addSudentsInSubject(studentIds,subjectId);
     }

    private NewSessionBean lookupNewSessionBeanBean() {
        try {
            Context c = new InitialContext();
            return (NewSessionBean) c.lookup("java:global/BackEnd2/NewSessionBean!control.NewSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}