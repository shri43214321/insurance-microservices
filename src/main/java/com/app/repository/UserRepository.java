package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * @EntityGraph(attributePaths = {"address"}) // or "addresses" Optional<User>
	 * findById(Long id);
	 */
}
