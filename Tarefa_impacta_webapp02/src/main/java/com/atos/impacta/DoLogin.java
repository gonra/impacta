package com.atos.impacta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atos.impacta.dao.AtosUserDao;
import com.atos.impacta.model.AtosUser;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/login")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AtosUserDao userDao=new AtosUserDao();
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		AtosUser usuario = new AtosUser(username,password,"-");
		boolean result = userDao.doLogin(usuario);
		
		if (result) {
			HttpSession session=request.getSession(); 
			session.setAttribute("user",username);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
        	rd.forward(request, response);
		} else {
			request.setAttribute("status","falha");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
        	rd.forward(request, response);
		}
		
	}

}
