/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electivexp.dto;

/**
 *
 * @author Thomas
 */
public class StudentInfoDTO {

    private int stuId;
    private String fName;
    private String lName;
    private String firstPri1ElectiveSubjName;
    private String firstPri2ElectiveSubjName;
    private String secondPri1ElectiveSubjName;
    private String secondPri2ElectiveSubjName;

    public StudentInfoDTO(int stuId, String fName, String lName, String firstPri1ElectiveSubjID, String firstPri2ElectiveSubjID, String secondPri1ElectiveSubjID, String secondPri2ElectiveSubjID) {
        this.stuId = stuId;
        this.fName = fName;
        this.lName = lName;
        this.firstPri1ElectiveSubjName = firstPri1ElectiveSubjID;
        this.firstPri2ElectiveSubjName = firstPri2ElectiveSubjID;
        this.secondPri1ElectiveSubjName = secondPri1ElectiveSubjID;
        this.secondPri2ElectiveSubjName = secondPri2ElectiveSubjID;
    }

    public String getFirstPri1ElectiveSubjName() {
        return firstPri1ElectiveSubjName;
    }

    public String getFirstPri2ElectiveSubjName() {
        return firstPri2ElectiveSubjName;
    }

    public String getSecondPri1ElectiveSubjName() {
        return secondPri1ElectiveSubjName;
    }

    public String getSecondPri2ElectiveSubjName() {
        return secondPri2ElectiveSubjName;
    }

    

    public int getStuId() {
        return stuId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getName() {
        return fName + " " + lName;
    }
}
