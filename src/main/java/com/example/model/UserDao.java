package com.example.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long>{
		
	@Transactional
	public User findByEmail(String email);
	

}
