package ar.com.educacionit.jsf.web;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.services.UserService;
import ar.com.educacionit.services.impl.UserServiceImpl;

@ManagedBean()
@RequestScoped
public class LoginBean {

	private String username;
	private String password;
	private String error;
	
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
				//sesion! 
				Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(UsuarioEnum.KEY_USUARIO.name(), user);
			}else {
				target = "login";
				error = "Usuario/Password invalidos";
			}
		}catch (Exception e) {
			target = "login";
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
