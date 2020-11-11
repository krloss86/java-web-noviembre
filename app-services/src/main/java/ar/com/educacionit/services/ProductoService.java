package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ProductoService {

	public Producto crearProducto(Producto producto) throws ServiceException;

	public List<Producto> findProductos() throws ServiceException;
	
	public Producto getProductoByCodigo(String codigo) throws ServiceException;
	
	public Producto getProductoById(Long id) throws ServiceException;
	
	public Producto updateProducto(Producto producto) throws ServiceException;
	
	public Producto eliminarProducto(String codigoProducto) throws ServiceException;
	
	public List<TipoProducto> findTipoProductos() throws ServiceException;
	
	public List<Producto> findProductosByDescripcion(String desripcion) throws ServiceException;
}
