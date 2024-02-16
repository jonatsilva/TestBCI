package com.cl.bci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cl.bci.model.User;

/**
 * The Interface UserRepository.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT COUNT(*) =1 FROM USER WHERE EMAIL=:email", nativeQuery = true)
	boolean findByEmail(String email);

}
