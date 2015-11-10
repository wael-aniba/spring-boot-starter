package edu.esprit.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.esprit.domain.entity.User;
import edu.esprit.exception.LoginAlreadyExistsException;
import edu.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private UserRepository repo;

	@Inject
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.repo = userRepository;
	}

	@Override
	@Transactional
	public User saveOrUpdate(@NotNull @Valid User user) {

		User found = repo.findByLogin(user.getLogin());

		if (found != null)
			throw new LoginAlreadyExistsException(String.format(
					"There already exists a user with login: %s", user.getLogin()));

		return repo.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> retrieveAll() {

		return repo.findAll();
	}

}
