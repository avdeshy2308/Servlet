package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class DisplayServlet1 extends GenericServlet {

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
        	PreparedStatement ps=con.prepareStatement("Select * from product where pname=?");
        	ps.setString(1, pname);
        	ResultSet rs=ps.executeQuery();
        	while(rs.next()) {
        		pw.println("<html><head><title>Result Page</title><style>\r\n"
        				+ "html, body {\r\n"
        				+ "    height: 100%;\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "html {\r\n"
        				+ "    display: table;\r\n"
        				+ "    margin: auto;\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "body {\r\n"
        				+ "    vertical-align: middle;\r\n"
        				+ "    background-color:green\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "table {\r\n"
        				+ "   width:120%;\r\n"
        				+ "   height:30%;\r\n"
        				+ "}\r\n"
        				+ "</style></head><body>");
        pw.println("<table border=1px solidline black>");
        pw.print("<caption><h3>Result:</h3></caption>");
        pw.println("<tr><th>pcode</th><th>pname</th><th>pprice</th><th>pqty</th></tr>");
        pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
        pw.println("</table></body><html>");
        
        /*     pw.println("Product Code:" +rs.getString(1));
        pw.println("Product Name:" +rs.getString(2));
        pw.println("Product Price:"+rs.getString(3));
        pw.println("Product Quantity:" +rs.getString(4));
        pw.println("</table>");
*/
        	}
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        	}
        }