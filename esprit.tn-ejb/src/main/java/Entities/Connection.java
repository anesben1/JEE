package Entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Connection
 *
 */
@Entity

public class Connection implements Serializable {

	   
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp date;
	private int accepted ;
	/*
	@ManyToOne
    private Condidate_Profile CondidateConnected;
	@ManyToOne
    private Condidate_Profile ConnectedtoCondidate;
	private static final long serialVersionUID = 1L;

	public Condidate_Profile getCondidateConnected() {
		return CondidateConnected;
	}
	public void setCondidateConnected(Condidate_Profile condidateConnected) {
		CondidateConnected = condidateConnected;
	}
	public Condidate_Profile getConnectedtoCondidate() {
		return ConnectedtoCondidate;
	}
	public void setConnectedtoCondidate(Condidate_Profile connectedtoCondidate) {
		ConnectedtoCondidate = connectedtoCondidate;
	}
	*/
	public Connection() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getAccepted() {
		return accepted;
	}
	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}
   
}
