package fr.imie.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcrowdfunder.dao.DaoFactory;
import fr.imie.supcrowdfunder.entity.Project;


@WebServlet(urlPatterns="/showProjects")
public class ShowProjectsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> projects = DaoFactory.getJpaProjectDao().showAllProjects();
		
		req.setAttribute("projects", projects);
		req.setAttribute("page", "showProjects");
		
		RequestDispatcher rd = req.getRequestDispatcher("/showProjects.jsp");
		rd.forward(req, resp);
	}
}
