/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.ElectiveManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas
 */
public class setupPoolCommand extends TargetCommand {

    public setupPoolCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        ElectiveManager manager = Factory.getInstance().getManager();
        request.setAttribute("fagliste", manager.getSubjects());
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
