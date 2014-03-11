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
public class StudentFirstRoundDetail implements Serializable{
    private int stuId;
    private int firstPri1ElectiveSubjID;
    private int firstPri2ElectiveSubjID;
    private int secondPri1ElectiveSubjID;
    private int secondPri2ElectiveSubjID;

    public StudentFirstRoundDetail(int stuId, int firstPri1ElectiveSubjID, int firstPri2ElectiveSubjID, int secondPri1ElectiveSubjID, int secondPri2ElectiveSubjID) {
        this.stuId = stuId;
        this.firstPri1ElectiveSubjID = firstPri1ElectiveSubjID;
        this.firstPri2ElectiveSubjID = firstPri2ElectiveSubjID;
        this.secondPri1ElectiveSubjID = secondPri1ElectiveSubjID;
        this.secondPri2ElectiveSubjID = secondPri2ElectiveSubjID;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getFirstPri1ElectiveSubjID() {
        return firstPri1ElectiveSubjID;
    }

    public void setFirstPri1ElectiveSubjID(int firstPri1ElectiveSubjID) {
        this.firstPri1ElectiveSubjID = firstPri1ElectiveSubjID;
    }

    public int getFirstPri2ElectiveSubjID() {
        return firstPri2ElectiveSubjID;
    }

    public void setFirstPri2ElectiveSubjID(int firstPri2ElectiveSubjID) {
        this.firstPri2ElectiveSubjID = firstPri2ElectiveSubjID;
    }

    public int getSecondPri1ElectiveSubjID() {
        return secondPri1ElectiveSubjID;
    }

    public void setSecondPri1ElectiveSubjID(int secondPri1ElectiveSubjID) {
        this.secondPri1ElectiveSubjID = secondPri1ElectiveSubjID;
    }

    public int getSecondPri2ElectiveSubjID() {
        return secondPri2ElectiveSubjID;
    }

    public void setSecondPri2ElectiveSubjID(int secondPri2ElectiveSubjID) {
        this.secondPri2ElectiveSubjID = secondPri2ElectiveSubjID;
    }
    
}
