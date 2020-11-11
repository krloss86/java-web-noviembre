package ar.com.educacionit.repository;

import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicateException;
import ar.com.educacionit.exceptions.GenericExeption;

public interface ProductoRepository {

	public Producto insert(Producto producto) throws DuplicateException, GenericExeption;

	public List<Producto> findAll() throws GenericExeption;

	public Producto getByCodigo(String codigo) throws GenericExeption;

	public Producto getById(Long id) throws GenericExeption;

	public Producto update(Producto producto) throws GenericExeption;

	public Producto delete(String codigoProducto) throws GenericExeption;

	public List<Producto> search(String desripcion) throws GenericExeption;
}
