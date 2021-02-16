package address;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import addressbean.addressbean;
import registerbean.registerbean;

/**
 * Servlet implementation class address
 */
public class address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public address() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		addressbean ab=new addressbean();
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		int pcode=Integer.parseInt(request.getParameter("pcode"));
		ab.setCity(city);
		ab.setPostal(pcode);
		ab.setState(state);
		HttpSession ht=request.getSession();
		registerbean rb=(registerbean) ht.getAttribute("rb");
		//System.out.println(city+" "+pcode+" "+state+" "+rb.getId());
		rb.setAb(ab);
		DAO d=new DAO();
		try {
			int i=d.insertinaddress(rb);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
				request.setAttribute("rb", rb);
				rd.include(request, response);
			}
			else
			{
				PrintWriter pw=response.getWriter();
				pw.print("Something went wrong");
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
