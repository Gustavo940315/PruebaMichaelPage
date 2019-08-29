package com.page.springboot.app.model.dao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.springboot.app.model.dao.IUserDao;
import com.page.springboot.app.model.dao.services.IUserService;
import com.page.springboot.app.model.entity.User;

@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao ;
	
	
	@Override
	public User save(User usuario) {
		return userDao.save(usuario);
	}

	@Override
	public int validarUsuario(int identificacion) {
		return userDao.countUsuario(identificacion);
	}

	@Override
	public List<User> listarUsuario() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User obtenerUsuario(int identificacion) {
		return userDao.obtenerUsuario(identificacion);
	}

	@Override
	public void eliminarUsuario(User usuario) {
		userDao.delete(usuario);
	}
	

}
