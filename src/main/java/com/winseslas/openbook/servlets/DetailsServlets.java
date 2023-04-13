package com.winseslas.openbook.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winseslas.openbook.beans.models.DocumentType;
import com.winseslas.openbook.beans.models.Documents;
import com.winseslas.openbook.beans.repository.DocumentTypeRepository;
import com.winseslas.openbook.beans.repository.DocumentsRepository;

/**
 * Servlet implementation class DetailsServlets
 */
@WebServlet("/DetailsServlets")
public class DetailsServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int id;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlets() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean error = false;
        String bookId = request.getParameter("bookId");
        Documents document = null;
        List<DocumentType> documentsTypes = new ArrayList<>();

        if (isValidDocumentId(bookId)) {

            try {
                DocumentsRepository documentsRepository = new DocumentsRepository();
                DocumentTypeRepository documentTypeRepository = new DocumentTypeRepository();

                document = documentsRepository.findById(id);
                documentsTypes = documentTypeRepository.findAll();
            } catch (SQLException e) {
            	error = true;
                request.setAttribute("error", error);
                request.setAttribute("modalTitle", "Erreur");
                request.setAttribute("modalBody", "Une erreur s'est produite. Veuillez réessayer");
                request.setAttribute("modalButtonText", "OK");
                request.setAttribute("modalButtonLink", "/OpenBook/");

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Modal.jsp");
                rd.forward(request, response);
            }

            if (document != null) {
                request.setAttribute("document", document);
                request.setAttribute("categorys", documentsTypes);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Detail.jsp");
                rd.forward(request, response);
            } else {
                // Gérer le cas où le document n'est pas trouvé, par exemple en renvoyant une réponse d'erreur au client
                error = true;
                request.setAttribute("error", error);
                request.setAttribute("modalTitle", "Erreur");
                request.setAttribute("modalBody", "Le document n'a pas été trouvé. Veuillez réessayer.");
                request.setAttribute("modalButtonText", "OK");
                request.setAttribute("modalButtonLink", "/OpenBook/");

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Modal.jsp");
                rd.forward(request, response);
            }
        } else {
            error = true;
            request.setAttribute("error", error);
            request.setAttribute("modalTitle", "Erreur");
            request.setAttribute("modalBody", "ID de document invalide. Veuillez réessayer.");
            request.setAttribute("modalButtonText", "OK");
            request.setAttribute("modalButtonLink", "/OpenBook/");

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Modal.jsp");
            rd.forward(request, response);
        }
    }

    private boolean isValidDocumentId(String bookId) {
        try {
            id = Integer.parseInt(bookId);
            if (id > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        	  e.printStackTrace();
        }
        return false;
    }
}
