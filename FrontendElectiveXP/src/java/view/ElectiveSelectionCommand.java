/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas
 */
public class ElectiveSelectionCommand extends TargetCommand {

    public ElectiveSelectionCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        request.setAttribute("subjects", Factory.getInstance().getManager().getSubjects());
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
