package ar.com.educacionit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.repository.ProductoRepository;
import ar.com.educacionit.repository.TipoProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	@Override
	public Producto getProducto(String codigo)  {
		return this.productoRepository.findByCodigo(codigo);
	}

	@Override
	public List<Producto> findProductos()  {
		return this.productoRepository.findAll();
	}

	@Override
	public Producto createProducto(Producto producto)  {
		return this.productoRepository.save(producto);
	}

	@Override
	public Producto updateProducto(Producto producto)  {
		return this.productoRepository.save(producto);
	}

	@Override
	public Producto eliminarProducto(String codigoProducto)  {
		Producto producto = this.getProducto(codigoProducto);
		this.productoRepository.delete(producto);
		return producto;
	}

	@Override
	public List<TipoProducto> findTipoProductos()  {
		return this.tipoProductoRepository.findAll();
	}

	@Override
	public List<Producto> findProductosByDescripcion(String desripcion)  {
		return this.productoRepository.findAllByTitulo(desripcion);
	}

	@Override
	public Producto getProductoById(Long id) {
		return this.productoRepository.getOne(id);
	}
	
	@Override
	public void actualizarProducto(Producto producto) {
		this.productoRepository.save(producto);		
	}
}
