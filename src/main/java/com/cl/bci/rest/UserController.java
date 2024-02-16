package com.cl.bci.rest;

import java.util.ArrayList;
import java.util.List;

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

import com.cl.bci.model.User;
import com.cl.bci.service.InterfaceUserService;
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
	private InterfaceUserService userService;

	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		LOG.info("se ejecuta createUser()");
		try {

			boolean existMail = userService.getUserByEmail(user.getEmail());

			if (existMail) {
				System.err.println("El correo ya registrado");
				LOG.error("El correo ya registrado");
				throw new Exception("El correo ya registrado");
			}

			user.setCreated(Utils.dateFormat());

			return userService.createuser(user);

		} catch (Exception e) {
			LOG.error("Error crear user");
			return new User();
		}

	}

	@GetMapping
	public List<User> getAllUsers() {
		LOG.info("se ejecuta AllUsers()");
		try {

			return userService.getAllUsers();

		} catch (Exception e) {
			LOG.error("Error en consulta lista user");
			return new ArrayList<User>();
		}
	}

	@GetMapping("{id}")
	public User searchUserById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta searchUser()");
		try {

			return userService.getUserById(id);

		} catch (Exception e) {
			LOG.error("Error en consulta searchUser");
			return new User();
		}
	}

	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta deleteUser()");
		try {

			userService.deleteUser(id);

		} catch (Exception e) {
			LOG.error("Error en consulta deleteUser");
		}
	}

	@PostMapping("{id}")
	public String updateUser(@Valid @RequestBody User user, @PathVariable(value = "id", required = true) Long id) {
		LOG.info("se ejecuta updateUser()");
		try {
			userService.updateUser(user, id);

		} catch (Exception e) {
			LOG.error("Error al actualizar user");
			return "actualizar user NOK";
		}
		return "actualizar user OK";
	}

}
