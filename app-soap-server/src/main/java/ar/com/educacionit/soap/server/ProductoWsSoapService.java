package ar.com.educacionit.soap.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.soap.dto.CreateProductoDTO;
import ar.com.educacionit.soap.exceptions.DuplicatesSoapException;
import ar.com.educacionit.soap.exceptions.WSSoapException;

@WebService
public interface ProductoWsSoapService {

	@WebMethod
	public Producto createProducto(CreateProductoDTO createProductoRequest) throws DuplicatesSoapException, WSSoapException; 
	
	@WebMethod 
	public List<Producto> listAll() throws WSSoapException;
	
	@WebMethod
	public Producto getProductoByCodigo(String codigo) throws WSSoapException;
	
	@WebMethod
	public Producto eliminarProducto(String codigo) throws WSSoapException;
}
