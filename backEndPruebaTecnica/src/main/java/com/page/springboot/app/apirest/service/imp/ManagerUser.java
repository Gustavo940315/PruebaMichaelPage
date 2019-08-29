package com.page.springboot.app.apirest.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.springboot.app.apirest.service.IManagerUserService;
import com.page.springboot.app.model.dao.services.IUserService;
import com.page.springboot.app.model.entity.User;
import com.page.springboot.app.pojo.UserTO;

@Service
public class ManagerUser implements IManagerUserService{

	@Autowired
	private IUserService userService;
	
	@Override
	public List<UserTO> listarUsuario() {
		List<User> usuarios = userService.listarUsuario();
		List<UserTO>  listaUsuarios= new ArrayList<UserTO>();
		UserTO userTO = null;
		for (User usuario : usuarios) {
			userTO= new UserTO();
			if (usuario.getComplited() ==1 ) {
				userTO.setComplited(true);
			}else {
				userTO.setComplited(false);
			}
			userTO.setId(usuario.getId());
			userTO.setTitle(usuario.getTitle());
			userTO.setUserId(usuario.getUserId());
			listaUsuarios.add(userTO);
		}
		return listaUsuarios;
	}

	@Override
	public String crearUsuario(UserTO usuario) {
		String mensaje ="";
		User usuarioEntity = new User();
		
		if(usuario.isComplited()) {
			usuarioEntity.setComplited(new Byte("1") );	
		}else {
			usuarioEntity.setComplited(new Byte("0") );	
		}
		usuarioEntity.setId(usuario.getId());
		usuarioEntity.setTitle(usuario.getTitle());
		userService.save(usuarioEntity);
		mensaje ="ok";
		return mensaje;
	}

	@Override
	public String actualizarUsuario(UserTO usuario) {
		User usuarioEntity =userService.obtenerUsuario(usuario.getId());
		String mensaje;
		if(usuarioEntity ==null) {
			mensaje="No existe registro";
		}else {
			if(usuario.isComplited()) {
				usuarioEntity.setComplited(new Byte("1") );	
			}else {
				usuarioEntity.setComplited(new Byte("0") );	
			}
			usuarioEntity.setId(usuario.getId());
			usuarioEntity.setTitle(usuario.getTitle());
			userService.save(usuarioEntity);
			mensaje="ok";
		}
		return "ok";
	}

	@Override
	public String elimnarUsuario(int identificacion) {
		User usuarioEntity =userService.obtenerUsuario(identificacion);
		String mensaje;
		if(usuarioEntity ==null) {
			mensaje="No existe registro";
		}else {
			userService.eliminarUsuario(usuarioEntity);
			mensaje="ok";
		}
		
		return mensaje;
	}

}
