package ar.com.educacionit.jsf.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Named
@RequestScoped
public class ProductoBean {

	private ProductoService ps = new ProductoServiceImpl();
	
	private String mensajeError;
	
	private Producto producto = new Producto();
	
	public List<Producto> findProductos() {
		try {
			return this.ps.findProductos();
		} catch (ServiceException e) {
			this.mensajeError = e.getCause().getMessage();
			return new ArrayList<Producto>();
		}
	}
	
	public String updateProducto() {
		
		String target = "listado-productos?feces-redirect=true";
		try {
			this.ps.updateProducto(this.producto);
		} catch (ServiceException e) {
			this.mensajeError = e.getCause().getMessage();
			target = "editar-producto";
		}
		return target;
	}
	
	/**
	 * Realiza el update del producto
	 * @param codigo
	 * @return
	 */
	public String editarProducto(String codigo) {
		String target = "editar-producto";
		try {
			this.producto = this.ps.getProductoByCodigo(codigo);
		} catch (ServiceException e) {
			target = "listado-productos";
		}
		return target;
	}

	public String crearNuevoProducto() {
		String target = "listado-productos";
		try {
			this.ps.crearProducto(this.producto);
		} catch (ServiceException e) {
			this.mensajeError = e.getCause().getMessage();
			target = "nuevo-producto";
		}
		return target;
	}
	
	public String nuevoProducto() {
		return "nuevo-producto";
	}
	
	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
