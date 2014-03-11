/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electivexp.dto;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class PrioritiesInfoDTO {
    private String name;
    ArrayList <StudentInfoDTO> students = new ArrayList<>();
    
    public PrioritiesInfoDTO(String name) {
        this.name = name;
    }
    
    public void addStudents(StudentInfoDTO s) {
        students.add(s); 
    }
    public ArrayList<StudentInfoDTO> getStudents()
    {
        return students;
    }
    public int getSize()
    {
        return students.size();
    }

    public StudentInfoDTO getStudentByIndex(int j) {
        return students.get(j);
    }
}
