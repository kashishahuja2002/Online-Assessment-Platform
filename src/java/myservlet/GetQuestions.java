/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author m.boopathi
 */
public class GetQuestions extends HttpServlet {
    public static int count=0;
    HashSet arrList=null;
    Iterator<Questions> i=null;
    public static int marks=0;
    String correctAns="";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String start=request.getParameter("start");
        if(start!=null){
             count=0;
             Marks.marks=0;
        }
        System.out.println("count----"+count);
        if(count==10){
                count=0;
                Marks.marks=0;
            }
        String check=request.getParameter("question");
        System.out.println("temp-----"+correctAns);
        System.out.println("check-----"+check);
        if(count>0){
            if(correctAns.equals(check)){
                Marks.marks++;
                System.out.println("marks----"+Marks.marks);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(count==0){
                arrList=Dao.getQuestions();
                i = arrList.iterator();
            }
            String result="";
            if(count<10){
                Questions ques=i.next();
                result+=ques.getQuestion()+":";
                result+=ques.getOption1()+":";
                result+=ques.getOption2()+":";
                result+=ques.getOption3()+":";
                result+=ques.getOption4()+":";
                result+=ques.getCorrect();
                correctAns=ques.getCorrect();
                count++;
                out.print(result);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
