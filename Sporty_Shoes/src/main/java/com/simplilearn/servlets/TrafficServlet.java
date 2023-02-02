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

import com.simplilearn.entity.User;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class TrafficServlet
 */
@WebServlet("/traffic-stats")
public class TrafficServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrafficServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sf = HibernateUtil.buildSessionFactory() ;
		Session session = sf.openSession() ;
		
		List<User> users = session.createQuery("from User").list();
		if(users != null && users.size() > 0) {
			PrintWriter out = response.getWriter() ;
			out.println("<h1>:: Users List ::</h1>") ;
			out.println("<style> table,td,th {border : 2px solid red} </style>");
			out.println("<table>") ;
			out.println("<th>ID</th>") ;
			out.println("<th>NAME</th>") ;
			out.println("<th>E-MAIL ID </th>");
			out.println("</tr>") ;
			int i = 1 ;
			for(User u : users) {
				out.println("<tr>");
				out.println("<td>" + i + "</td>") ;
				i++ ;
				out.println("<td>" + u.getName() +"</td>") ;
				out.println("<td>" + u.getEmail()+"</td>") ;
				
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
