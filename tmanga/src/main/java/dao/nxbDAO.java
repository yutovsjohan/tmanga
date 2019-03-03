package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.nxb;
import persistence.HibernateUtil;

public class nxbDAO extends EntityDAO<nxb>{
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public nxbDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<nxb> getAll() {		
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(nxb.class);
			List<nxb> nxb = criteria.list();
			session.getTransaction().commit();
			
			return nxb;
		} catch (Exception e) {
			return Collections.emptyList();
		}
		
	}

	@Override
	public nxb getId(int id) {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(nxb.class);
			nxb result = (nxb)criteria.add(Restrictions.idEq(id)).uniqueResult();
			session.getTransaction().commit();			
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public nxb getName(String name) {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(nxb.class);
			nxb result = (nxb)criteria.add(Restrictions.like("tentacgia", name)).uniqueResult();
			session.getTransaction().commit();			
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insert(nxb t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void update(nxb t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void delete(nxb t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
