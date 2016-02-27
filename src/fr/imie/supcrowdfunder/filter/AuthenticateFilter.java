package fr.imie.supcrowdfunder.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.supcrowdfunder.entity.User;

@WebFilter("/auth")
public class AuthenticateFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) res;
		
		HttpSession session = httpReq.getSession();
		User user = (User) session.getAttribute("user");
		
		// I don't know why but I got errors with session Scope so I use request Scope
		User userS = (User) session.getAttribute("user");
		User userR = (User) req.getAttribute("user");
		
		if(user == null) {
			// Redirect the user to the login
			httpResp.sendRedirect("/SupCrowdFunder/login?action=sign");
		} else {
			// Call the next element
			req.setAttribute("authFolder", "true");
			
			if(userS != null) {
				session.setAttribute("user", userS);
				req.setAttribute("user", userS);
			} if (userR != null){
				session.setAttribute("user", userR);
				req.setAttribute("user", userR);
			}
			
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
