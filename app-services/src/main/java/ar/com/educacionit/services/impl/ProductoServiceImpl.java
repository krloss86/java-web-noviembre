package ar.com.educacionit.services.impl;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.repository.ProductoRepository;
import ar.com.educacionit.repository.impl.ProductoRepositoryImpl;
import ar.com.educacionit.services.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository productoRepository;
	//private TipoProductoRepository tipoProductoRepository;
	
	//contructor
	public ProductoServiceImpl() {
		this.productoRepository = new ProductoRepositoryImpl();
	}
	
	//metodos de acceso a los repositorios
	
	public Producto crearProducto(Producto producto) {
		return this.productoRepository.insert(producto);
	}
}
