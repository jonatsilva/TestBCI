package com.cl.bci.service;

import com.cl.bci.model.User;

public interface InterfaceUserService {

	public User createuser(User user);

	public User getUserById(Long id);

	public void deleteUser(Long id);

	public void updateUser(User user, Long id);

	public boolean getUserByEmail(String email);

}
