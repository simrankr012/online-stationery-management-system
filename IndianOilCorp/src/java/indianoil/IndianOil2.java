package indianoil ;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import indianoil.DBService;
import java.io.IOException;
import java.io.PrintWriter;
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
 * 
 * 
 */
public class IndianOil2 extends HttpServlet {

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
        
         String user=request.getParameter("txt");
            String pass=request.getParameter("txtPassword");
            String cpass=request.getParameter("txtConfirmPassword");
            String state=request.getParameter("state");
            String email=request.getParameter("email");
            
            out.print(user); 
            HttpSession session = request.getSession(false);
            if(true)
            {  
              
    
            String q="insert into login values('"+user+"','"+pass+"','"+state+"','"+email+"')";
            int i=DBService.updateData(q);
           String msg=" ";
          if(i!=0){  
            msg="Record has been inserted";
            out.println("<font size='6' color=blue>" + msg + "</font>");  
            response.sendRedirect("index.html");
            

          }  
          else{  
            msg="failed to insert the data";
            out.println("<font size='6' color=blue>" + q + "</font>");
           response.sendRedirect("Register.html");}  
            
           
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IndianOil2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IndianOil2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *    }

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

