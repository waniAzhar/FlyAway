package com.flyaway.servlet.admin;

import java.io.IOException;
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

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.auth.FlightData;
import com.flyaway.auth.User;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/Admin/addTicket")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String flightFrom = request.getParameter("From");
		String destination = request.getParameter("Destination");
		String date = request.getParameter("Date");
		double price = Double.parseDouble(request.getParameter("Price"));
		
		FlightData fData = new FlightData(flightFrom, destination, date, price);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(fData);
		trans.commit();
		session.close();
		
		
		
		
		
		
		
		
	}

}
