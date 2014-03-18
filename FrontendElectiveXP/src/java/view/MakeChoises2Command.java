/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import backend.DummyBackend;
import electivexp.dto.ElectiveSubjectSummary;

import electivexp.dto.StudentFirstRoundDetail;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rasmus
 */
class MakeChoises2Command extends TargetCommand{

    public MakeChoises2Command(String target) {
        super(target);
    }
    @Override
    public String execute(HttpServletRequest request) {
        
 
        
//        try {
//            int first = Integer.parseInt(request.getParameter("firstpri1"));
//            int second = Integer.parseInt(request.getParameter("firstpri1"));
//            int third = Integer.parseInt(request.getParameter("firstpri1"));
//            int fourth = Integer.parseInt(request.getParameter("firstpri1"));
//        } catch (Exception e) {
//        }
        
        
        String firstPriASelectedSubject = request.getParameter("firstpriA");
        int firstPriASelectedSubjectINT = Integer.parseInt(firstPriASelectedSubject);
        
        String firstPriBSelectedSubject = request.getParameter("firstpriB");
        int firstPriBSelectedSubjectINT = Integer.parseInt(firstPriBSelectedSubject);
        
        String secondPriASelectedSubject = request.getParameter("secondpriA");
        int secondPriASelectedSubjectINT = Integer.parseInt(secondPriASelectedSubject);
        
        String secondPriBSelectedSubject = request.getParameter("secondpriB");
        int secondPriBSelectedSubjectINT = Integer.parseInt(secondPriBSelectedSubject);
        
        Factory.getInstance().getManager().makeChoise(2, firstPriASelectedSubjectINT, firstPriBSelectedSubjectINT, secondPriASelectedSubjectINT, secondPriBSelectedSubjectINT);
        
        
        
//        get subject names:
        
        ArrayList<ElectiveSubjectSummary> subjects = new ArrayList<>();
        subjects = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getSubjects();
        
        String firstChoiseA = "";
        String firstChoiseB = "";
        String secondChoiseA = "";
        String secondChoiseB = "";
        
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getId() == firstPriASelectedSubjectINT){
                firstChoiseA = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == firstPriBSelectedSubjectINT){
                firstChoiseB = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == secondPriASelectedSubjectINT){
                secondChoiseA = subjects.get(i).getName();
            }
            if(subjects.get(i).getId() == secondPriBSelectedSubjectINT){
                secondChoiseB = subjects.get(i).getName();
            }
        }
        
        String selectedSubjectIDer = "You havew chosen i Pool A: " + firstChoiseA + ", " + secondChoiseA + " and in Pool B: " + firstChoiseB + " and " + secondChoiseB + " as elective subjects";
        
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
        return super.execute(request);
    }
    
}