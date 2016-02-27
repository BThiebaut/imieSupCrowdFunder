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
import fr.imie.supcrowdfunder.entity.Category;
import fr.imie.supcrowdfunder.entity.Project;

@WebServlet(urlPatterns="/auth/addProject")
public class AddProjectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Category> catList = DaoFactory.getJpaCategoryDao().showAllCategories();
		req.setAttribute("categories", catList);
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String objective = req.getParameter("objective");
			String category = req.getParameter("category");
			String id_creator = req.getParameter("idcreator");
			
			if (id_creator.isEmpty()){
				resp.sendRedirect("/SupCrowdFunder/login?action=sign");
			}else{	
				if (name != null || description != null || objective != null || category != null || id_creator != null){
					
					Project p = new Project();
					Category cat = DaoFactory.getJpaCategoryDao().findCategory(Long.valueOf(category));
					p.setName(name);
					p.setDescription(description);
					p.setObjective(Integer.valueOf(objective));
					p.setFownd(0.0);
					p.setCategory(cat);
					p.setId_creator(Long.valueOf(id_creator));
					DaoFactory.getJpaProjectDao().addProject(p);
					req.setAttribute("validation", "Project successfully added");
					RequestDispatcher rd = req.getRequestDispatcher("/showProjects.jsp");
					rd.forward(req, resp);
					
				}
				
			}
			List<Category> catList = DaoFactory.getJpaCategoryDao().showAllCategories();
			req.setAttribute("categories", catList);
			RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
			rd.forward(req, resp);
		}catch (Exception e){
			// IF this is showing, is because I don't resolve the problem before the deadline.
			RequestDispatcher rd = req.getRequestDispatcher("/debug.jsp");
			rd.forward(req, resp);
		}
	}
	
}
