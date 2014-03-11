/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Thomas
 */
public class Person {
    
    private int id;
    private String fName;
    private String lName;
    private int cpr;
    private String email;
    private String password;
    
    public Person(int id,String fName, String lName, int cpr, String email, String password) {
        this.fName = fName;
        this.lName = lName;
        this.cpr = cpr;
        this.email = email;
        this.password = password;
        this.id = id;
    }
    
    public String getlName() {
        return lName;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }
    
    
}
