package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.sql.*;


/**
 * Entity implementation class for Entity: sharedPost
 *
 */
@Entity

public class sharedPost implements Serializable {

	   
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String content;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
    @ManyToOne
    private Post posts;
    @ManyToOne
    private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	public sharedPost() {
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
   
}
