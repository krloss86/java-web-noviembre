package ar.com.educacionit.repository;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.GenericExeption;

public interface UserRepository {

	public User getUser(String userName) throws GenericExeption;
}
