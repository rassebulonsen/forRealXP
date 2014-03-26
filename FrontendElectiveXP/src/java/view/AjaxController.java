/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import electivexp.ElectiveManager;
import electivexp.dto.PrioritiesInfoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Thomas
 */
public class AjaxController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("hello");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String command=request.getParameter("command");
            ElectiveManager manager = Factory.getInstance().getManager();
            String p1 = request.getParameter("poolA");
                System.out.println(p1);
                String p2 = request.getParameter("poolB");
                System.out.println(p2);
                ArrayList<Integer> pool1Array = new ArrayList<>();
                ArrayList<Integer> pool2Array = new ArrayList<>();
                Scanner scan = new Scanner(p1);
                scan.useDelimiter(",");
                while(scan.hasNext())
                {
                    String number = scan.next();
                    if(number != null)
                    if(!(number.equals("")))
                    pool1Array.add(Integer.parseInt(number));
                }
                Scanner scan2 = new Scanner(p2);
                scan2.useDelimiter(",");
                while(scan2.hasNext())
                {
                    String number = scan2.next();
                    if(number != null)
                    if(!(number.equals("")))
                    pool2Array.add(Integer.parseInt(number));
                }
            switch (command) {
                case "getStat":
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println(pool1Array.size());
                    System.out.println(pool2Array.size());
                    String send = "<tr>\n" +
        "                    <th>nr</th>\n" +
        "                    <th>(1,1)</th>\n" +
        "                    <th>(1,2)</th>\n" +
        "                    <th>(2,2)</th>\n" +
        "                    <th>(1,0)</th>\n" +
        "                    <th>(2,0)</th>\n" +
        "                    <th>(0,0)</th>\n" +
        "                </tr>";
                    ArrayList<PrioritiesInfoDTO> priorities = manager.getStudentPoolSatisfaction(pool1Array, pool2Array);
        //                    new ArrayList<>();
        //            priorities.add(new Priorities("1,1"));
        //            priorities.add(new Priorities("1,2"));
        //            priorities.add(new Priorities("2,2"));
        //            priorities.add(new Priorities("1,0"));
        //            priorities.add(new Priorities("0,0"));
        //            priorities.add(new Priorities("0,2"));
        //            priorities.get(0).addStudents(new Student2("a",1, 2, 3, 4));
        //             priorities.get(2).addStudents(new Student2("b",5, 6, 7, 8));
        //             priorities.get(2).addStudents(new Student2("c",1, 3, 5, 7));
        //             priorities.get(1).addStudents(new Student2("d",1, 4, 5, 6));
        //             priorities.get(4).addStudents(new Student2("e",3, 6, 9, 10));
        //             priorities.get(5).addStudents(new Student2("f",2, 4, 8, 10));
                    int maxSize =0;
                    for(int i =0;i<priorities.size();i++)
                    {
                        if(priorities.get(i).getSize()>maxSize) maxSize=priorities.get(i).getSize();
                    }
                    for(int j =0;j< maxSize;j++)
                    {
                        send=send+"<tr>"+"<td>"+(j+1)+"</td>"+"<td>";
                        if(priorities.get(0).getSize()>j)
                        {
                            send=send+priorities.get(0).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(0).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(0).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(0).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(0).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>"+"<td>";
                        if(priorities.get(1).getSize()>j)
                        {
                            send=send+priorities.get(1).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(1).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(1).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(1).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(1).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>"+"<td>";
                        if(priorities.get(2).getSize()>j)
                        {
                            send=send+priorities.get(2).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(2).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(2).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(2).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(2).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>"+"<td>";
                        if(priorities.get(3).getSize()>j)
                        {
                            send=send+priorities.get(3).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(3).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(3).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(3).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(3).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>"+"<td>";
                        if(priorities.get(4).getSize()>j)
                        {
                            send=send+priorities.get(4).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(4).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(4).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(4).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(4).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>"+"<td>";
                        if(priorities.get(5).getSize()>j)
                        {
                            send=send+priorities.get(5).getStudentByIndex(j).getName()+
                                    "(1:"+priorities.get(5).getStudentByIndex(j).getFirstPri1ElectiveSubjName()+
                                    ",1:"+priorities.get(5).getStudentByIndex(j).getFirstPri2ElectiveSubjName()+
                                    ",2:"+priorities.get(5).getStudentByIndex(j).getSecondPri1ElectiveSubjName()+
                                    ",2:"+priorities.get(5).getStudentByIndex(j).getSecondPri2ElectiveSubjName()+")";
                        }
                        send=send+"</td>";
                        send=send+"</tr>";
                    }
                    out.println(send);
                    break;
                case "save":
                    manager.savePools(pool1Array, pool2Array);
                    out.println("saved");
                    break;
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
