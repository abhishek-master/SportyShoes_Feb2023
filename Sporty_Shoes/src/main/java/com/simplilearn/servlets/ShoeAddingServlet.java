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

import com.simplilearn.entity.Shoes;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ShoeAddingServlet
 */
@WebServlet("/add-shoes")
public class ShoeAddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeAddingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ; 
		response.setContentType("text/html") ;
	
    	String name = request.getParameter("name") ;
		int type =Integer.valueOf( request.getParameter("type")) ;

		Shoes shoe = new Shoes() ;
		shoe.setCategory(type) ;
		shoe.setName(name) ;
		
		SessionFactory sf = HibernateUtil.buildSessionFactory() ;
		Session session = sf.openSession() ; 
		
		Transaction txn = session.beginTransaction() ;
		session.save(shoe) ;
		txn.commit() ;
		
		session.close() ;
		
		request.getRequestDispatcher("newarrivals.html").include(request, response);
		out.println("Shoe added successfully") ;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
