/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import electivexp.dto.ElectiveSubjectSummary;
import electivexp.dto.PrioritiesInfoDTO;
import electivexp.dto.StudentInfoDTO;
import java.util.ArrayList;
import java.util.Collection;
import model.ElectiveSubject;
import model.Priorities;
import model.Student;

/**
 *
 * @author Thomas
 */
public class DummyBankAssembler {
    
public static ElectiveSubjectSummary createElectiveSummary(ElectiveSubject subject) { 
    return new ElectiveSubjectSummary(subject.getSubjectId(), subject.getName()); }
    

public static Collection<ElectiveSubjectSummary> createElectiveSummaries(Collection<ElectiveSubject> subjects)
    {
        Collection<ElectiveSubjectSummary> summaries = new ArrayList<>();
        for (ElectiveSubject subject : subjects) {
            summaries.add(createElectiveSummary(subject));
        }
        return summaries;
    }
public static ArrayList<PrioritiesInfoDTO> createPriorityDTO(ArrayList<Priorities> prio,ArrayList<ElectiveSubject> electivSubjects)
{
    ArrayList<PrioritiesInfoDTO> pid = new ArrayList<>();
    for(int i =0 ; i< prio.size();i++)
    {
        PrioritiesInfoDTO pi= new PrioritiesInfoDTO(prio.get(i).getName());
        for(int j=0;j<prio.get(i).getStudents().size();j++)
        {
            Student s = prio.get(i).getStudents().get(j);
            String first1Name="",first2Name="",second1Name="",second2Name="";
            for(int k =0;k< electivSubjects.size();k++)
            {
                if(electivSubjects.get(k).getSubjectId()== s.getFirstPri1ElectiveSubjID())
                {
                    first1Name=electivSubjects.get(k).getName();
                }
                if(electivSubjects.get(k).getSubjectId()== s.getFirstPri2ElectiveSubjID())
                {
                    first2Name=electivSubjects.get(k).getName();
                }
                if(electivSubjects.get(k).getSubjectId()== s.getSecondPri1ElectiveSubjID())
                {
                    second1Name=electivSubjects.get(k).getName();
                }
                if(electivSubjects.get(k).getSubjectId()== s.getSecondPri2ElectiveSubjID())
                {
                    second2Name=electivSubjects.get(k).getName();
                }
            }
            pi.addStudents(new StudentInfoDTO(s.getID(),s.getFName() , s.getLName(),first1Name,first2Name,second1Name,second2Name));
        }
        pid.add(pi);
    }
    return pid;
}
}
