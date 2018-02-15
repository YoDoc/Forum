package fr.acceis.forum.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.acceis.forum.DAO.Topic;
import fr.acceis.forum.DAO.Utilisateur;
import fr.acceis.forum.impl.HibernateUtil;

public class UtilisateurService {
	public static Utilisateur checkerUtilisateur(String login) {


		System.out.println("===========================================\n Entrée méthode checkerUtilisateur\n===============================================\n");
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> query = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> root = query.from(Utilisateur.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("login"), login));

		Utilisateur user = session.createQuery(query).uniqueResult();

		System.out.println("===========================================\n Sortie checkerUtilisateur\n===============================================\n");

		return user;
	}


	public static void ecrireEnBase(String login, String pwd, String mail) {

		System.out.println("===========================================\n Entrée méthode ecrireEnBase\n===============================================\n");
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Utilisateur user = new Utilisateur();
		user.setEmail(mail);
		user.setLogin(login);
		user.setPassWord(pwd);

		Date jour = new Date();
		user.setInscription(jour);


		session.save(user);
		transaction.commit();

		System.out.println("===========================================\n Sortie méthode ecrireEnBase\n===============================================\n");

	}


	public static Topic posterNewTopic (Utilisateur user, String title, String content) {

		System.out.println("===========================================\n Entrée méthode posterNewTopic\n===============================================\n");
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Topic topic = new Topic();

		topic.setTitre(title);
		topic.setContent(content);
		topic.setAuteur(user);

		Date date = new Date();
		topic.setCreation(date);

		session.save(topic);
		transaction.commit();

		System.out.println("===========================================\n Sortie méthode posterNewTopic\n===============================================\n");

		return topic;
	}

	public List<Topic> listerTopic() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Topic> query = criteriaBuilder.createQuery(Topic.class);
		Root<Topic> root = query.from(Topic.class);

		query.select(root);
		List<Topic> topics = session.createQuery(query).getResultList();
		return topics;
	}
	
	
	public Topic recupererTopic (long id) {
		System.out.println("===========================================\n Entre dans recupererTopic\n===============================================\n");
		
		Session session = HibernateUtil.getSession();
		Topic topic = session.load(Topic.class, id);
		System.out.println("===========================================\n Sors de recupererTopic\n===============================================\n");
		
		return topic;

		
	}
}
