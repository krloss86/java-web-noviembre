package ar.com.educacionit.jsf.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Named
@ViewScoped
public class TipoProductoBean implements Serializable {

	private static final long serialVersionUID = 1425315121347858749L;
	
	private ProductoService ps = new ProductoServiceImpl();
	
	private List<TipoProducto> tipoProductos;
	
	@PostConstruct
	public void loadTipoProducto() {
		try {
			this.tipoProductos = this.ps.findTipoProductos();
		} catch (ServiceException e) {
			e.printStackTrace();
			tipoProductos = new ArrayList<TipoProducto>();
		}
	}
	
	public TipoProducto[] getTipoProductos() {
		return this.tipoProductos.toArray(new TipoProducto[] {});
	}
}
