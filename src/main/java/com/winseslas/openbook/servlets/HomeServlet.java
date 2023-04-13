package com.winseslas.openbook.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winseslas.openbook.beans.Testimonial;
import com.winseslas.openbook.beans.models.Documents;
import com.winseslas.openbook.beans.models.DocumentType;
import com.winseslas.openbook.beans.models.Author;
import com.winseslas.openbook.beans.models.PublishingHouse;
import com.winseslas.openbook.beans.repository.DocumentsRepository;
import com.winseslas.openbook.beans.repository.DocumentTypeRepository;
import com.winseslas.openbook.beans.repository.AuthorRepository;
import com.winseslas.openbook.beans.repository.PublishingHouseRepository;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Testimonial> testimonials = new ArrayList<>();
        
		testimonials.add(new Testimonial("https://mobirise.com/extensions/levelm4/assets/images/face3.jpg", 
	                "Martin Sboga", 
	                "Écrivain", 
	                4, 
	                "Je viens souvent dans cette librairie pour trouver l'inspiration pour mes livres. Le choix est excellent et le personnel est toujours prêt à aider.")
	        );
		
		testimonials.add(new Testimonial("https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp",                     "Sophie Moussa", 
                "Professeur de lettres", 
                3, 
                "J'ai récemment acheté un livre sur la philosophie qui m'a passionnée. La librairie offre   une vaste sélection de livres et le personnel est très compétent.")
        );
        
                
        testimonials.add(new Testimonial("https://img.freepik.com/free-photo/worldface-ugandan-man-white-background_53876-14474.jpg?w=360&t=st=1680533287~exp=1680533887~hmac=3972f7682f8c2444cf1b0df1c7d273754181d37d766164ba9e7108e444c52b90", 
                "Aboubakar Tapawa Balleiwa", 
                "Ingénieur logiciel", 
                3, 
                "J'ai travaillé avec OpenBook pendant deux ans et j'ai été impressionné par leur engagement envers la qualité et la satisfaction du client.")
        );

        List<Documents> documents = new ArrayList<>();
        List<DocumentType> documentsTypes = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<PublishingHouse> publishingHouses = new ArrayList<>();
      
        try {
            DocumentsRepository documentsRepository = new DocumentsRepository();
            DocumentTypeRepository documentTypeRepository = new DocumentTypeRepository();
            AuthorRepository authorRepository = new AuthorRepository();
            PublishingHouseRepository publishingHouseRepository = new PublishingHouseRepository();
            

            documents = documentsRepository.findAll();
            documentsTypes = documentTypeRepository.findAll();
            authors = authorRepository.findAll();
            publishingHouses = publishingHouseRepository.findAll();
            
            Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());
            LOGGER.info("Data loaded successfully.");
            
//            for (Author doc : authors) {
//                System.out.println("Auteur : " + doc.getName());
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("authors", authors);
        request.setAttribute("publishingHouses", publishingHouses);
        request.setAttribute("types", documentsTypes);
        request.setAttribute("documents", documents);
        request.setAttribute("testimonials", testimonials);
       
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Home.jsp");
		rd.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String title = request.getParameter("title");
	    String author = request.getParameter("author");
	    String type = request.getParameter("type");
	    String publishing_house = request.getParameter("publishing_house");

	    List<Documents> documents = new ArrayList<>();
	    
	    System.out.println("Title: " + title);
	    System.out.println("Author: " + author);
	    System.out.println("Type: " + type);
	    System.out.println("Publishing House: " + publishing_house);

	    try {
	        DocumentsRepository documentsRepository = new DocumentsRepository();
	        documents = documentsRepository.findByFilters(title, author, type, publishing_house);
	        
	        for (Documents doc : documents) {
	        	System.out.println("Livre : " + doc.getTitle());
	        	System.out.println("Maison de publication : " + doc.getPublishingHouse().getName());
	        	System.out.println("Auteur : " + doc.getAuthor().getName());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    request.setAttribute("documents", documents);
	    
	    this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
	}


}