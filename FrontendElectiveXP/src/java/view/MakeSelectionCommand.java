/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.dto.ElectiveSubjectSummary;
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

        for (ElectiveSubjectSummary es : subjects) {

            System.out.println(request.getParameter(es.getId() + ""));
        }

        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
}
