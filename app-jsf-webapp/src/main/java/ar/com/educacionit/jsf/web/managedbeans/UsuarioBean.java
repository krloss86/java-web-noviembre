package ar.com.educacionit.jsf.web.managedbeans;

import java.io.Serializable;
import java.util.stream.Collectors;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ar.com.educacionit.domain.User;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 9042260009965135622L;

	private User usuario;
	private String[] roles;
	
	
	public boolean logueado() {
		return this.usuario != null;
	}
	
	public String logout() {
		setUsuario(null);
		setRoles(new String[] {});
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "login?faces-redirect=true";
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
			
		this.usuario = usuario;
		
		if(usuario != null) {
			String[] rolesStr = this.usuario.getRoles()
					.stream().map(role -> role.getRole())
					.collect(Collectors.toSet())
					.toArray(new String[]{});
			
			this.roles = rolesStr;
		}
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	public String[] getUserRoles() {
		return this.usuario.getRoles()
				.stream().map(role -> role.getRole())
				.collect(Collectors.toSet())
				.toArray(new String[]{});
	}
}