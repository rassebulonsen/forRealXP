/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electivexp.dto;

import java.io.Serializable;

/**
 *
 * @author Rasmus
 */
public class PoolSubjectSummary implements Serializable{
    private String name;
    private int id;
    private char poolLetter;

    public PoolSubjectSummary(String name, int id, char poolLetter) {
        this.name = name;
        this.id = id;
        this.poolLetter = poolLetter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getPoolLetter() {
        return poolLetter;
    }

    public void setPoolLetter(char poolLetter) {
        this.poolLetter = poolLetter;
    }
    
    
}
