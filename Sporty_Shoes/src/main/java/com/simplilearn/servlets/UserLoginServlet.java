package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.User;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/user-login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
		response.setContentType("text/html") ;
		//Populating the User object
		String name = request.getParameter("name") ;
		String mail = request.getParameter("email") ; 
		User user = new User() ;
		
		user.setName(name) ;
		user.setEmail(mail) ;
		
		//Building session factory and session
		SessionFactory sf = HibernateUtil.buildSessionFactory() ;  
		Session session = sf.openSession( ) ; 
		
		//Persisting object through Hibernate
		Transaction txn = session.beginTransaction() ;
		session.save(user) ;
		txn.commit() ;
		
		//Closing Session
		session.close() ;
		
		if(name != null && mail != null) {
			request.getRequestDispatcher("homepage.html").forward(request, response) ;
		}
		else {
			request.getRequestDispatcher("userlogin.html").include(request, response) ;
			out.println("Invalid Name or Email-Id") ;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
