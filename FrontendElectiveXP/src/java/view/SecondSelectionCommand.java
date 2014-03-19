/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.dto.ElectiveSubjectSummary;
import java.util.ArrayList;
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
        
        ArrayList<ElectiveSubjectSummary> poolA = new ArrayList<>();
        ArrayList<ElectiveSubjectSummary> poolB = new ArrayList<>();
        
        poolA = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolASubjects();
        poolB = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolBSubjects();
        
        System.out.println(poolA.size());
        System.out.println(poolB.size());
       request.setAttribute("PoolA", poolA);
       request.setAttribute("PoolB", poolB);
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
