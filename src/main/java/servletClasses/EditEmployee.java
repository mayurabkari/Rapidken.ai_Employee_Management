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

import com.mysql.cj.protocol.Resultset;

@WebServlet("/editEmployee")
public class EditEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
		    String id=req.getParameter("id");
		   
		   
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/rapidken.ai","root","root");
			PreparedStatement ps=con1.prepareStatement("select * from em where id=?");
			ps.setString(1, id);
			ResultSet rs1=ps.executeQuery();
			
			rs1.next();
			
			
			
			
			  HttpSession hs=req.getSession();
			  hs.setAttribute("1",rs1);
			  
			
			
			RequestDispatcher rd=req.getRequestDispatcher("UpdateEMP.jsp");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
