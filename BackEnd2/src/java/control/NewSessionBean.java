/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import electivexp.ElectiveManager;
import electivexp.dto.ElectiveSubjectSummary;
import electivexp.dto.PrioritiesInfoDTO;
import static control.ElectiveAssembler.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Electivesubject;
import model.Student;

/**
 *
 * @author Thomas
 */
@Stateless
public class NewSessionBean implements ElectiveManager {
    
    @PersistenceContext(unitName = "BackEnd2PU")
    private EntityManager em;

        private ArrayList<ElectiveSubjectSummary> electivSubjects = new ArrayList<>();

    @Override
    public void makeChoise(int stuId, int firstPri1ElectiveSubjID, int firstPri2ElectiveSubjID, int second1ElectiveSubjID, int second2Pri2ElectiveSubjID) {
        Student stu = em.find(Student.class, stuId);
        stu.setFirstpri1electivesubjid(firstPri1ElectiveSubjID);
        stu.setFirstpri2electivesubjid(firstPri2ElectiveSubjID);
        stu.setSecondpri1electivesubjid(second1ElectiveSubjID);
        stu.setSecondpri2electivesubjid(second2Pri2ElectiveSubjID);
    }

    @Override
    public Collection<ElectiveSubjectSummary> getSubjects() {
        Collection<Electivesubject> subjects = em.createNamedQuery("Electivesubject.findAll").getResultList();
        System.err.println("#Elective = " + subjects.size());
        return createElectiveSummaries(subjects);
        
    }

    @Override
    public void savePools(ArrayList<Integer> poolAArray, ArrayList<Integer> poolBArray) {
        
//        for(int a = 0;a<poolAArray.size();a++)
//        {
//             int fag=0;
//            for(int i =0;i< electivSubjects.size();i++)
//            {
//                if(poolAArray.get(a)==electivSubjects.get(i).getId())
//                {
//                    fag=i;
//                }
//            }
//            poolA.addSubject(electivSubjects.get(fag));
//        }
//        for(int b = 0;b<poolBArray.size();b++)
//        {
//            int fag=0;
//            for(int i =0;i< electivSubjects.size();i++)
//            {
//                if(poolBArray.get(b)==electivSubjects.get(i).getId())
//                {
//                    fag=i;
//                }
//            }
//            poolB.addSubject(electivSubjects.get(fag));
//        }    
    }

    @Override
    public ArrayList<PrioritiesInfoDTO> getStudentPoolSatisfaction(ArrayList<Integer> poolAArray, ArrayList<Integer> poolBArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

}
