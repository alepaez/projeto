package dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Empresa;

/**
 * Session Bean implementation class EmpresaDao
 */
@Stateless
@Remote(EmpresaRemote.class)
public class EmpresaDao implements EmpresaRemote {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Empresa c) {
		em.persist(c);
	}

	@Override
	public void update(Empresa c) {
		em.merge(c);
	}

	@Override
	public void delete(Empresa c) {
		em.remove(em.merge(c));
	}

	@Override
	public Empresa find(int id) {
		return em.find(Empresa.class, id);
	}
	
	@Override
	public Empresa find(String login){
		TypedQuery<Empresa> query = em.createQuery("select cl from Empresa cl where cl.login = '" + login + "'", Empresa.class);
		List<Empresa> list = query.getResultList();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<Empresa> list() {
		TypedQuery<Empresa> query = em.createQuery("select cl from Empresa cl", Empresa.class); 
		return query.getResultList();
	}

}