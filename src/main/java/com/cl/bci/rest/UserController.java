package com.cl.bci.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.bci.model.Response;
import com.cl.bci.model.User;
import com.cl.bci.service.UserService;
import com.cl.bci.util.Utils;

/**
 * The Class ProductoController.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	/** The log. */
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping
	public Response createUser(@Valid @RequestBody User user) {
		LOG.info("se ejecuta createUser()");

		Response response = new Response();

		try {

			boolean validaMail = Utils.validaEmail(user.getEmail());

			if (!validaMail) {
				LOG.error("El formato de correo no es valido");
				response.setMessage("El formato de correo no es valido " + user.getEmail());
				return response;
			}

			boolean existMail = userService.getUserByEmail(user.getEmail());

			if (existMail) {
				LOG.error("El correo ya registrado");
				response.setMessage("El correo ya registrado");
				return response;
			}

			user.setCreated(Utils.dateFormat());

			User out = userService.createuser(user);

			response.setAst_login(out.getCreated());
			response.setCreated(out.getCreated());
			response.setModified(out.getModified());
			response.setIsactive("");
			response.setToken(out.getUuid().toString());
			response.setUuid(out.getUuid().intValue());
			response.setMessage("user creado OK");

			return response;

		} catch (Exception e) {
			LOG.error("Error crear user");
			response.setMessage("Error crear user");
			return response;

		}

	}

	@GetMapping("{id}")
	public Response searchUserById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta searchUser()");

		Response response = new Response();

		try {

			User out = userService.getUserById(id);

			response.setAst_login("");
			response.setCreated(out.getCreated());
			response.setModified(out.getModified());
			response.setIsactive("");
			response.setToken(out.getUuid().toString());
			response.setUuid(out.getUuid().intValue());
			response.setMessage("Busqueda OK id " + id);

			return response;

		} catch (Exception e) {
			LOG.error("Error en consulta searchUser");
			response.setMessage("Error en buscar user id " + id);
			return response;
		}
	}

	@DeleteMapping("{id}")
	public String deleteUserById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta deleteUser()");
		try {

			userService.deleteUser(id);

		} catch (Exception e) {
			LOG.error("Error en consulta deleteUser");
			return "Error delete user id " + id;
		}

		return "OK delete user id " + id;
	}

	@PostMapping("{id}")
	public Response updateUser(@Valid @RequestBody User user, @PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta updateUser()");

		Response response = new Response();

		try {

			boolean validaMail = Utils.validaEmail(user.getEmail());

			if (!validaMail) {
				LOG.error("El formato de correo no es valido");
				response.setMessage("El formato de correo no es valido " + user.getEmail());
				return response;
			}

			User out = userService.updateUser(user, id);

			response.setAst_login("");
			response.setCreated(out.getCreated());
			response.setModified(out.getModified());
			response.setIsactive("");
			response.setToken(out.getUuid().toString());
			response.setUuid(out.getUuid().intValue());
			response.setMessage("actualizar user OK id " + id);

			return response;

		} catch (Exception e) {
			LOG.error("Error al actualizar user");
			response.setMessage("Error al actualizar user id " + id);
			return response;
		}

	}

}
