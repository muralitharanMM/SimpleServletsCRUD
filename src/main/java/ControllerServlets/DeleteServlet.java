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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteuser")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CRUDUtils apis = new CRUDUtils();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete user called ");
		List<User> userList = new ArrayList();
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();		
		Map<Integer,User> userMap = (Map<Integer,User>)session.getAttribute("userList");
		for(Map.Entry<Integer,User> m : userMap.entrySet()) {
			if(m.getValue().getUsername().equals(name)) {
				userMap.remove(m.getKey());
				System.out.println("removed");
				break;
			}
		}
		session.setAttribute("userList", userMap);
		response.sendRedirect("viewuser");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
