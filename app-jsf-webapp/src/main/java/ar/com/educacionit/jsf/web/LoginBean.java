package ar.com.educacionit.jsf.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.jsf.web.managedbeans.UsuarioBean;
import ar.com.educacionit.services.UserService;
import ar.com.educacionit.services.impl.UserServiceImpl;

@Named
@RequestScoped
public class LoginBean {

	private String username;
	private String password;
	private String error;
	
	@Inject
	//ctr+shit+o
	private UsuarioBean usuarioBean;
	
	//capa de servicios
	private UserService userService = new UserServiceImpl();
	
	public String irALogin() {
		return "login";
	}
	
	public String login() {
		
		User user;
		
		String target = "login-success";
		
		try {
			user = this.userService.getUserByUserName(this.username);
			if(user != null && user.getPassword().equals(this.password)) {
				
				this.usuarioBean.setUsuario(user);
				
			}else {
				target = "login";
				error = "Usuario/Password invalidos";
			}
		}catch (Exception e) {
			target = "login-fail";
			error = e.getMessage();
		}
		
		return target;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
