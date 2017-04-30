/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package indianoil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




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
public class AdminLog extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
            String user=request.getParameter("au");
            String pass=request.getParameter("ap");
            PrintWriter out = response.getWriter();
            
            HttpSession session = request.getSession();
            if(session!=null)
                session.setAttribute("username", user);
            
           String q="select * from admin where username='"+user+"' and pass='"+pass+"'";
           ResultSet rs=DBService.selectData(q);
           if(rs.next())
           {
           response.sendRedirect("Admin.html");}
           else
           {
          
          response.sendRedirect("index.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
{
}
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
        try {
            processRequest(request,response);
        } catch (SQLException ex) {

            Logger.getLogger(AdminLog.class.getName()).log(Level.SEVERE, null, ex);
        }
   }}		


          
           
            
        
  
        
        
        
    

