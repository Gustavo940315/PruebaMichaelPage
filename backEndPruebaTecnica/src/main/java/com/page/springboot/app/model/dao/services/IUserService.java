package com.page.springboot.app.model.dao.services;

import java.util.List;

import com.page.springboot.app.model.entity.User;

public interface IUserService {

	public User save(User usuario);
	
	public int validarUsuario(int identificacion);
	
	public List<User> listarUsuario();
	
	public User obtenerUsuario(int identificacion);
	
	public void eliminarUsuario(User usuario);
}
