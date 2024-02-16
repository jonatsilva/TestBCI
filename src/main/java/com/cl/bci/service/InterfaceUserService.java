package com.cl.bci.service;

import java.util.List;

import com.cl.bci.model.User;

public interface InterfaceUserService {

	public User createuser(User user);

	public User getUserById(Long id);

	public List<User> getAllUsers();

	public void deleteUser(Long id);

	public void updateUser(User user, Long id);

	public boolean getUserByEmail(String email);

}
