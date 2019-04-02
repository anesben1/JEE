package Entities;

import java.io.Serializable;
import java.sql.*;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {
	/* This is a comment */
	/* Another commmeeent*/

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    private Post post;
	@ManyToOne
	private User user;
	 
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User userComment) {
		this.user = userComment;
	}
	public Comment() {
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
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
   
}
