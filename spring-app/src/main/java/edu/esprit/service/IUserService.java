package edu.esprit.service;

import java.util.List;

import edu.esprit.domain.entity.User;

public interface IUserService {

	User saveOrUpdate(User user);

	List<User> retrieveAll();

}
