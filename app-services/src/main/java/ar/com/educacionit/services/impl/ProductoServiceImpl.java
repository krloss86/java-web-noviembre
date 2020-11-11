package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.exceptions.DuplicateException;
import ar.com.educacionit.exceptions.GenericExeption;
import ar.com.educacionit.repository.ProductoRepository;
import ar.com.educacionit.repository.impl.ProductoRepositoryImpl;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository productoRepository;
	//private TipoProductoRepository tipoProductoRepository;
	
	//contructor
	public ProductoServiceImpl() {
		this.productoRepository = new ProductoRepositoryImpl();
	}
	
	//metodos de acceso a los repositorios
	
	public Producto crearProducto(Producto producto) throws ServiceException {
		try {
			return this.productoRepository.insert(producto);
		} catch (DuplicateException e) {
			throw new ServiceException("Producto duplicado " + e.getMessage(), e);
		} catch (GenericExeption e) {
			throw new ServiceException("No se ha podido cerar el producto", e);		
		}
	}

	@Override
	public List<Producto> findProductos() throws ServiceException {
		try {
			return this.productoRepository.findAll();
		} catch (GenericExeption e) {
			throw new ServiceException("No se ha podido obtener el listado de productos", e);
		}
	}

	@Override
	public Producto getProductoByCodigo(String codigo) throws ServiceException {
		try {
			return this.productoRepository.getByCodigo(codigo);
		} catch (GenericExeption e) {
			throw new ServiceException("No se ha podido obtener el producto con codigo="+ codigo, e);
		}
	}

	@Override
	public Producto getProductoById(Long id) throws ServiceException {
		try {
			return this.productoRepository.getById(id);
		} catch (GenericExeption e) {
			throw new ServiceException("No se ha podido obtener el producto con id="+ id, e);
		}
	}

	@Override
	public Producto updateProducto(Producto producto) throws ServiceException {
		try {
			return this.productoRepository.update(producto);
		} catch (GenericExeption e) {
			throw new ServiceException("No se pudo actualizar el producto",e);
		}
	}

	@Override
	public Producto eliminarProducto(String codigoProducto) throws ServiceException {
		try {
			return this.productoRepository.delete(codigoProducto);
		} catch (GenericExeption e) {
			throw new ServiceException("No se pudo eliminar el producto",e);
		}
	}

	@Override
	public List<TipoProducto> findTipoProductos() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findProductosByDescripcion(String desripcion) throws ServiceException {
		try {
			return this.productoRepository.search(desripcion);
		} catch (GenericExeption e) {
			throw new ServiceException("No se pudo obtener resultados",e);
		}
	}
}
