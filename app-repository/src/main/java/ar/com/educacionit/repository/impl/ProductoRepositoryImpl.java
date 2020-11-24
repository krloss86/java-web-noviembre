package ar.com.educacionit.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.exceptions.DuplicateException;
import ar.com.educacionit.exceptions.GenericExeption;
import ar.com.educacionit.repository.ProductoRepository;
import ar.com.educacionit.repository.hibernate.HibernateBaseRepository;

public class ProductoRepositoryImpl extends HibernateBaseRepository implements ProductoRepository {

	public ProductoRepositoryImpl() {
		super();
	}
	
	@Override
	public Producto insert(Producto producto) throws DuplicateException, GenericExeption{
		
		Session session = factory.getCurrentSession();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			session.saveOrUpdate(producto);
			
			// Commit data.
			session.getTransaction().commit();
		}catch (ConstraintViolationException e) {
			session.getTransaction().rollback();
			throw new DuplicateException(e.getCause().getMessage(),e);
		} catch (Exception e) {
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(),e);
		}finally {
			session.close();
		}
		return producto;
	}

	@Override
	public List<Producto> findAll() throws GenericExeption {
		
		Session session = factory.getCurrentSession();

		List<Producto> products = new ArrayList<Producto>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Producto.class.getName() + " e ";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			// Execute query.
			products = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption("Error consulando lista de productos",e);
		}finally {
			session.close();
		}
		
		return products;
	}

	@Override
	public Producto getByCodigo(String codigo) throws GenericExeption {
		
		Session session = factory.getCurrentSession();

		Producto producto = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select producto from " + Producto.class.getName() + " producto where producto.codigo=:codigo ";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			query.setParameter("codigo", codigo);

			// Execute query.
			Optional<Producto> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				producto = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}finally {
			session.close();
		}
		
		return producto;
	}

	@Override
	public Producto getById(Long id) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Producto producto = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select producto from " + Producto.class.getName() + " producto where producto.id=:id";

			
			// Producto p = session.get(Producto.class, id);
			
			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			query.setParameter("id", id);

			// Execute query.
			Optional<Producto> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				producto = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		} finally {
			session.close();
		}
		
		return producto;
	}

	@Override
	public Producto update(Producto producto) throws GenericExeption {
		try {
			// return createProducto(producto);
			Session session = factory.getCurrentSession();

			try {
				// All the action with DB via Hibernate
				// must be located in one transaction.
				// Start Transaction.
				session.getTransaction().begin();

				// Create an HQL statement, query the object.
				String sql = "Select e from " + Producto.class.getName() + " e where e.codigo=:codigo ";

				// Create Query object.
				Query<Producto> query = session.createQuery(sql);
				
				query.setParameter("codigo", producto.getCodigo());

				// Execute query.
				Optional<Producto> productoOptional = query.uniqueResultOptional();

				Producto productoBean = null;
				if(productoOptional.isPresent()) {
					productoBean = productoOptional.get();
					productoBean.setTitulo(producto.getTitulo());
					productoBean.setPrecio(producto.getPrecio());
					productoBean.setTipoProducto(producto.getTipoProducto());
				}

				session.saveOrUpdate(productoBean);
				
				// Commit data.
				session.getTransaction().commit();
			}catch (ConstraintViolationException e) {
				session.getTransaction().rollback();
				throw new DuplicateException(e.getCause().getMessage(),e);
			} catch (Exception e) {
				// Rollback in case of an error occurred.
				session.getTransaction().rollback();
				throw new GenericExeption(e.getMessage(),e);
			}finally {
				session.close();
			}
			return producto;
		} catch (DuplicateException e) {
			throw new GenericExeption(e.getMessage(), e);
		}
	}

	@Override
	public Producto delete(String codigoProducto) throws GenericExeption {
		Producto producto = getByCodigo(codigoProducto);

		Session session = factory.getCurrentSession();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();
			
			session.remove(producto);
			
			// Commit data.
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(),e);
		}finally {
			session.close();
		}
		return producto;
	}

	@Override
	public List<Producto> search(String desripcion) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Producto> productos = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Producto.class.getName() + " e where UPPER(e.titulo) like :descripcion";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			query.setParameter("descripcion", "%"+desripcion.toUpperCase()+"%");
			
			// Execute query.
			productos = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage());
		}finally {
			session.close();
		}
		
		return productos;
	}
	
	@Override
	public List<TipoProducto> findTipoProductos() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<TipoProducto> tipoProductos = new ArrayList<TipoProducto>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + TipoProducto.class.getName() + " e ";

			// Create Query object.
			Query<TipoProducto> query = session.createQuery(sql);

			// Execute query.
			tipoProductos = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return tipoProductos;	}
}
