package fr.acceis.forum.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.DAO.Topic;
import fr.acceis.forum.DAO.Utilisateur;
import fr.acceis.forum.Service.UtilisateurService;

public class RestrictionPosterFilter implements javax.servlet.Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		System.out.println("==================================\n Dans le Filtre \n ==================================\n");

		if (user!=null) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect("error");
			ServletOutputStream out = resp.getOutputStream();
		}


	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
