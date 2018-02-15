package fr.acceis.forum.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.DAO.Topic;
import fr.acceis.forum.DAO.Utilisateur;
import fr.acceis.forum.Service.UtilisateurService;

public class NewTopicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/newTopic.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		ServletOutputStream out = resp.getOutputStream();
		HttpSession session = req.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		System.out.println("Dans la NewTopicServlet");


		Topic topic = UtilisateurService.posterNewTopic(user, title, content);
		resp.sendRedirect("/forum/home");


	}
}

