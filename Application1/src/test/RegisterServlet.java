package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class RegisterServlet extends GenericServlet {

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
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		try {
			PreparedStatement ps=con.prepareStatement("insert into login2 values(?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			int k=ps.executeUpdate();
			if(k>=0){
				pw.println("Registration Sucessfull");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
                rd.include(req, res);
			}
			else {
				pw.println("Registeration unsucessfull");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
