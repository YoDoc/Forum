package fr.acceis.forum.DAO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id 
	private long id;
	@ManyToOne 
	private Topic topic;
	
	private String threadId;
	private Date creation;
	private String auteur;
	private String contenu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
