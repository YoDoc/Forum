package fr.acceis.forum.DAO;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	@Id @GeneratedValue
	private long id;
	
	private String titre;
	private Date creation;
	@ManyToOne
	private Utilisateur auteur;
	private String content;
	
	@OneToMany (mappedBy="topic") // en gros on peut traduire mappedBy par "englobé dans"
	private Collection <Post> post;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public Collection<Post> getPost() {
		return post;
	}
	public void setPost(Collection<Post> post) {
		this.post = post;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
