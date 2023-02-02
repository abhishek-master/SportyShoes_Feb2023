package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Purchase;

import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class PurchaseInfoServlet
 */
@WebServlet("/pur-chase")
public class PurchaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sf = HibernateUtil.buildSessionFactory() ;
		Session session = sf.openSession() ;
		
		List<Purchase> purchases = session.createQuery("from Purchase").list();
		if(purchases != null && purchases.size() > 0) {
			PrintWriter out = response.getWriter() ;
			out.println("<h1>:: Purchases ::</h1>") ;
			out.println("<style> table,td,th {border : 2px solid red} </style>");
			out.println("<table>") ;
			out.println("<th>P_id</th>") ;
			out.println("<th>NAME</th>") ;
			out.println("<th>Mobile Number</th>");
			out.println("<th>Date_Purchased</th>");
			out.println("<th>Total Amount</th>");
			out.println("</tr>") ;
			int i = 1 ;
			for(Purchase p : purchases) {
				out.println("<tr>");
				out.println("<td>" + i + "</td>") ;
				i++ ;
				out.println("<td>" + p.getName() +"</td>") ;
				out.println("<td>" + p.getMobile()+"</td>") ;
				out.println("<td>" + p.getDate() +"<td>") ;
				out.println("<td> XYZ </td >");
				
			}
		}
		
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
