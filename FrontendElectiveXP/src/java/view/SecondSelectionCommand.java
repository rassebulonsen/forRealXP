/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rasmus
 */
public class SecondSelectionCommand extends TargetCommand{

    public SecondSelectionCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
       request.setAttribute("poolA", Factory.getInstance().getManager().getPoolASubjects());
       request.setAttribute("PoolB", Factory.getInstance().getManager().getPoolBSubjects());
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
