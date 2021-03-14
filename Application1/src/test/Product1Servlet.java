package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class Product1Servlet extends GenericServlet {

	public Connection con;
	@Override
	public void init()throws ServletException{
		con=DbConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
        String pname=req.getParameter("pname");
        try {
        	PreparedStatement ps=con.prepareStatement("Select * from product where pname = ?");
        	ps.setString(1, pname);
        	
        
        	ResultSet rs=ps.executeQuery();
        	if(rs.next()) {
        		RequestDispatcher rd=req.getRequestDispatcher("display1");
        		rd.forward(req,res);
        	}
        	else {
        		pw.println("Invalid Product Code");
        	    RequestDispatcher rd=req.getRequestDispatcher("product.html");
        	    rd.include(req, res);
        	}
        }
        catch(Exception e){
        	
        }
	}
}