package org.simon.projects.messenger.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="Message")
@XmlRootElement
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idMessage")
	private long id;
	
	@Column(name="content")
	private String content;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private User user;
	
	public Message() {
		
	}
	
	public Message(long id, String content) {
		this.id = id;
		this.content = content;
		this.user = new User(1, "Simon", "Leu");
		this.createdOn = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
