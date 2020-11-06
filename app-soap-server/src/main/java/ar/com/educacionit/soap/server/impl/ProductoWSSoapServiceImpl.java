package ar.com.educacionit.soap.server.impl;

import javax.jws.WebService;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.soap.dto.CreateProductoDTO;
import ar.com.educacionit.soap.server.ProductoWsSoapService;

@WebService(endpointInterface = "ar.com.educacionit.soap.server.ProductoWsSoapService")
public class ProductoWSSoapServiceImpl implements ProductoWsSoapService {

	@Override
	public Producto createProducto(CreateProductoDTO createProductoRequest) {
		
		ProductoService productoService = new ProductoServiceImpl();
		
		Producto productoBean =  new Producto();
		productoBean.setCodigo(createProductoRequest.getCodigo());
		productoBean.setTitulo(createProductoRequest.getDescripcion());
		productoBean.setPrecio(createProductoRequest.getPrecio());
		
		TipoProducto tp = new TipoProducto();
		tp.setId(createProductoRequest.getTipoProductoId());
		productoBean.setTipoProducto(tp);
		
		productoService.crearProducto(productoBean);
		
		return productoBean;
	}

}
