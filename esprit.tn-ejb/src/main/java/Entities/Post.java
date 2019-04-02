package Entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	@Column(columnDefinition="TEXT")
	private String content;
	private String multimedia_url;
	private Timestamp date;
	private String type;
	private static final long serialVersionUID = 1L;
    @ManyToOne(fetch= FetchType.EAGER)
    private User usersPosts;
    @OneToMany(mappedBy="post" , fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Reaction> reactions = new HashSet<>();
    @OneToMany(mappedBy="post" , fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
    
    
	

	public User getUsersPosts() {
		return usersPosts;
	}
	public void setUsersPosts(User usersPosts) {
		this.usersPosts = usersPosts;
	}
	public Post() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   

	public String getMultimedia_url() {
		return multimedia_url;
	}
	public void setMultimedia_url(String multimedia_url) {
		this.multimedia_url = multimedia_url;
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
	public Set<Reaction> getReactions() {
		return reactions;
	}
	public void setReactions(Set<Reaction> reactions) {
		this.reactions = reactions;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
   
}
