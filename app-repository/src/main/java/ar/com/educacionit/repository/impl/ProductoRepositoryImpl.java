package ar.com.educacionit.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.repository.ProductoRepository;
import ar.com.educacionit.repository.hibernate.HibernateUtils;

public class ProductoRepositoryImpl implements ProductoRepository {

	@Override
	public Producto insert(Producto producto) {
		
		SessionFactory sf =  HibernateUtils.getSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(producto);
		
		session.getTransaction().commit();	
		
		return producto;
	}

}
