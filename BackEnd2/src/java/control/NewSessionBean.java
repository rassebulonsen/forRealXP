/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import electivexp.ElectiveManager;
import electivexp.dto.ElectiveSubjectSummary;
import electivexp.dto.PrioritiesInfoDTO;
import static control.ElectiveAssembler.*;
import electivexp.dto.StudentInfoDTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Electivesubject;
import model.Pool;
import model.Student;
import model.StudentRound2;

/**
 *
 * @author Thomas
 */
@Stateless
public class NewSessionBean implements ElectiveManager {
    
    @PersistenceContext(unitName = "BackEnd2PU")
    private EntityManager em;

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
        Pool poolA = em.find(Pool.class, "A");
        Collection<Electivesubject> poolASubjects= new ArrayList<>();
        Collection<Electivesubject> poolBSubjects= new ArrayList<>();
        Collection<Electivesubject> subjects = em.createNamedQuery("Electivesubject.findAll").getResultList();
        for(int a = 0;a<poolAArray.size();a++)
        {
            for(Electivesubject es: subjects)
            {
                if(poolAArray.get(a).equals(es.getSubjectid()))
                {
                    poolASubjects.add(es);
                    es.setPoolCollection(java.util.Collections.singleton(poolA));
                }
            }
        }
        Pool poolB = em.find(Pool.class, "B");
        for(int b = 0;b<poolBArray.size();b++)
        {
            for(Electivesubject es: subjects)
            {
                if(poolBArray.get(b).equals(es.getSubjectid()))
                {
                     poolBSubjects.add(es);
                     es.setPoolCollection(java.util.Collections.singleton(poolB));
                }
            }
        }
        poolA.setElectivesubjectCollection(poolASubjects);
        poolB.setElectivesubjectCollection(poolBSubjects);
//        em.persist(poolA);
//        em.persist(poolB);
//        }    
    }
    @Override
    public ArrayList<PrioritiesInfoDTO> getStudentPoolSatisfaction(ArrayList<Integer> poolAArray, ArrayList<Integer> poolBArray) {
        Pool poolA = new Pool("X");
        
        Collection<Electivesubject> poolASubjects= new ArrayList<>();
        Collection<Electivesubject> poolBSubjects= new ArrayList<>();
        //delete later
        for(int i = 0;i<poolAArray.size();i++)
        {
            System.out.println(poolAArray.get(i));
        }
        for(int i = 0;i<poolBArray.size();i++)
        {
            System.out.println(poolBArray.get(i));
        }
            //to here
        Collection<Electivesubject> subjects = em.createNamedQuery("Electivesubject.findAll").getResultList();
        System.out.println(subjects.size());
        System.out.println("PoolA");
        for(int a = 0;a<poolAArray.size();a++)
        {
            for(Electivesubject es: subjects)
            {
                System.out.println("poolA aryya "+poolAArray.get(a));
                System.out.println("subject id "+es.getSubjectid());
//                if(poolAArray.get(a)==es.getSubjectid())
//                {
//                    poolA.addSubject(es);
//                    System.out.println(es.getName());
//                }
                if((poolAArray.get(a)).equals(es.getSubjectid()))
                {
                    poolASubjects.add(es);
                }
                System.out.println("Done");
            }
        }
        //System.out.println(poolA.getElectivesubjectCollection().size());
        Pool poolB = new Pool("Y");
        System.out.println("PoolB");
        for(int b = 0;b<poolBArray.size();b++)
        {
            for(Electivesubject es: subjects)
            {
                if(poolBArray.get(b).equals(es.getSubjectid()))
                {
                     poolBSubjects.add(es);
                     System.out.println(es.getName());
                }
            }
        }
       // System.out.println(poolB.getElectivesubjectCollection().size());
        poolA.setElectivesubjectCollection(poolASubjects);
        poolB.setElectivesubjectCollection(poolBSubjects);
        ArrayList<PrioritiesInfoDTO> priorities = new ArrayList<>();
        priorities.add(new PrioritiesInfoDTO("1,1"));
        priorities.add(new PrioritiesInfoDTO("1,2"));
        priorities.add(new PrioritiesInfoDTO("2,2"));
        priorities.add(new PrioritiesInfoDTO("1,0"));
        priorities.add(new PrioritiesInfoDTO("0,0"));
        priorities.add(new PrioritiesInfoDTO("0,2"));
        Collection<Student> students = em.createNamedQuery("Student.findAll").getResultList();
        //Student stud ;
        System.out.println(students.size()+"");
        int a,b;
        for (Student stud:students) {
            a=0;b=0;
            if(stud.getFirstpri1electivesubjid()!=0 && stud.getFirstpri2electivesubjid()!=0
                    && stud.getSecondpri1electivesubjid()!=0 && stud.getSecondpri2electivesubjid()!=0)
            {
                if(checkIFStudentHasSubjectInPool(stud.getFirstpri1electivesubjid(), poolA))
                {
                    a=1;
                    System.out.println("1");
                }
                else if(checkIFStudentHasSubjectInPool(stud.getFirstpri1electivesubjid(), poolB))
                {
                    b=1;
                }
                if(checkIFStudentHasSubjectInPool(stud.getFirstpri2electivesubjid(), poolA))
                {
                    a=1;
                }
                else if(checkIFStudentHasSubjectInPool(stud.getFirstpri2electivesubjid(), poolB))
                {
                    b=1;
                }
                if(checkIFStudentHasSubjectInPool(stud.getSecondpri1electivesubjid(), poolA))
                {
                    if(a!=1) a=2;
                }
                else if(checkIFStudentHasSubjectInPool(stud.getSecondpri1electivesubjid(), poolB))
                {
                    if(b!=1) b=2;
                }
                if(checkIFStudentHasSubjectInPool(stud.getSecondpri2electivesubjid(), poolA))
                {
                     if(a!=1) a=2;
                }
                else if(checkIFStudentHasSubjectInPool(stud.getSecondpri2electivesubjid(), poolB))
                {
                    if(b!=1) b=2;
                }
                if(a==1 && b==1)
                {
                    priorities.get(0).addStudents(createStudentInfoDTO(stud));
                }
                else if((a==1 && b==2) || (a==2 && b==1))
                {
                    priorities.get(1).addStudents(createStudentInfoDTO(stud));
                }
                else if(a==2 && b==2)
                {
                    priorities.get(2).addStudents(createStudentInfoDTO(stud));
                }
                else if((a==1 && b==0) || (a==0 && b==1))
                {
                    priorities.get(3).addStudents(createStudentInfoDTO(stud));
                }
                else if(a==0 && b==0)
                {
                    priorities.get(4).addStudents(createStudentInfoDTO(stud));
                }
                else if((a==0 && b==2) || (a==2 && b==0))
                {
                    priorities.get(5).addStudents(createStudentInfoDTO(stud));
                }
            }
        }
        for(PrioritiesInfoDTO p : priorities)
        {
            for(StudentInfoDTO student :p.getStudents())
            {
                String first1Name="",first2Name="",second1Name="",second2Name="";
                for(Electivesubject subject : subjects)
                {
                    if(subject.getSubjectid()== Integer.parseInt(student.getFirstPri1ElectiveSubjName()))
                    {
                        first1Name=subject.getName();
                    }
                    if(subject.getSubjectid()== Integer.parseInt(student.getFirstPri2ElectiveSubjName()))
                    {
                        first2Name=subject.getName();
                    }
                    if(subject.getSubjectid()== Integer.parseInt(student.getSecondPri1ElectiveSubjName()))
                    {
                        second1Name=subject.getName();
                    }
                    if(subject.getSubjectid()== Integer.parseInt(student.getSecondPri2ElectiveSubjName()))
                    {
                        second2Name=subject.getName();
                    }
                }
                student.setFirstPri1ElectiveSubjName(first1Name);
                student.setFirstPri2ElectiveSubjName(first2Name);
                student.setSecondPri1ElectiveSubjName(second1Name);
                student.setSecondPri2ElectiveSubjName(second2Name);
            }
        }
        return priorities;    
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public Collection<ElectiveSubjectSummary> getPoolASubjects() {
        Pool poolA = em.find(Pool.class, "A");
        System.out.println(poolA.getElectivesubjectCollection().size());
        return createElectiveSummaries(poolA.getElectivesubjectCollection());
    }

    @Override
    public Collection<ElectiveSubjectSummary> getPoolBSubjects() {
        Pool poolB = em.find(Pool.class, "B");
        System.out.println(poolB.getElectivesubjectCollection().size());
        return createElectiveSummaries(poolB.getElectivesubjectCollection());
    }
    
    public boolean checkIFStudentHasSubjectInPool(int SubjectId,Pool pool)
    {
        for(Electivesubject es : pool.getElectivesubjectCollection())
        {
            if(es.getSubjectid()==SubjectId)
            {
                System.out.println(es.getName());
                return true;
            }
        }
        return false;
    }

    @Override
    public void makeSecondChoise(int stuId, int firstPriPoolAElectiveSubjID, int secondPriPoolAElectiveSubjID, int firstPriPoolBElectiveSubjID, int secondPriPoolBElectiveSubjID) {

        boolean isTheIdInTheDB = false;
        Collection<StudentRound2> studentsSecond = em.createNamedQuery("StudentRound2.findAll").getResultList();
        
        for(StudentRound2 sR2 : studentsSecond)
        {
            if(sR2.getStuid() == stuId)
            {
                isTheIdInTheDB = true;
            }
        }
        
        if (!isTheIdInTheDB) {
            StudentRound2 stu = new StudentRound2(stuId, firstPriPoolAElectiveSubjID, secondPriPoolAElectiveSubjID, firstPriPoolBElectiveSubjID, secondPriPoolBElectiveSubjID, null);
            em.persist(stu);
        }else {
            StudentRound2 stu = em.find(StudentRound2.class, stuId);
            stu.setFirstpripoolaelectivesubjid(firstPriPoolAElectiveSubjID);
            stu.setSecondpripoolaelectivesubjid(secondPriPoolAElectiveSubjID);
            stu.setFirstpripoolb1electivesubjid(firstPriPoolBElectiveSubjID);
            stu.setSecondpripoolbelectivesubjid(secondPriPoolBElectiveSubjID);
        }
    }
}
