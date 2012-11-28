package dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.AreaAtuacao;

/**
 * Session Bean implementation class AreaAtuacaoDao
 */
@Stateless
@Remote(AreaAtuacaoRemote.class)
public class AreaAtuacaoDao implements AreaAtuacaoRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(AreaAtuacao c) {
		em.persist(c);
	}

	@Override
	public void update(AreaAtuacao c) {
		em.merge(c);
	}

	@Override
	public void delete(AreaAtuacao c) {
		em.remove(em.merge(c));
	}

	@Override
	public AreaAtuacao find(int id) {
		return em.find(AreaAtuacao.class, id);
	}

	@Override
	public List<AreaAtuacao> list() {
		TypedQuery<AreaAtuacao> query = em.createQuery("select cl from AreaAtuacao cl", AreaAtuacao.class); 
		return query.getResultList();
	}

    

}
