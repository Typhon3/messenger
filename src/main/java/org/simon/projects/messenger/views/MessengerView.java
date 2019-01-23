package org.simon.projects.messenger.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.simon.projects.messenger.beans.Message;
import org.simon.projects.messenger.beans.User;
import org.simon.projects.messenger.services.MessageService;
import org.simon.projects.messenger.services.UserService;

@ManagedBean(name = "messengerView")
@SessionScoped
public class MessengerView {

	private List<Message> messages;
	private long userId;
	private String messageContent;
	
	@ManagedProperty("#{msgService}")
	private MessageService msgService;


	
	@PostConstruct
    public void init() {
        messages = msgService.getAllMessages();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession(false);
		userId = (long) session.getAttribute("userId");

    }
	

	public String makeMessage() {
		Message msg = new Message();
		msg.setContent(messageContent);
		User user = new User();
		user.setId(userId);
		msg.setUser(user);
		msgService.addMessage(msg);
		messages.add(msg);
		setMessageContent(null);
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("http://localhost:8080/messenger/faces/Messenger.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Messenger.xhtml";
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public MessageService getMsgService() {
		return msgService;
	}

	public void setMsgService(MessageService msgService) {
		this.msgService = msgService;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	
	
	
	
	
}
