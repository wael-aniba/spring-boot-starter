package edu.esprit.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import edu.esprit.domain.entity.listener.UserListener;

@Entity
@EntityListeners(UserListener.class)
public class User implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -2230738295381841116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 3, max = 45)
	private String name;
	@Size(min = 3, max = 45)
	private String login;
	@Size(min = 3, max = 45)
	private String password;

	public User() {
	}

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
