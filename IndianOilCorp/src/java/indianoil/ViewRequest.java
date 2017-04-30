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
/**
 *
 * @author Simran
 */
public class ViewRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        /*
            String id=request.getParameter("empid");
            String name=request.getParameter("empname");
            String qnt=request.getParameter("quant");
            String dsg=request.getParameter("desig");
            String dpt=request.getParameter("department");
            String itm=request.getParameter("item");
            
            int eid=Integer.parseInt(id);
            int qt=Integer.parseInt(qnt);
            
          */  
         String id=request.getParameter("emid");
        int eid=Integer.parseInt(id);
            String q="select * from data where emp_id='"+eid+"'" ;
           ResultSet rs=DBService.selectData(q);
            PrintWriter out = response.getWriter();
            if(rs.next())
            {       out.println("<html>");
            
                out.println("<table>");
                out.println("<tr>");
                
            
            out.println("<b>           |       Employee Id :                 |</b>"+rs.getString("    emp_id               |"));
            out.println("<br>");
            
            out.println("<b>           |       Employee Name :               |</b>"+rs.getString("    emp_name             |"));
            out.println("<br>");
            out.println("<b>           |       Designation :                 |</b>"+rs.getString("    emp_desig            |"));
            out.println("<br>");
            out.println("<b>           |       Department :                  |</b>"+rs.getString("    emp_department       |"));
            out.println("<br>");
            out.println("<b>           |       Requested Item :              |</b>"+rs.getString("    item                 |"));
            out.println("<br>");
            out.println("<b>           |       Quantity of Item :            |</b>"+rs.getString("    quantity             |"));
            
           out.println("</table>");
            out.println("</html>");}
            
           
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
{
    try {
            processRequest(request,response);
        } catch (SQLException ex) {

            Logger.getLogger(ViewRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
        try {
            processRequest(request,response);
        } catch (SQLException ex) {

            Logger.getLogger(ViewRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
   }}		


          
           
            
        
  
        
        
        
    

