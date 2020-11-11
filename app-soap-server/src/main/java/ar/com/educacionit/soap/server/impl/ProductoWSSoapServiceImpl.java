package ar.com.educacionit.soap.server.impl;

import java.util.List;

import javax.jws.WebService;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.soap.dto.CreateProductoDTO;
import ar.com.educacionit.soap.exceptions.WSSoapException;
import ar.com.educacionit.soap.server.ProductoWsSoapService;

@WebService(endpointInterface = "ar.com.educacionit.soap.server.ProductoWsSoapService")
public class ProductoWSSoapServiceImpl implements ProductoWsSoapService {

	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	public Producto createProducto(CreateProductoDTO createProductoRequest) throws WSSoapException {
		
		// ProductoService productoService = new ProductoServiceImpl();
		
		Producto productoBean =  new Producto();
		productoBean.setCodigo(createProductoRequest.getCodigo());
		productoBean.setTitulo(createProductoRequest.getDescripcion());
		productoBean.setPrecio(createProductoRequest.getPrecio());
		
		TipoProducto tp = new TipoProducto();
		tp.setId(createProductoRequest.getTipoProductoId());
		productoBean.setTipoProducto(tp);
		
		try {
			productoService.crearProducto(productoBean);
			return productoBean;
		} catch (ServiceException e) {
			throw new WSSoapException(e.getMessage(), e);
		}
	}

	@Override
	public List<Producto> listAll() throws WSSoapException {	
		
		try {
			List<Producto> productos = this.productoService.findProductos();
			
			return productos;
		} catch (ServiceException e) {
			//log4j
			//logback
			//slf4
			e.printStackTrace();
			throw new WSSoapException(e.getMessage(), e);
		}
	}
	
	@Override
	public Producto getProductoByCodigo(String codigo) throws WSSoapException {
		
		try {
			return this.productoService.getProductoByCodigo(codigo);
		} catch (ServiceException e) {
			//log
			e.printStackTrace();
			throw new WSSoapException(e.getMessage());
		}
		
	}

	@Override
	public Producto eliminarProducto(String codigo) throws WSSoapException {
		try {
			return this.productoService.eliminarProducto(codigo);
		} catch (ServiceException e) {
			throw new WSSoapException(e.getMessage());		
		}
	}
}
