/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electivexp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class StudentListInSubjectDTO implements Serializable {
    private int subjId;
    private String subjName;
    private Collection<StudentInfoDTO> students = new ArrayList<>();

    public StudentListInSubjectDTO(int subjId, String subjName) {
        this.subjId = subjId;
        this.subjName = subjName;
    }

    public String getSubjName() {
        return subjName;
    }
    
    
    
    public void addStudents(StudentInfoDTO sid)
    {
        students.add(sid);
    }

    public Collection<StudentInfoDTO> getStudents() {
        return students;
    }

    public int getSubjId() {
        return subjId;
    }
    
    
    
}
