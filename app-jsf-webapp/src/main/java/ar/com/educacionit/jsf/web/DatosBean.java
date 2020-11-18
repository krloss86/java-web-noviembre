package ar.com.educacionit.jsf.web;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class DatosBean {

	private List<Dato> lista;
	
	public DatosBean() {
		this.lista = new ArrayList<Dato>();
		lista.add(new Dato(1L, "Dato1"));
		lista.add(new Dato(2L, "Dato2"));
	}

	public List<Dato> getLista() {
		return lista;
	}

	public void setLista(List<Dato> lista) {
		this.lista = lista;
	}
	
	
}
