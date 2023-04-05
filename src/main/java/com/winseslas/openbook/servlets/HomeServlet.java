package com.winseslas.openbook.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winseslas.openbook.beans.Testimonial;
import com.winseslas.openbook.beans.models.Author;
import com.winseslas.openbook.beans.repository.AuthorRepository;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }


	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Testimonial> testimonials = new ArrayList<>();
        
        testimonials.add(new Testimonial("https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp",                     "Sophie Moussa", 
                "Professeur de lettres", 
                3, 
                "J'ai récemment acheté un livre sur la philosophie qui m'a passionnée. La librairie offre   une vaste sélection de livres et le personnel est très compétent.")
        );
        
        
        testimonials.add(new Testimonial("https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(5).jpg", 
                "Martin Leroy", 
                "Écrivain", 
                4, 
                "Je viens souvent dans cette librairie pour trouver l'inspiration pour mes livres. Le choix est excellent et le personnel est toujours prêt à aider.")
        );
        
        testimonials.add(new Testimonial("https://img.freepik.com/free-photo/worldface-ugandan-man-white-background_53876-14474.jpg?w=360&t=st=1680533287~exp=1680533887~hmac=3972f7682f8c2444cf1b0df1c7d273754181d37d766164ba9e7108e444c52b90", 
                "Aboubakar Tapawa Balleiwa", 
                "Ingénieur logiciel", 
                3, 
                "J'ai travaillé avec OpenBook pendant deux ans et j'ai été impressionné par leur engagement envers la qualité et la satisfaction du client.")
        );
        
        List<Author> authors = null;
        AuthorRepository authorRepository;
		try {
			authorRepository = new AuthorRepository();
			authors = authorRepository.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
        
       
      
        
        request.setAttribute("testimonials", testimonials);
        request.setAttribute("auteurs", authors);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Home.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
