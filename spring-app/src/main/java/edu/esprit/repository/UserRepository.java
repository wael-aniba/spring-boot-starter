package edu.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.esprit.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByLogin(String login);
}
