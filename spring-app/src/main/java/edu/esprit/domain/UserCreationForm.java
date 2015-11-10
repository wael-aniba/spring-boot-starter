package edu.esprit.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCreationForm {

	private Integer id;
	@NotEmpty
	@Size(min = 3, max = 45)
	private String name;
	@NotEmpty
	@Size(min = 3, max = 45)
	private String login;
	@NotEmpty
	@Size(min = 3, max = 45)
	private String password1;
	@NotEmpty
	@Size(min = 3, max = 45)
	private String password2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
