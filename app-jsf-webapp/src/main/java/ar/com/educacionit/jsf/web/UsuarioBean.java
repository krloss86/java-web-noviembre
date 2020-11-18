package ar.com.educacionit.jsf.web;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean()
@RequestScoped
public class UsuarioBean {

	public boolean logueado() {
		
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//ctrl+shitf+i
		return sessionMap.containsKey(UsuarioEnum.KEY_USUARIO.name());
	}
	
	public String logout() {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		sessionMap.remove(UsuarioEnum.KEY_USUARIO.name());
		
		return "login";
	}
}
