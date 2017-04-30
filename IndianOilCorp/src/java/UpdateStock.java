
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import indianoil.DBService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simran
 */
public class UpdateStock extends HttpServlet {

    private String input;

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
            throws ServletException, IOException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
   
    int pen=Integer.parseInt(request.getParameter("pen"));
            int pencil=Integer.parseInt(request.getParameter("pencil"));
            
           
            int sheetbox=Integer.parseInt(request.getParameter("sheetbox"));
            int markers=Integer.parseInt(request.getParameter("markers"));
            int fevistick=Integer.parseInt(request.getParameter("fevistick"));
            int staplers=Integer.parseInt(request.getParameter("staplers"));
            int pinbox=Integer.parseInt(request.getParameter("pinbox"));
            int stickynotes=Integer.parseInt(request.getParameter("stickynotes"));
            int p1,p2,p3,p4,p5,p6,p7,p8;
             HttpSession session = request.getSession(false);
           String q="select * from stock";
           ResultSet rs=DBService.selectData(q);
           if(rs.next())
            {  
               p1=rs.getInt("pencil");
               p2=rs.getInt("pen");
               p3=rs.getInt("sheetbox");
               p4=rs.getInt("markers");
               p5=rs.getInt("fevistick");
               p6=rs.getInt("staplers");
               p7=rs.getInt("pinbox");
               p8=rs.getInt("stickynotes");
              
            String qa="update stock set pen="+(p2+pen)+", pencil="+(p1+pencil)+",sheetbox="+(p3+sheetbox)+",markers="+(p4+markers)+",fevistick="+(p5+fevistick)+",staplers="+(p6+staplers)+",pinbox="+(p7+pinbox)+",stickynotes="+(p8+stickynotes);
            int i=DBService.updateData(qa);
            
            
            
            
            String msg=" ";
            if(i!=0){  
                msg="Record has been updated";
                out.println("<font size='6' color=blue>" + msg + "</font>");  
                response.sendRedirect("FormSub.html");
            

            }  
          else{  
            msg="failed to update the data";
            out.println("<font size='6' color=blue>" + q + "</font>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStock.class.getName()).log(Level.SEVERE, null, ex);
        }
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