package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.empbean;
import dao.DAO;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id=Integer.parseInt(request.getParameter("empid"));
		int key=Integer.parseInt(request.getParameter("key"));
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		empbean eb=new empbean();
		eb.setEmpid(id);
		eb.setName(name);
		eb.setPassword(password);
		eb.setCountry(country);
		eb.setEmail(email);
		DAO d=new DAO();
		try {
			int i=d.update(eb,key);
			if(i>0)
			{
				request.getRequestDispatcher("display.jsp").forward(request, response);
			}
			else
			{
				PrintWriter pw=response.getWriter();
				pw.print("Updation Failed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
