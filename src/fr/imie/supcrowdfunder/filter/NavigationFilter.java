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

@WebFilter("/*")
public class NavigationFilter implements Filter {
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) res;
		// I don't know why but I got errors with session Scope so I use request Scope
		HttpSession session = httpReq.getSession();
		User userS = (User) session.getAttribute("user");
		User userR = (User) req.getAttribute("user");
		String page = (String) req.getAttribute("page");
		
		if(userS != null) {
			// Transmit user session to the next page if exist
			session.setAttribute("user", userS);
			req.setAttribute("user", userS);
		}else if (userR != null){
			session.setAttribute("user", userR);
			req.setAttribute("user", userR);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
