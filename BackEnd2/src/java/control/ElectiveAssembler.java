/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import electivexp.dto.*;
import java.util.ArrayList;
import java.util.Collection;
import model.Electivesubject;
import model.Student;

/**
 *
 * @author Thomas
 */
public class ElectiveAssembler {
    
    public static StudentFirstRoundDetail createSudentDetail(Student student) {
        if (student == null) return null;
        StudentFirstRoundDetail detail = new StudentFirstRoundDetail(
                student.getStuid(), 
                student.getFirstpri1electivesubjid(), 
                student.getFirstpri2electivesubjid(), 
                student.getSecondpri1electivesubjid(), 
                student.getSecondpri2electivesubjid());
        return detail;
    }
    
    public static ElectiveSubjectSummary createElectiveSummary(Electivesubject subject) {
        return new ElectiveSubjectSummary(subject.getSubjectid(), subject.getName());
    }
    
    public static Collection<ElectiveSubjectSummary> createElectiveSummaries(Collection<Electivesubject> subjects) {
        Collection<ElectiveSubjectSummary> summaries = new ArrayList<>();
        for (Electivesubject subject : subjects) {
            summaries.add(createElectiveSummary(subject));
        }
        
        return summaries;
        
    }
}
