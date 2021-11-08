package com.flyaway.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminAuth
 */
@WebFilter("/Admin/*")
public class AdminAuth implements Filter {

    /**
     * Default constructor. 
     */
    public AdminAuth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean isLogedIn = false;
		
if (session != null && session.getAttribute("logedin") != null && session.getAttribute("userId") != null) {
			
			isLogedIn = true;
			
		}
		
if (isLogedIn) {
	chain.doFilter(request, response);
	}else {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.sendRedirect("../admin.jsp");
	}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
