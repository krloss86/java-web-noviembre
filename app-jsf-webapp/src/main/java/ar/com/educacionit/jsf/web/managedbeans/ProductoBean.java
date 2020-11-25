package ar.com.educacionit.jsf.web.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Named
@RequestScoped
public class ProductoBean {

	private ProductoService ps = new ProductoServiceImpl();
	
	private String mensajeError;
	
	private Producto producto = new Producto();
	 
	private Long tipoProducto;
	
	private List<Producto> productos;
	
	@PostConstruct
	public void loadProductos() {
		this.productos = findProductos();
	}
	
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
			TipoProducto nuevoTipoProducto = new TipoProducto();
			nuevoTipoProducto.setId(this.tipoProducto);
			
			this.producto.setTipoProducto(nuevoTipoProducto);
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
			TipoProducto nuevoTipoProducto = new TipoProducto();
			nuevoTipoProducto.setId(this.tipoProducto);
			
			this.producto.setTipoProducto(nuevoTipoProducto);
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
	
	public TipoProducto[] getTipoProductos() {
		TipoProducto[] tiposProductos;
		try {
			tiposProductos = this.ps.findTipoProductos()
					.stream()
					.collect(Collectors.toSet())
					.toArray(new TipoProducto[] {});
		} catch (ServiceException e) {
			tiposProductos = new TipoProducto[] {};
		}
		return tiposProductos;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	//METODOS AGREGADOS PARA AJAX: PRIMEFACES
	public void onRowEdit(RowEditEvent<Producto> event) {
		FacesMessage msg;
		Producto productoSeleccionado = event.getObject();
		try {
			if(!productoSeleccionado.getTipoProducto().getId().equals(this.tipoProducto)) {
				productoSeleccionado.getTipoProducto().setId(this.tipoProducto);
			}
			this.ps.updateProducto(productoSeleccionado);
			msg = new FacesMessage("Producto editado ", productoSeleccionado.getId().toString());
			this.productos = this.findProductos();
		} catch (ServiceException e) {
			msg = new FacesMessage(e.getMessage(), productoSeleccionado.getId().toString());
		}
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public void onRowCancel(RowEditEvent<Producto> event) {
		Producto productoSeleccionado = event.getObject();
        FacesMessage msg = new FacesMessage("Edit Cancelled", productoSeleccionado.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowSelect(SelectEvent<Producto> event) {
		this.producto = event.getObject();
    }
	
	public void eliminarProducto() {
		
		FacesMessage msg;
		try {
			this.ps.eliminarProducto(producto.getCodigo());
			msg = new FacesMessage("Producto eliminado ", producto.getId().toString());
			this.productos.remove(producto);
			this.producto = null;
		} catch (Exception e) {
			msg = new FacesMessage("Error eliminando producto", e.getMessage());
		}
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
