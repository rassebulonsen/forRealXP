/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import control.NewSessionBean;
import electivexp.ElectiveManager;
import electivexp.dto.ElectiveSubjectSummary;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
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
public class NewEmptyJUnitTest {
    ElectiveManager newSessionBean = lookupNewSessionBeanRemote();
            ElectiveSubjectSummary sum;
        ArrayList<ElectiveSubjectSummary> array = new ArrayList<>();
    public NewEmptyJUnitTest() {
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
//@Test
//public void testAddNumbers() throws Exception {
//    System.out.println("addNumbers");
//    String numberA = "Eeee";
//    String numberB = "eeee";
//    ElectiveSubjectSummary sum = null;
//    ArrayList<ElectiveSubjectSummary> array = new ArrayList();
//
//    // Create a properties map to pass to the embeddable container:
//    Map<String, Object> properties = new HashMap<String, Object>();
//    // Use the MODULES property to specify the set of modules to be initialized,
//    // in this case a java.io.File 
//    properties.put(EJBContainer.MODULES, new File("build/jar"));
//
//    // Create the container instance, passing it the properties map:
//    EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
//
//    // Create the instance using the container context to look up the bean 
//    // in the directory that contains the built classes
//    NewSessionBean instance = (NewSessionBean) lookupNewSessionBeanRemote();
//
//    String expResult = "eeee";
//
//    // Invoke the addNumbers method on the bean instance:
//    
//    instance.insertElectiveSubject(numberA, numberB);
//    
//        array = (ArrayList<ElectiveSubjectSummary>) instance.getSubjects();
//
//        for(ElectiveSubjectSummary es : array) {
//            if (es.getName().equals(numberB)) {
//                sum = es;
//            }
//        }
//    assertEquals(expResult, sum.getName());
//
//    // Close the embeddable container:
//    container.close();
//}
    
    @Test
public void testInsertElectiveSubject() throws NamingException {
    System.out.println("addNumbers");
    String numberA = "Java";
    String numberB = "Java";
    EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    NewSessionBean instance = (NewSessionBean)container.getContext().lookup("java:global/BackEnd2/NewSessionBean!electivexp.ElectiveManager");
    String expResult = "Java";
    instance.insertElectiveSubject(numberA, numberB);
    
        array = (ArrayList<ElectiveSubjectSummary>) instance.getSubjects();

        for(ElectiveSubjectSummary es : array) {
            if (es.getName().equals(numberB)) {
                sum = es;
            }
        }
    assertEquals(expResult, sum.getName());
    container.close();
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
