package fr.imie.supcrowdfunder.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcrowdfunder.dao.DaoFactory;
import fr.imie.supcrowdfunder.entity.User;

@WebServlet(urlPatterns="/auth/account")
public class AccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/SupCrowdFunder/auth/account.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User)req.getAttribute("user");
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String eMail = req.getParameter("email");
		String password = req.getParameter("pw");
		String passwordRepeat = req.getParameter("pw2");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.seteMail(eMail);
		if (!password.contains("***")){
			if (password.equals(passwordRepeat)){
				
				user.setPassword(password);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/auth/account.jsp");
				req.setAttribute("error", "Password repeat not correspond");
				rd.forward(req, resp);
			}
		}
		DaoFactory.getJpaUserDao().updateUser(user);
		RequestDispatcher rd = req.getRequestDispatcher("/showProjects.jsp");
		req.setAttribute("validation", "Account successfully edited");
		rd.forward(req, resp);
		
	}
	
}
