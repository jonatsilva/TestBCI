package com.cl.bci.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cl.bci.model.Phones;
import com.cl.bci.model.User;
import com.cl.bci.repository.UserRepository;
import com.cl.bci.util.Utils;

/**
 * The Class UserService.
 */
@Component
public class UserService implements InterfaceUserService {

	@Autowired
	private UserRepository userRepository;

	public User createuser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public void updateUser(User user, Long id) {

		List<Phones> listPhones = new ArrayList<Phones>();

		Optional<User> optionalUser = userRepository.findById(id);

		optionalUser.get().setName(user.getName());
		optionalUser.get().setEmail(user.getEmail());
		optionalUser.get().setPasword(user.getPasword());
		optionalUser.get().setModified(Utils.dateFormat());

		for (Phones newPhones : user.getPhones()) {

			Phones phone = new Phones();
			phone.setCitycode(newPhones.getCitycode());
			phone.setCountrycode(newPhones.getCountrycode());
			phone.setNumber(newPhones.getNumber());

			listPhones.add(phone);
		}

		optionalUser.get().setPhones(listPhones);

		userRepository.save(optionalUser.get());

	}

	
	@Override
	public boolean getUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}

}
