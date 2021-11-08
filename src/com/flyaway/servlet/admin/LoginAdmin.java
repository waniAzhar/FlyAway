package com.flyaway.servlet.admin;

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

import com.flyaway.auth.Admin;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/adminLogin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
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
		CriteriaQuery<Admin> cQurey = cBuilder.createQuery(Admin.class);
		Root<Admin> root = cQurey.from(Admin.class);
		
		Predicate pFUsername = cBuilder.equal(root.get("userName"), userName);
		Predicate pFPassword = cBuilder.equal(root.get("password"), password);
		Predicate pFUAndP = cBuilder.and(pFUsername, pFPassword);
		cQurey.where(pFUAndP);
		
		List<Admin> admins = session.createQuery(cQurey).getResultList();
		
		if (admins.size()==1) {
			
			Admin tempAdmin = admins.get(0);
			HttpSession loginSession = request.getSession();
			loginSession.setAttribute("logedin", true);
			loginSession.setAttribute("userId", tempAdmin.getUserId());
			
			response.sendRedirect("Admin/admindashboard.jsp");
			
			
		}else {
			request.setAttribute("error", "INCORRECT USERNAME OR PASSWORD");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("admin.jsp");
			rDispatcher.include(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
