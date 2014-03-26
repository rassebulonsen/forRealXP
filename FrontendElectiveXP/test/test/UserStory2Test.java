/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import electivexp.ElectiveManager;
import electivexp.dto.ElectiveSubjectSummary;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class UserStory2Test {
    ElectiveManager newSessionBean = lookupNewSessionBeanRemote();
    
    
    
    public UserStory2Test() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testInsertElectiveSubject() {
        String name = "JavaScript";
       newSessionBean.insertElectiveSubject(name, "Learn JavaScript");
       //int size = newSessionBean.getSubjects().size()+1;
       ElectiveSubjectSummary e = newSessionBean.getSubject(name);
       assertNotNull(e);
    }

    private ElectiveManager lookupNewSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ElectiveManager) c.lookup("java:global/BackEnd2/NewSessionBean!electivexp.ElectiveManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}