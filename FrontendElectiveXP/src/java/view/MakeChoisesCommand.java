/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import electivexp.dto.ElectiveSubjectSummary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rasmus
 */
class MakeChoisesCommand extends TargetCommand{

    public MakeChoisesCommand(String target) {
        super(target);
    }
    @Override
    public String execute(HttpServletRequest request) {
        
        String firstPri1SelectedSubject = request.getParameter("firstpri1");
        int firstPri1SelectedSubjectINT = Integer.parseInt(firstPri1SelectedSubject);
        
        String firstPri2SelectedSubject = request.getParameter("firstpri2");
        int firstPri2SelectedSubjectINT = Integer.parseInt(firstPri2SelectedSubject);
        
        String secondPri1SelectedSubject = request.getParameter("secondpri1");
        int secondPri1SelectedSubjectINT = Integer.parseInt(secondPri1SelectedSubject);
        
        String secondPri2SelectedSubject = request.getParameter("secondpri2");
        int secondPri2SelectedSubjectINT = Integer.parseInt(secondPri2SelectedSubject);
        
        boolean isTheIdsInTheDB = Factory.getInstance().getManager().checkIfElectiveSubjectsAreInDB(firstPri1SelectedSubjectINT, firstPri2SelectedSubjectINT, secondPri1SelectedSubjectINT, secondPri2SelectedSubjectINT);
        
        if(isTheIdsInTheDB){
        
        Factory.getInstance().getManager().makeChoise(2, firstPri1SelectedSubjectINT, firstPri2SelectedSubjectINT, secondPri1SelectedSubjectINT, secondPri2SelectedSubjectINT);
        
//        get subject names:
        
        ArrayList<ElectiveSubjectSummary> subjects = new ArrayList<>();
        subjects = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getSubjects();
        
        String firstChoise = "";
        String secondChoise = "";
        String thirdChoise = "";
        String fourthChoise = "";
        
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getId() == firstPri1SelectedSubjectINT){
                firstChoise = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == firstPri2SelectedSubjectINT){
                secondChoise = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == secondPri1SelectedSubjectINT){
                thirdChoise = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == secondPri2SelectedSubjectINT){
                fourthChoise = subjects.get(i).getName();
            }
        }
        
        String selectedSubjectIDer = firstChoise + ", " + secondChoise + ", " + thirdChoise + " and " + fourthChoise + " as elective subjects";
        
        request.setAttribute("lol" , selectedSubjectIDer);
        
		try {
//			String content = firstChoise + ", " + secondChoise + ", " + thirdChoise + ", " + fourthChoise;
                        String content = selectedSubjectIDer;
			File file = new File("subjects.txt");
 
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
        }else{
            request.setAttribute("lol" , 
  "You have chosen some id's that are not in the list, please go back and chose some id's that exists in table .....");
        }
        return super.execute(request);
    }
    
}
