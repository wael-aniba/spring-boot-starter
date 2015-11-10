package edu.esprit.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.esprit.domain.UserCreationForm;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserCreationForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCreationForm form = (UserCreationForm) target;
		if (!form.getPassword1().equals(form.getPassword2())) {
			errors.rejectValue("password2", "user.error.password.no_match");
		}
	}

}
