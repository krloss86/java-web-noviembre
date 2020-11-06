package ar.com.educacionit.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.soap.dto.CreateProductoDTO;

@WebService
public interface ProductoWsSoapService {

	@WebMethod
	public Producto createProducto(CreateProductoDTO createProductoRequest); 
}
