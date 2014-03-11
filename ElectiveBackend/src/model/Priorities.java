/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Kristijan
 */
public class Priorities {
    private String name;
    ArrayList <Student> students = new ArrayList<>();
    
    public Priorities(String name) {
        this.name = name;
    }
    
    public void addStudents(Student s) {
        students.add(s); 
    }
     public ArrayList<Student> getStudents()
    {
        return students;
    }

    public String getName() {
        return name;
    }
}
