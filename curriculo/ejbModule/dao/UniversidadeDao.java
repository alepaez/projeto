package dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Universidade;

/**
 * Session Bean implementation class UniversidadeDao
 */
@Stateless
@Remote(UniversidadeRemote.class)
public class UniversidadeDao implements UniversidadeRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Universidade c) {
		em.persist(c);
	}

	@Override
	public void update(Universidade c) {
		em.merge(c);
	}

	@Override
	public void delete(Universidade c) {
		em.remove(em.merge(c));
	}

	@Override
	public Universidade find(int id) {
		return em.find(Universidade.class, id);
	}

	@Override
	public List<Universidade> list() {
		TypedQuery<Universidade> query = em.createQuery("select cl from Universidade cl", Universidade.class); 
		return query.getResultList();
	}
}
