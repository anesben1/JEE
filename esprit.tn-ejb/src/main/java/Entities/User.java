package Entities;


import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EnterpriseBean;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private int phone_number;
	private String role;
	private static final long serialVersionUID = 1L;
	
	//@OneToOne(fetch = FetchType.EAGER, mappedBy="userCondidate", cascade = CascadeType.ALL)
	//private Condidate_Profile profil;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="usersSent", cascade = CascadeType.ALL)
	private Set<Message> messagesSent = new HashSet<>() ;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="usersRecieved", cascade = CascadeType.ALL)
	private Set<Message> messagesReceived = new HashSet<>();
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	//private Set<Notification> notifications = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usersPosts", cascade = CascadeType.ALL)
	private Set<Post> posts = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	private Set<sharedPost> sharedposts = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	private Set<Reaction> Ureactions = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
    private Set<Comment> Usercomments = new HashSet<>();
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="userapplies", cascade = CascadeType.ALL)
    //private Set<Application> myapplications = new HashSet<>() ;
	
	//@ManyToOne 
	//private Entreprise_Profile Entreprise;
	//@OneToOne 
	//private Entreprise_Profile Admin_deEntreprise;
	//@OneToOne
	//private Condidate_Profile condidate_Profile;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
/*
	public Condidate_Profile getProfil() {
		return profil;
	}

	public void setProfil(Condidate_Profile profil) {
		this.profil = profil;
	}
*/
	public Set<Message> getMessagesSent() {
		return messagesSent;
	}

	public void setMessagesSent(Set<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}

	public Set<Message> getMessagesReceived() {
		return messagesReceived;
	}

	public void setMessagesReceived(Set<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}
/*
	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
*/
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<sharedPost> getSharedposts() {
		return sharedposts;
	}

	public void setSharedposts(Set<sharedPost> sharedposts) {
		this.sharedposts = sharedposts;
	}

	public Set<Reaction> getUreactions() {
		return Ureactions;
	}

	public void setUreactions(Set<Reaction> ureactions) {
		Ureactions = ureactions;
	}

	public Set<Comment> getUsercomments() {
		return Usercomments;
	}

	public void setUsercomments(Set<Comment> usercomments) {
		Usercomments = usercomments;
	}
/*
	public Set<Application> getMyapplications() {
		return myapplications;
	}

	public void setMyapplications(Set<Application> myapplications) {
		this.myapplications = myapplications;
	}

	public Entreprise_Profile getEntreprise() {
		return Entreprise;
	}

	public void setEntreprise(Entreprise_Profile entreprise) {
		Entreprise = entreprise;
	}

	public Entreprise_Profile getAdmin_deEntreprise() {
		return Admin_deEntreprise;
	}

	public void setAdmin_deEntreprise(Entreprise_Profile admin_deEntreprise) {
		Admin_deEntreprise = admin_deEntreprise;
	}

	public Condidate_Profile getCondidate_Profile() {
		return condidate_Profile;
	}

	public void setCondidate_Profile(Condidate_Profile condidate_Profile) {
		this.condidate_Profile = condidate_Profile;
	}


*/
	

   
}


