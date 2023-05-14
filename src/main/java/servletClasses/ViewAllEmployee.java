package servletClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.protobuf.Service;

@WebServlet("/viewAllEmployee")
public class ViewAllEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rapidken.ai","root","root");
			PreparedStatement ps=con.prepareStatement("select * from em");
			 ResultSet rs=ps.executeQuery();
			   HttpSession hs=((HttpServletRequest) req).getSession();
				hs.setAttribute("employeetlist", rs);
				RequestDispatcher rd=req.getRequestDispatcher("ViewEmployee.jsp");
				rd.forward(req, resp);
			  
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
