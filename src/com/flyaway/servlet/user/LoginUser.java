package com.flyaway.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.flyaway.auth.User;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/login")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uName");
		String password = request.getParameter("password");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = cBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		
		Predicate pFUsername = cBuilder.equal(root.get("userName"), userName);
		Predicate pFPassword = cBuilder.equal(root.get("password"), password);
		Predicate pFUAndP = cBuilder.and(pFUsername, pFPassword);
		cQuery.where(pFUAndP);
		List<User> users = session.createQuery(cQuery).getResultList();
		
		
		if (users.size()==1) {
			
			User tempUser = users.get(0);
			HttpSession logiSession = request.getSession();
			logiSession.setAttribute("loged", true);
			logiSession.setAttribute("userId", tempUser.getUserId());
			
			response.sendRedirect("User/userdashboard.jsp");
			
		} else {
			request.setAttribute("error", "INCORRECT USERNAME OR PASSWORD");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("homepage.jsp");
			rDispatcher.include(request, response);
		}
		
		
		
		
		
		
		
	}

}
