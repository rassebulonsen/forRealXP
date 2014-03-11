/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import backend.DummyBackend;
import java.util.HashMap;
import electivexp.ElectiveManager;

/**
 *
 * @author Thomas
 */
public class Factory {
    private static Factory instance = null;
    
    private final HashMap<String, Command> commands = new HashMap<>();

    private ElectiveManager manager = new DummyBackend();
    
    public Factory() {
            commands.put("main", new TargetCommand("main.jsp"));
            commands.put("subject", new FirstSelectionCommand("round1.jsp"));
            commands.put("makeChoises_command", new MakeChoisesCommand("round1End.jsp"));
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
        
}
