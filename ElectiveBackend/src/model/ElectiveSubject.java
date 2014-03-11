/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thomas
 */
public class ElectiveSubject {
    private int subjectId;
    private String name;
    private String desc;
    private Teacher teacher;
//    private int nextID = 10;
    

    public ElectiveSubject(int subjectId, String name, String desc, Teacher teacher) {
        this.name = name;
        this.desc = desc;
        this.teacher = teacher;
        this.subjectId = subjectId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
    
}
