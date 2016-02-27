package fr.imie.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcrowdfunder.dao.DaoFactory;
import fr.imie.supcrowdfunder.entity.Category;

@WebServlet(urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		if (name != null || description != null){
			Category category = new Category();
			category.setName(name);
			category.setDescription(description);
			DaoFactory.getJpaCategoryDao().addCategory(category);
			req.setAttribute("validation", "Category successfully added");
			RequestDispatcher rd = req.getRequestDispatcher("/showProjects.jsp");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
			req.setAttribute("error", "Error : field are empty");
			rd.forward(req, resp);
		}
		
	}

}
