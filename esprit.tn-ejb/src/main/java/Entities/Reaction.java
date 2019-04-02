package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.sql.*;

/**
 * Entity implementation class for Entity: Reaction
 *
 */
@Entity

public class Reaction implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
    
	@ManyToOne
    private User user;
	@ManyToOne
    private Post post;

	
	
	public Reaction() {
		super();
	}   
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
   
}
