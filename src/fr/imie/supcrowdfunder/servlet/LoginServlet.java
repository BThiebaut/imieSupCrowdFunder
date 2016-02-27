package fr.imie.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.supcrowdfunder.dao.DaoFactory;
import fr.imie.supcrowdfunder.entity.User;


@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.contains("create")) {
			req.setAttribute("create", "true");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}else if (action.contains("signout")) {
			HttpSession session = req.getSession();
			req.removeAttribute("user");
			session.removeAttribute("user");
			
			resp.sendRedirect("/SupCrowdFunder/showProjects");
			
		}else {
			req.setAttribute("sign", "true");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.contains("sign")){
			if (req.getParameter("mail") != null && req.getParameter("password") != null){
				
				User user = DaoFactory.getJpaUserDao().authUser(req.getParameter("mail"), req.getParameter("password"));
				
				if (user != null && user.getId() != null){
					HttpSession session = req.getSession();
					req.setAttribute("user", user);
					session.setAttribute("user", user);
					resp.sendRedirect("/SupCrowdFunder/showProjects");
				}else {
					System.out.println("Error in LoginServlet - line 54");
					RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
					req.setAttribute("error", "true");
					req.setAttribute("errorMsg", "User not found");
					rd.forward(req, resp);
				}
				
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}
		}else if (action.contains("create")){
			
			String firstName = req.getParameter("firstname");
			String lastName = req.getParameter("lastname");
			String eMail = req.getParameter("mail");
			String password = req.getParameter("password");
			String passwordRepeat = req.getParameter("passwordrepeat");
			
			// Field control
			if ((firstName.isEmpty() || lastName.isEmpty() || eMail.isEmpty() || password.isEmpty() || passwordRepeat.isEmpty()) || !password.equals(passwordRepeat)){
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				req.setAttribute("error", "true");
				System.out.println(firstName + " " + lastName  + " " + eMail  + " " + password  + " " + passwordRepeat);
				req.setAttribute("errorMsg", "Field missing or password verification fail");
				rd.forward(req, resp);
			}else {
				// Control mail user
					Boolean isUser = false;
					try {
						isUser = DaoFactory.getJpaUserDao().existUser(eMail);
					}catch (Exception e){
						// without this it generate a null pointer exception, if you have better solution ...
					}
					
				if (isUser){
					System.out.println("User already exist");
					RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
					req.setAttribute("error", "true");
					req.setAttribute("errorMsg", "User already exist");
					rd.forward(req, resp);
				}else {
					User newUser = new User();
					newUser.setFirstName(firstName);
					newUser.setLastName(lastName);
					newUser.seteMail(eMail);
					newUser.setPassword(password);
					DaoFactory.getJpaUserDao().addUser(newUser);
					
					resp.sendRedirect("/SupCrowdFunder/showProjects");
				}
			}
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			System.out.println("Error in LoginServlet - line 91");
			req.setAttribute("error", "true");
			req.setAttribute("errorMsg", "Request type not found");
			rd.forward(req, resp);
		}
		
		
		
	}
	
}
