package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;

public interface ProductoService {

	public Producto getProducto(String codigo) ;

	public List<Producto> findProductos() ;

	public Producto createProducto(Producto producto) ;
	
	public Producto updateProducto(Producto producto) ;

	public Producto eliminarProducto(String codigoProducto) ;
	
	public List<TipoProducto> findTipoProductos() ;

	public List<Producto> findProductosByDescripcion(String desripcion) ;

	public Producto getProductoById(Long id);

	public void actualizarProducto(Producto producto);

	
}
