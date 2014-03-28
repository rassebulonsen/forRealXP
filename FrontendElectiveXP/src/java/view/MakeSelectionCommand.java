/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.dto.ElectiveSubjectSummary;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

/**
 *
 * @author Rasmus
 */
class MakeSelectionCommand extends TargetCommand {

    public MakeSelectionCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        Collection<ElectiveSubjectSummary> subjects = Factory.getInstance().getManager().getSubjects();
//        ArrayList<Integer> subjectIds = new ArrayList<>();

        for (ElectiveSubjectSummary es : subjects) {
//            System.out.println(request.getParameter(es.getId() + ""));
//            subjectIds.add(es.getId());
            if(request.getParameter(es.getId() + "") != null){
            int subjectId = Integer.parseInt(request.getParameter(es.getId() + ""));
                
            Factory.getInstance().getManager().updateElectiveSubjectRound1(subjectId, "yes");
            }
            
        }
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
}
