package Entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.*;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	private Timestamp date;
	private String type;
	private static final long serialVersionUID = 1L;
    @ManyToOne
    private User usersSent;
	@ManyToOne 
    private User usersRecieved;
	
    public User getUsersSent() {
		return usersSent;
	}
	public void setUsersSent(User usersSent) {
		this.usersSent = usersSent;
	}
	
	public User getUsersRecieved() {
		return usersRecieved;
	}
	public void setUsersRecieved(User usersRecieved) {
		this.usersRecieved = usersRecieved;
	}
	public Message() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
   
}
