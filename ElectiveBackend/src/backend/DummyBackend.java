/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import electivexp.ElectiveManager;
import electivexp.dto.ElectiveSubjectSummary;
import electivexp.dto.PrioritiesInfoDTO;
import electivexp.dto.StudentListInSubjectDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import model.ElectiveSubject;
import model.Person;
import model.PoolS;
import model.Priorities;
import model.Student;
import model.Teacher;

/**
 *
 * @author Thomas
 */
public class DummyBackend implements ElectiveManager{
    
    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<Integer, Person> persons = new HashMap<>();
    private ArrayList<ElectiveSubject> electivSubjects = new ArrayList<>();

    public ArrayList<ElectiveSubject> getElectivSubjects() {
        return electivSubjects;
    }
    
//    private ArrayList<Student> students = new ArrayList<>();
    private PoolS poolA;
    private PoolS poolB;
    
    Teacher t1 = new Teacher(1, "Torben", "?", 111, "tor@cph.dk", "cocio2013");
    Teacher t2 = new Teacher(80, "Peter", "Lorentzen", 113, "pelo@cph.dk", "11111");
    
    public DummyBackend() {
        students.put(1, new Student(1, "Thomas", "Jonstrup", 112, "tj@cph.dk", "1111", 0, 0, 0,0));
        students.put(2, new Student(2, "s1", "Jonstrup", 112, "tj@cph.dk", "1111", 8, 9, 10,11));
        students.put(3, new Student(3, "s2", "Jonstrup", 112, "tj@cph.dk", "1111", 7, 8, 13,12));
        students.put(4, new Student(4, "s3", "Jonstrup", 112, "tj@cph.dk", "1111", 9, 10, 11,12));
        students.put(5, new Student(5, "s4", "Jonstrup", 112, "tj@cph.dk", "1111", 10, 8, 11,13));
        students.put(6, new Student(6, "s5", "Jonstrup", 112, "tj@cph.dk", "1111", 11, 13, 8,9));
        students.put(7, new Student(7, "s7", "Jonstrup", 112, "tj@cph.dk", "1111", 13, 11, 8,9));
        
        persons.put(1,new Person(1, "Thomas", "Jonstrup", 112,"tjcph.dk" ,"1111"));
        persons.put(2,new Person(2,  "s2", "Jonstrup", 112, "tj@cph.dk", "1111"));
        persons.put(3,new Person(3,  "s3", "Jonstrup", 112, "tj@cph.dk", "1111"));
        persons.put(4,new Person(4,  "s4", "Jonstrup", 112, "tj@cph.dk", "1111"));
        persons.put(5,new Person(5,  "s5", "Jonstrup", 112, "tj@cph.dk", "1111"));
        persons.put(6,new Person(6,  "s6", "Jonstrup", 112, "tj@cph.dk", "1111"));
        persons.put(7,new Person(7,  "s7", "Jonstrup", 112, "tj@cph.dk", "1111"));
        
        electivSubjects.add(new ElectiveSubject(7,"C#","C Sharp", t1));
        electivSubjects.add(new ElectiveSubject(8, "Python", "Python Language", t2));
        electivSubjects.add(new ElectiveSubject(9, "Android", "Get your Android", t2));
        electivSubjects.add(new ElectiveSubject(10, "SW Design", "Get your Android", t2));
        electivSubjects.add(new ElectiveSubject(11, "Games", "Get your Android", t2));
        electivSubjects.add(new ElectiveSubject(12, "Databases", "Get your Android", t2));
        electivSubjects.add(new ElectiveSubject(13, "Mordern Languages", "Get your Android", t2));
        poolA = new PoolS();
        poolB = new PoolS();
    }

    @Override
    public void makeChoise(int stuId, int firstPri1ElectiveSubjID, int firstPri2ElectiveSubjID, int second1ElectiveSubjID, int second2Pri2ElectiveSubjID) {
        students.get(stuId).setFirstPri1(firstPri1ElectiveSubjID);
        students.get(stuId).setFirstPri2(firstPri2ElectiveSubjID);
        students.get(stuId).setSecondPri1(second2Pri2ElectiveSubjID);
        students.get(stuId).setSecondPri2(second2Pri2ElectiveSubjID);
    }


    @Override
    public Collection<ElectiveSubjectSummary> getSubjects() {
        return DummyBankAssembler.createElectiveSummaries(electivSubjects);
    }

    @Override
    public void savePools(ArrayList<Integer> poolAArray, ArrayList<Integer> poolBArray) {
        for(int a = 0;a<poolAArray.size();a++)
        {
             int fag=0;
            for(int i =0;i< electivSubjects.size();i++)
            {
                if(poolAArray.get(a)==electivSubjects.get(i).getSubjectId())
                {
                    fag=i;
                }
            }
            poolA.addSubject(electivSubjects.get(fag));
        }
        for(int b = 0;b<poolBArray.size();b++)
        {
            int fag=0;
            for(int i =0;i< electivSubjects.size();i++)
            {
                if(poolBArray.get(b)==electivSubjects.get(i).getSubjectId())
                {
                    fag=i;
                }
            }
            poolB.addSubject(electivSubjects.get(fag));
        }    
    }

    @Override
    public ArrayList<PrioritiesInfoDTO> getStudentPoolSatisfaction(ArrayList<Integer> poolAArray, ArrayList<Integer> poolBArray) {
        PoolS poolA = new PoolS();
        for(int a = 0;a<poolAArray.size();a++)
        {
            int fag=0;
            for(int i =0;i< electivSubjects.size();i++)
            {
                if(poolAArray.get(a)==electivSubjects.get(i).getSubjectId())
                {
                    fag=i;
                }
            }
            poolA.addSubject(electivSubjects.get(fag));
        }
        PoolS poolB = new PoolS();
        for(int b = 0;b<poolBArray.size();b++)
        {
            int fag=0;
            for(int i =0;i< electivSubjects.size();i++)
            {
                if(poolBArray.get(b)==electivSubjects.get(i).getSubjectId())
                {
                    fag=i;
                }
            }
            poolB.addSubject(electivSubjects.get(fag));
        }
        
        ArrayList<Priorities> priorities = new ArrayList<>();
        priorities.add(new Priorities("1,1"));
        priorities.add(new Priorities("1,2"));
        priorities.add(new Priorities("2,2"));
        priorities.add(new Priorities("1,0"));
        priorities.add(new Priorities("0,0"));
        priorities.add(new Priorities("0,2"));
        Student stud ;
        int a,b;
        for (int i = 1; i <= students.size(); i++) {
            stud = students.get(i);
            a=0;b=0;
            if(stud.getFirstPri1ElectiveSubjID()!=0 && stud.getFirstPri2ElectiveSubjID()!=0
                    && stud.getSecondPri1ElectiveSubjID()!=0 && stud.getSecondPri2ElectiveSubjID()!=0)
            {
                if(poolA.checkSubject(stud.getFirstPri1ElectiveSubjID()))
                {
                    a=1;
                }
                else if( poolB.checkSubject(stud.getFirstPri1ElectiveSubjID()))
                {
                    b=1;
                }
                if(poolA.checkSubject(stud.getFirstPri2ElectiveSubjID()))
                {
                    a=1;
                }
                else if( poolB.checkSubject(stud.getFirstPri2ElectiveSubjID()))
                {
                    b=1;
                }
                if(poolA.checkSubject(stud.getSecondPri1ElectiveSubjID()))
                {
                    if(a!=1) a=2;
                }
                else if( poolB.checkSubject(stud.getSecondPri1ElectiveSubjID()))
                {
                    if(b!=1) b=2;
                }
                if(poolA.checkSubject(stud.getSecondPri2ElectiveSubjID()))
                {
                     if(a!=1) a=2;
                }
                else if( poolB.checkSubject(stud.getSecondPri2ElectiveSubjID()))
                {
                    if(b!=1) b=2;
                }
                if(a==1 && b==1)
                {
                    priorities.get(0).addStudents(stud);
                }
                else if((a==1 && b==2) || (a==2 && b==1))
                {
                    priorities.get(1).addStudents(stud);
                }
                else if(a==2 && b==2)
                {
                    priorities.get(2).addStudents(stud);
                }
                else if((a==1 && b==0) || (a==0 && b==1))
                {
                    priorities.get(3).addStudents(stud);
                }
                else if(a==0 && b==0)
                {
                    priorities.get(4).addStudents(stud);
                }
                else if((a==0 && b==2) || (a==2 && b==0))
                {
                    priorities.get(5).addStudents(stud);
                }
            }
            
        }
        return DummyBankAssembler.createPriorityDTO(priorities,electivSubjects);    
    }

    @Override
    public Collection<ElectiveSubjectSummary> getPoolASubjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ElectiveSubjectSummary> getPoolBSubjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkIfElectiveSubjectsAreInDB(int firstId, int secondId, int thirdId, int fourthId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeSecondChoise(int stuId, int firstPriPoolAElectiveSubjID, int secondPriPoolAElectiveSubjID, int firstPriPoolBElectiveSubjID, int secondPriPoolBElectiveSubjID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertElectiveSubject(String name, String desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ElectiveSubjectSummary getSubject(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateElectiveSubjectRound1(int sujectId, String yesOrNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ElectiveSubjectSummary> getSubjectsRound1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ElectiveSubjectSummary> getSubjectsRound2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSudentsInSubject(int studentId, int subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<StudentListInSubjectDTO> getStudentListInSubjectsFromPoolA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<StudentListInSubjectDTO> getStudentListInSubjectsFromPoolB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
