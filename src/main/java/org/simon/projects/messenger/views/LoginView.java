package org.simon.projects.messenger.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.simon.projects.messenger.beans.User;
import org.simon.projects.messenger.services.UserService;

@ManagedBean(name = "loginView")
@ViewScoped
public class LoginView {
	
	private String firstName;
	private String lastName;
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	public String login() {

		userService = new UserService();
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userService.addUser(user);
		
		return "Messenger.xhtml";
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
