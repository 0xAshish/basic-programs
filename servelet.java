/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 *
 * @author global
 */
public class FirstServlet extends HttpServlet {
   

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();



        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements())
            {
                String pName=(String)enu.nextElement();
                String[] pValues=request.getParameterValues(pName);
                out.print("<b>"+pName+"</b>");
                for(int i=0;i<pValues.length;i++)
                {
                    out.print(pValues[i]);
                  }
                out.print("<br>");
        }
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libman", "root", "root");

                PreparedStatement ptmt = null;
                String category = request.getParameter("c");
                String ISBN = request.getParameter("isbn");
                String booktitle = request.getParameter("title");
                String autor = request.getParameter("author");
                

                String sql = "insert into book values(?,?,?,?)";
                ptmt = con.prepareStatement(sql);
                ptmt.setString(1, category);
                ptmt.setString(2, ISBN);
                ptmt.setString(3, booktitle);
                ptmt.setString(4, autor);
                
                String res;

                if (ptmt.executeUpdate() >= 1) {
                    res="book is inserted";
                } else {
                    res = "book not inserted";
                }
    out.print(res);
            }catch(Exception ex) {
            System.out.println(ex);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
