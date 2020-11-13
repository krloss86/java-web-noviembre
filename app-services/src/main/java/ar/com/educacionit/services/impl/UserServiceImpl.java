package ar.com.educacionit.services.impl;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.GenericExeption;
import ar.com.educacionit.repository.UserRepository;
import ar.com.educacionit.repository.impl.UserHibernateRepositoryImpl;
import ar.com.educacionit.services.UserService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl() {
		this.userRepository = new UserHibernateRepositoryImpl();
	}
	
	@Override
	public User getUserByUserName(String userName) throws ServiceException {
		try {
			return this.userRepository.getUser(userName);
		} catch (GenericExeption e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
