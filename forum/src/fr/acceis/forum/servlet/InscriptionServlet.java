package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.acceis.forum.Service.UtilisateurService;



@SuppressWarnings("serial")
public class InscriptionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("username");
		String pwd = req.getParameter("password");
		String mail = req.getParameter("email");

		UtilisateurService.ecrireEnBase(login, pwd, mail);
		//ServletOutputStream out = resp.getOutputStream();
		System.out.println("Inscription OK");
		resp.sendRedirect("/forum/home");
	}

}
