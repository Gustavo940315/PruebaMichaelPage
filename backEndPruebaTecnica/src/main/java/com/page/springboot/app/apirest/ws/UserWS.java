package com.page.springboot.app.apirest.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.springboot.app.apirest.service.IManagerUserService;
import com.page.springboot.app.pojo.UserTO;
import com.page.springboot.app.technical.CommonWS;
import com.page.springboot.app.technical.ResponseTO;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/user")
public class UserWS extends CommonWS{

private static final long serialVersionUID = 1L;
	
	@Autowired
	private IManagerUserService managerUsuario;

	@GetMapping("/listar")
	public  ResponseTO<String> listarUsuarios() {
		List<UserTO> usuarios= managerUsuario.listarUsuario();
		return   (ResponseTO<String>) buildResponse(usuarios);
	}
	
	@PostMapping("/registrar")
	public ResponseTO<String> RegistroUsuario(@RequestBody UserTO usuario)  {
		String mensaje;
		mensaje = managerUsuario.crearUsuario(usuario);
		return (ResponseTO<String>) buildResponse(mensaje);
	}

	@PutMapping("/actualizar")
	public ResponseTO<String> actualizarUsuario(@RequestBody UserTO usuario)  {
		String mensaje;
		mensaje = managerUsuario.actualizarUsuario(usuario);
		return (ResponseTO<String>) buildResponse(mensaje);
	}
 
	@DeleteMapping("/eliminar")
	public ResponseTO<String> actualizarUsuario(@Param(value = "id") int id)  {
		String mensaje;
		mensaje = managerUsuario.elimnarUsuario(id);
		return (ResponseTO<String>) buildResponse(mensaje);
	}
}
