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
        
        boolean isTheIdsInTheDB = Factory.getInstance().getManager().checkIfElectiveSubjectsAreInDB(
                firstPriASelectedSubjectINT, firstPriBSelectedSubjectINT, 
                secondPriASelectedSubjectINT, secondPriBSelectedSubjectINT);
        
        if(isTheIdsInTheDB){
        
        if(firstPriASelectedSubjectINT == firstPriBSelectedSubjectINT
                || secondPriASelectedSubject == secondPriBSelectedSubject){
            request.setAttribute("error" , 
  "Some of the id's are the same, please make new choises .....");
            
            ArrayList<ElectiveSubjectSummary> poolA = new ArrayList<>();
        ArrayList<ElectiveSubjectSummary> poolB = new ArrayList<>();
        
        poolA = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolASubjects();
        poolB = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolBSubjects();
        
        System.out.println(poolA.size());
        System.out.println(poolB.size());
       request.setAttribute("PoolA", poolA);
       request.setAttribute("PoolB", poolB);
            
            return "round2.jsp";
        }
        
        Factory.getInstance().getManager().makeSecondChoise(2, firstPriASelectedSubjectINT, secondPriASelectedSubjectINT, firstPriBSelectedSubjectINT, secondPriBSelectedSubjectINT);
        
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
        
        String selectedSubjectIDer = "You have chosen i Pool A: " + firstChoiseA + ", " + secondChoiseA + " and in Pool B: " + firstChoiseB + " and " + secondChoiseB + " as elective subjects";
        
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
        
        }else{
            request.setAttribute("error" , 
  "Some of the id's don't exist in the database, please make new choises .....");
            
            ArrayList<ElectiveSubjectSummary> poolA = new ArrayList<>();
        ArrayList<ElectiveSubjectSummary> poolB = new ArrayList<>();
        
        poolA = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolASubjects();
        poolB = (ArrayList<ElectiveSubjectSummary>) Factory.getInstance().getManager().getPoolBSubjects();
        
        System.out.println(poolA.size());
        System.out.println(poolB.size());
       request.setAttribute("PoolA", poolA);
       request.setAttribute("PoolB", poolB);
            
            return "round2.jsp";
        }
    }
    
}
