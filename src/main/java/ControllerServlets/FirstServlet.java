package ControllerServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UtilsAPI.CRUDUtils;
import pOJOs.User;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/user")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CRUDUtils apis = new CRUDUtils();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String user = request.getParameter("username");
				String pass = request.getParameter("password");
				if(!user.isEmpty() && !pass.isEmpty()) {
					apis.addUser(new User(user,pass));					
				}
				HttpSession session = request.getSession();
				session.setAttribute("userList", apis.getAllUser());
				response.sendRedirect("viewuser"); 
				
	}

}
