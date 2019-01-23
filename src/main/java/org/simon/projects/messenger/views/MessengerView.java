package org.simon.projects.messenger.views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.simon.projects.messenger.beans.Message;
import org.simon.projects.messenger.services.MessageService;
import org.simon.projects.messenger.services.UserService;

@ManagedBean(name = "messengerView")
@ViewScoped
public class MessengerView {

	private List<Message> messages;
	
	@ManagedProperty("#{msgService}")
	private MessageService msgService;

//	@ManagedProperty("#{userService}")
//	private UserService userService;
	
	@PostConstruct
    public void init() {
        messages = msgService.getAllMessages();
;
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
	
	
	
	
}
