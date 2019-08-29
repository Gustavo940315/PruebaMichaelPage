package com.page.springboot.app.apirest.service;

import java.util.List;

import com.page.springboot.app.pojo.UserTO;

public interface IManagerUserService {

	public List<UserTO> listarUsuario();
	
	public String crearUsuario(UserTO usuario);
	
	public String actualizarUsuario(UserTO usuario);
	
	public String elimnarUsuario(int identificacion);
}
