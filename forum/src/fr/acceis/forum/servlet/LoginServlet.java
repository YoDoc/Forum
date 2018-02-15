package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.DAO.Utilisateur;
import fr.acceis.forum.Service.UtilisateurService;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("username");
		String pwd = req.getParameter("password");
		ServletOutputStream out = resp.getOutputStream();
		HttpSession session = req.getSession();

		Utilisateur user = UtilisateurService.checkerUtilisateur(login);

		if (user!=null) {
			
			String pw = user.getPassWord();
			// System.out.println("==========================================\nuser"+user+"Pw"+pw+"\n================================");

			if (pw.equals(pwd)) {
				//out.println("Authentification Réussie");
				session.setAttribute("user", user);
				session.setAttribute("name", login);
				resp.sendRedirect("/forum/home");
			} else if (!pw.equals(pwd)||(pw==null)){
				out.println("Echec d'Authentification");
				session.removeAttribute("name");

				System.out.println("essaie encore");

				resp.sendRedirect("/forum/login");						
			}

		}
		else out.println("Utilisateur non enregistré");
	}
}

