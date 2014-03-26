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
class CreateNewSubjectCommand extends TargetCommand{

    public CreateNewSubjectCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        String newSubjectName = request.getParameter("newSubjectName");
        String newSubjectDescription = request.getParameter("newSubjectDescription");
        
        Factory.getInstance().getManager().insertElectiveSubject(newSubjectName, newSubjectDescription);
        
        request.setAttribute("lool", "The new subject: " + newSubjectName + " is in the database.");
        System.out.println(newSubjectName);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
