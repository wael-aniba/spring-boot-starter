package edu.esprit.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.esprit.domain.UserCreationForm;
import edu.esprit.domain.entity.User;
import edu.esprit.exception.LoginAlreadyExistsException;
import edu.esprit.service.IUserService;
import edu.esprit.validator.PasswordValidator;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private IUserService service;
	private PasswordValidator passwordValidator;

	@Inject
	public UserController(IUserService userService,
			PasswordValidator passwordValidator) {

		this.service = userService;
		this.passwordValidator = passwordValidator;
	}

	@InitBinder("userCreationForm")
	public void init(WebDataBinder binder) {

		binder.addValidators(passwordValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView loadCreateUserView() {

		LOGGER.debug("Loading create-user view");
		return new ModelAndView("user-create", "userCreationForm", new UserCreationForm());

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("userCreationForm") @Valid UserCreationForm userCreationForm, BindingResult br){

		LOGGER.debug("Received request to create {}, with result={}", userCreationForm, br);
		if(br.hasErrors()){

			return "user-create";
		}

		try{

			service.saveOrUpdate(new User(userCreationForm.getName(), userCreationForm.getLogin(), userCreationForm.getPassword1()));

		}catch(LoginAlreadyExistsException ex){

			LOGGER.debug("Tried to create user with existing login: [", ex, "]");
			br.reject("user.error.duplicate.login");
			return "user-create";
		}

		return "redirect:/all";

	}


	@RequestMapping(value = "/all")
	public ModelAndView loadAllUsers(){

		LOGGER.debug("Received request to get user list view");
		
		List<User> users = service.retrieveAll();
		ModelMap model = new ModelMap();
		model.addAttribute("users", users);
		return new ModelAndView("user-list", model);
	}



}
