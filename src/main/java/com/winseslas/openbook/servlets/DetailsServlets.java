package com.winseslas.openbook.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailsServlets
 */
@WebServlet("/DetailsServlets")
public class DetailsServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/index.jsp");
		rd.forward(request, response);
	}

}
