package com.page.springboot.app.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.page.springboot.app.model.entity.User;

public interface IUserDao extends CrudRepository<User, Integer>{
	@Query("SELECT COUNT(DA) FROM User DA WHERE DA.id = :id")
	public int countUsuario( @Param("id") int id);
	
	@Query("SELECT DA FROM User DA WHERE DA.id = :id")
	public User obtenerUsuario( @Param("id") int id);
}
