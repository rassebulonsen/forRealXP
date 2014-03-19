/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import electivexp.ElectiveManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Thomas
 */
public class Factory {
    ElectiveManager manager = lookupNewSessionBeanRemote();
    private static Factory instance = null;
    
    private final HashMap<String, Command> commands = new HashMap<>();

//    private ElectiveManager manager = new DummyBackend();ct
    
    
    public Factory() {
            commands.put("main", new TargetCommand("main.jsp"));
            commands.put("subject", new FirstSelectionCommand("round1.jsp"));
            commands.put("makeChoises_command", new MakeChoisesCommand("round1End.jsp"));
            commands.put("makeChoises2_Command", new MakeChoises2Command("round2End.jsp"));
            commands.put("make_pool_subject_selections", new SecondSelectionCommand("round2.jsp"));
            commands.put("makePool", new setupPoolCommand("pool.jsp"));
    }
    
    public static Factory getInstance(){
        if (instance == null) {
            instance = new Factory();
        }
         return instance;
    }
    
        public Command findCommand(String key) {
        if (key == null) key = "main";
        return commands.get(key);
        }

    public ElectiveManager getManager() {
        return manager;
    }

    public void setManager(ElectiveManager manager) {
        this.manager = manager;
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
