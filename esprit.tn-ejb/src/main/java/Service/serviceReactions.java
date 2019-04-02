package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Post;
import Entities.Reaction;

/**
 * Session Bean implementation class serviceReactions
 */
@Stateless
@LocalBean
public class serviceReactions implements serviceReactionsRemote, serviceReactionsLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="esprit.tn-ejb")
	EntityManager em;
    public serviceReactions() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void AddReaction(Reaction reaction) {
		// TODO Auto-generated method stub
		em.persist(reaction);
	}
	@Override
	public void UpdateReaction(Reaction reaction) {
		// TODO Auto-generated method stub
		if(null!=em.find(Reaction.class, reaction.getId()))
		 em.merge(reaction);
		else 
		{
			//implementation Exception
		}
		}
	
	@Override
	public void DeleteReaction(Reaction reaction) {
		// TODO Auto-generated method stub
		reaction=em.find(Reaction.class, reaction.getId());
		em.remove(reaction);
	}
	@Override
	public List<Reaction> ReturnReactionbypub(Post post) {
		// TODO Auto-generated method stub
		TypedQuery<Reaction> query = em.createQuery("SELECT r FROM Reaction r WHERE r.postReaction = :post ",Reaction.class);			
		List<Reaction> reactions = query.setParameter("post", post).getResultList();
		return reactions;
	}


}
