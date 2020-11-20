package ar.com.educacionit.web.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.jsf.web.managedbeans.UsuarioBean;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilte implements Filter {

	@Inject
	private UsuarioBean usuarioBean;
	
	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);

		final List<String> resources = Arrays.asList("javax.faces.resource");
		
		final List<String> excludedPath = Arrays.asList(
				contextPath+ "/index.xhtml",
				contextPath+"/login.xhtml", 
				contextPath+"/notLogged.xhtml", 
				req.getContextPath() + "/" 
		);

		boolean isExcluded = excludedPath.stream()
				// .peek(x ->System.out.println(x))
				.filter(x -> uri.equals(x)).count() > 0;

		boolean isResources = resources.stream()
				// .peek(x ->System.out.println(x))
				.filter(x -> uri.contains(x)).count() > 0;

		if(isExcluded || isResources) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
				
			if (session == null) {
				this.context.log("Unauthorized access request");
				res.sendRedirect(req.getContextPath()+"/notLogged.xhtml");
			} else {
				
				User loggedUser = this.usuarioBean.getUsuario();
				
				if(loggedUser != null) {
					// pass the request along the filter chain
					chain.doFilter(request, response);
				}else {
					this.context.log("Unauthorized access request");
					res.sendRedirect(req.getContextPath()+"/notLogged.xhtml");
				}
			}
		}
	}

	public void destroy() {
		// Nothing to do here!
	}	
	
}