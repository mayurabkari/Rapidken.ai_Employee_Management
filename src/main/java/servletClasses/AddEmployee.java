package servletClasses;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addEmployee")
public class AddEmployee extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String firstName= req.getParameter("fN");
		String lastName=req.getParameter("lN");
		double salary= Double.parseDouble(req.getParameter("sal"));
		String dept=req.getParameter("dept");
		String position=req.getParameter("pos");
		String email=req.getParameter("email");
		long con=Long.parseLong(req.getParameter("con"));
		String pic=req.getParameter("pic");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/rapidken.ai","root","root");
			PreparedStatement ps =con1.prepareStatement("insert into em(first_name,last_name,salary,department,position,email,contact_no,picture) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setDouble(3, salary);
			ps.setString(4, dept);
			ps.setString(5, position);
			ps.setString(6, email);
			ps.setLong(7, con);
			ps.setString(8, pic);
			ps.execute();
			con1.close();
			
			RequestDispatcher rd=req.getRequestDispatcher("/viewAllEmployee");
			rd.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
