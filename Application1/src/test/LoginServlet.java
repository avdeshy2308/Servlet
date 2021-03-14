package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class LoginServlet extends GenericServlet {

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
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		try {
			PreparedStatement ps=con.prepareStatement("select * from login2 where uname = ? and pass = ?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("<script>alert('Login Sucessfull.')</script>");
				RequestDispatcher rd=req.getRequestDispatcher("product.html");
				rd.forward(req, res);
				
			}
			else {
				pw.println("<script>alert('Login failed Try Again.')</script>");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
			    rd.include(req, res);	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
