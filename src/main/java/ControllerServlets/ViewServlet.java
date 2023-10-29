package ControllerServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UtilsAPI.CRUDUtils;
import pOJOs.User;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewuser")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CRUDUtils apis = new CRUDUtils();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = new ArrayList();
		HttpSession session = request.getSession();		
		Map<Integer,User> userMap = (Map<Integer,User>)session.getAttribute("userList");
		for(Map.Entry<Integer,User> m : userMap.entrySet()) {
			userList.add(m.getValue());
		}		
		request.setAttribute("userList", userList);		
		request.getRequestDispatcher("/listoutuser.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
