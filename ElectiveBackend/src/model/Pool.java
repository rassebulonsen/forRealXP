/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kristijan
 */
public class Pool {

    //private ArrayList<ElectiveSubject> subjects = new ArrayList<>();
    private Map<Integer,ElectiveSubject> subjects = new HashMap<>();
    
    public void addSubject(ElectiveSubject es) {
        subjects.put(es.getSubjectId(), es);
    }

    public int getSize() {
        return subjects.size();
    }
    
    public boolean checkSubject(int id)
    {
        if(subjects.get(id) != null) return true;
        return false;
    }
    
}
