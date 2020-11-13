package ar.com.educacionit.repository.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.GenericExeption;
import ar.com.educacionit.repository.UserRepository;
import ar.com.educacionit.repository.hibernate.HibernateBaseRepository;

public class UserHibernateRepositoryImpl extends HibernateBaseRepository implements UserRepository {
	
	public UserHibernateRepositoryImpl() {
		super();
	}
	
	@Override
	public User getUser(String userName) throws GenericExeption {
		User User = null;
		
		Session session = super.factory.getCurrentSession();
		
		try {

			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + User.class.getName() + " e where e.username=:username ";

			// Create Query object.
			Query<User> query = session.createQuery(sql);

			//set parameters
			query.setParameter("username", userName);

			// Execute query.
			Optional<User> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				User = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return User;		
	}

}
