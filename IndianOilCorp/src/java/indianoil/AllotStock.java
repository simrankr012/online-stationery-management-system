package indianoil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import indianoil.DBService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Simran
 */
public class AllotStock extends HttpServlet {
        
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,SQLException {
       
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
             PreparedStatement pst=null;
       // Connection conn =null;
        PrintWriter out = response.getWriter();
                
    /*    String url = "jdbc:mysql://localhost:3306/";
        String dbName = "stock";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
    
        Class.forName(driver).newInstance();
    
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

*/
         response.setContentType("text/html;charset=UTF-8");
         
         String item= request.getParameter("item");
        String quantity=request.getParameter("quant");
        int quant  = Integer.parseInt(quantity);
        int i,j,n;
         String q="select "+item+" from stock";
         ResultSet  rs=DBService.selectData(q);
           int stockQuantity=0;
           if(rs.next())
           {
               stockQuantity=rs.getInt(item);
           }
         
         if(stockQuantity>=quant)
         {
            String updateQuery ="update stock set "+item+"="+(stockQuantity-quant);
            i=DBService.updateData(updateQuery);
            String msg=" ";
            if(i!=0){  
                //msg="Record has been inserted";
                //out.println("<font size='6' color=blue>" + msg + "</font>");  
                response.sendRedirect("FormSub.html");
            }  
          else{  
            //msg="failed to insert the data";
            //out.println("<font size='6' color=blue>" + q + "</font>");
             response.sendRedirect("index.html");
           }  
            
            
         }
          else{  
            //msg="failed to insert the data";
            //out.println("<font size='6' color=blue>" + q + "</font>");
             response.sendRedirect("index.html");
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
             Logger.getLogger(AllotStock.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(AllotStock.class.getName()).log(Level.SEVERE, null, ex);
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