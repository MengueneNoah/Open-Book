package com.winseslas.openbook.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.winseslas.openbook.beans.enums.Role;
import com.winseslas.openbook.beans.models.User;
import com.winseslas.openbook.beans.repository.UserRepository;
import com.winseslas.openbook.security.SessionManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRepository userRepository;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userRepository = new UserRepository();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login.jsp");
        rd.forward(request, response);
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Connexion ");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            boolean error = true;
            request.setAttribute("error", error);
            request.setAttribute("messageError", "Veuillez remplir tous les champs.");

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login.jsp");
            rd.forward(request, response);
        } else {
            
            Optional<User> user = userRepository.findByEmailAndPassword(email, password);

            if (user.isPresent()) {
                SessionManager.setSessionAttribute(request, "user", user.get());
                response.sendRedirect(request.getContextPath() + "/DashboardServlet");
            } else {
                boolean error = true;
                request.setAttribute("error", error);
                request.setAttribute("messageError", "Adresse email ou mot de passe incorrect.");

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login.jsp");
                rd.forward(request, response);
            }
        }
    }


}
