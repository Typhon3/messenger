package org.simon.projects.messenger.views;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simon.projects.messenger.beans.User;
import org.simon.projects.messenger.services.UserService;

@ManagedBean(name = "loginView")
@SessionScoped
public class LoginView {

	private String firstName;
	private String lastName;

	@ManagedProperty("#{userService}")
	private UserService userService;

	public void login() {

		long userId;
		userService = new UserService();
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userId = userService.addUser(user);

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = request.getSession(false);
		session.setAttribute("userId", userId);

		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("http://localhost:8080/messenger/faces/Messenger.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
