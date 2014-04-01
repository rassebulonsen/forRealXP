/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.dto.StudentListInSubjectDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas
 */
public class StudentListCommand extends TargetCommand{

    public StudentListCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<StudentListInSubjectDTO> poolAList = Factory.getInstance().getManager().getStudentListInSubjectsFromPoolA();
        Collection<StudentListInSubjectDTO> poolBList = Factory.getInstance().getManager().getStudentListInSubjectsFromPoolB();
        request.setAttribute("poolAList", poolAList);
        request.setAttribute("poolBList", poolBList);
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
