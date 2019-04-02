package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Connection;
//import Entities.Follow;
import Entities.Post;
import Entities.User;

/**
 * Session Bean implementation class servicePublication
 */
@Stateless
@LocalBean
public class servicePublication implements servicePublicationRemote, servicePublicationLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="ergaciaBU-ejb")
	EntityManager em;
    public servicePublication() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creatPost(Post post) {
		// TODO Auto-generated method stub
		em.persist(post);
	}

	@Override
	public void DeletePost(Post post) {
		// TODO Auto-generated method stub
		post = ReturnPostbyId(post.getId());
		em.remove(post);
	}

	@Override
	public void UpdatePost(Post post) {
		// TODO Auto-generated method stub
		em.merge(post);
	}


	@Override
	public Post ReturnPostbyId(int Id) {
		// TODO Auto-generated method stub
		return em.find(Post.class, Id);
	}

	@Override
	public List<Post> ReturnPostsbyUser(User user) {
		// TODO Auto-generated method stub
		TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.usersPosts = :user ",Post.class);			
		List<Post> postes = query.setParameter("user", user).getResultList();
		return postes;
	}

	@Override
	public List<Post> ReturnPostbyConnectionsandfollows(User user) {
		// TODO Auto-generated method stub
		
		
		//Set<Connection> connections = user.getProfil().getConnections();
		//List<Follow> follows = user.getProfil().getFollows();
		List<Post> posts = new ArrayList<Post>();
		/*
		for(Connection con : connections)
		{
			posts.addAll(con.getConnectedtoCondidate().getUserCondidate().getPosts());
		}
		for(Follow f : follows)
		{
			posts.addAll(f.getProfileCondidat().getUserCondidate().getPosts());
		}
		*/
		return posts;
		
		}
		
	}


