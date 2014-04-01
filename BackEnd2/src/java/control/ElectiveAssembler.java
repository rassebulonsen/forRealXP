/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import electivexp.dto.*;
import java.util.ArrayList;
import java.util.Collection;
import model.Electivesubject;
import model.Pool;
import model.Student;
import model.StudentRound2;

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
    public static StudentInfoDTO createStudentInfoDTO(Student student)
    {
        if (student == null) return null;
        return new StudentInfoDTO(
                student.getStuid(),
                student.getPerson().getFname(), 
                student.getPerson().getLname(), 
                student.getFirstpri1electivesubjid()+"", 
                student.getFirstpri2electivesubjid()+"", 
                student.getSecondpri1electivesubjid()+"", 
                student.getSecondpri2electivesubjid()+""
                );
    }
    public static StudentInfoDTO createStudentInfoDtoWithRound2(Student student, StudentRound2 s2,Collection<Electivesubject> subjects)
    {
        if(student == null || s2 ==null) return null;
        String first1Name="",first2Name="",second1Name="",second2Name="";
                for(Electivesubject subject : subjects)
                {
                    if(subject.getSubjectid()== s2.getFirstpripoolaelectivesubjid())
                    {
                        first1Name=subject.getName();
                    }
                    if(subject.getSubjectid()== s2.getFirstpripoolb1electivesubjid())
                    {
                        first2Name=subject.getName();
                    }
                    if(subject.getSubjectid()== s2.getSecondpripoolaelectivesubjid())
                    {
                        second1Name=subject.getName();
                    }
                    if(subject.getSubjectid()== s2.getSecondpripoolbelectivesubjid())
                    {
                        second2Name=subject.getName();
                    }
                }
        return new StudentInfoDTO(
                student.getStuid(), 
                student.getPerson().getFname(),
                student.getPerson().getLname(), 
                first1Name, 
                first2Name, 
                second1Name, 
                second2Name
                );
     
    }
}
