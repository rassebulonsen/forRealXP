/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electivexp;

import electivexp.dto.ElectiveSubjectSummary;
import electivexp.dto.PrioritiesInfoDTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author Thomas
 */

@Remote
public interface ElectiveManager {
    
    void makeChoise(int stuId, int firstPri1ElectiveSubjID,int firstPri2ElectiveSubjID, int second1ElectiveSubjID, int second2Pri2ElectiveSubjID);
    Collection<ElectiveSubjectSummary> getSubjects();
    void savePools(ArrayList<Integer> poolAArray,ArrayList<Integer> poolBArray);
    ArrayList<PrioritiesInfoDTO> getStudentPoolSatisfaction(ArrayList<Integer> poolAArray,ArrayList<Integer> poolBArray);
}
