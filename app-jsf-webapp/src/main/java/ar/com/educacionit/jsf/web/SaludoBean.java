package ar.com.educacionit.jsf.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class SaludoBean {

	public String saludar() {
		return "hola";
	}
}
