import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display
 */
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO d=new DAO();
		try {
			d.init();
			ResultSet rst=d.display();
			PrintWriter pw=response.getWriter();
			pw.print("<a href='index.html' >Go to Home</a>");
			pw.print("<table border='1' width='100%'>");
			pw.println("<h1>Employees List</h1>"); 
            pw.print("<tr><th>EMPID</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th></tr>");
			while(rst.next())
			{	                   
	            pw.print("<tr><td>"+rst.getInt(1)+"</td><td>"+rst.getString(2)+"</td><td>"+rst.getString(3)+"</td><td>"+rst.getString(4)+"</td><td>"+rst.getString(5)+"</tr>");  
			}
			 pw.print("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		DAO d=new DAO();
		try {
			d.init();
			ResultSet rst=d.display();
			PrintWriter pw=response.getWriter();
			pw.print("<a href='index.html' >Go to Home</a>");
			pw.print("<table border='1' width='100%'>");
			pw.println("<h1>Employees List</h1>"); 
            pw.print("<tr><th>EMPID</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th></tr>");
			while(rst.next())
			{	                   
	            pw.print("<tr><td>"+rst.getInt(1)+"</td><td>"+rst.getString(2)+"</td><td>"+rst.getString(3)+"</td><td>"+rst.getString(4)+"</td><td>"+rst.getString(5)+"</tr>");  
			}
			 pw.print("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
