package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Purchase;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/pay-ment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		response.setContentType("text.html") ;
		
		String name = request.getParameter("name") ;
		String mobile = request.getParameter("mono") ;
		String date = request.getParameter("date") ;  
		
		SessionFactory sf = HibernateUtil.buildSessionFactory() ;
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction() ;
		
	
		
		Purchase p = new Purchase() ;
		p.setName(name) ;
		p.setMobile(mobile) ;
		p.setDate(date) ;
		
		session.save(p) ;
		txn.commit() ;
		session.close() ;
		
		
		request.getRequestDispatcher("paymentsuccess.html").forward(request, response)  ;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
