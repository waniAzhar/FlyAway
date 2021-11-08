package com.flyaway.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.flyaway.auth.User;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class SignupUser
 */
@WebServlet("/SignupUser")
public class SignupUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(userName,email,password);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = cBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		cQuery.select(root).where(cBuilder.equal(root.get("userName"),userName));
		org.hibernate.Query<User> query = session.createQuery(cQuery);
		List<User> users = query.getResultList();
		
		if(users.size() == 0) {
		Transaction trans = session.beginTransaction();
		session.save(user);
		trans.commit();
		response.sendRedirect("homepage.jsp");
		}else {
			request.setAttribute("error", "USERNAME already exists");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("signup.jsp");
			rDispatcher.include(request, response);
			
		}
		session.close();
	}

}
