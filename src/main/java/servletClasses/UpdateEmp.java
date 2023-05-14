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

@WebServlet("/UpdateEmployee")
public class UpdateEmp extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName1= req.getParameter("fN1");
		String lastName1=req.getParameter("lN1");
		double salary1= Double.parseDouble(req.getParameter("sal1"));
		String dept1=req.getParameter("dept1");
		String position1=req.getParameter("pos1");
		String email1=req.getParameter("email1");
		long con2=Long.parseLong(req.getParameter("con1"));
		String pic1=req.getParameter("pic1");
		
		HttpSession hs=req.getSession();
		ResultSet rs=(ResultSet) hs.getAttribute("1");
		int id1 = 0;
		try {
			id1 = rs.getInt(9);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/rapidken.ai","root","root");
			PreparedStatement ps =con1.prepareStatement("update em set first_name=?,last_name=?,salary=?,department=?,position=?,email=?,contact_no=?,picture=? where id=?");
			ps.setString(1, firstName1);
			ps.setString(2, lastName1);
			ps.setDouble(3, salary1);
			ps.setString(4, dept1);
			ps.setString(5, position1);
			ps.setString(6, email1);
			ps.setLong(7, con2);
			ps.setString(8, pic1);
			ps.setInt(9, id1);
			ps.execute();
			
			RequestDispatcher rd=req.getRequestDispatcher("/viewAllEmployee");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
	

