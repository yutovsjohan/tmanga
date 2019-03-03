package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.tacgia;
import persistence.HibernateUtil;

public class tacgiaDAO extends EntityDAO<tacgia>{
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public tacgiaDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<tacgia> getAll() {		
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(tacgia.class);
			List<tacgia> tacgia = criteria.list();
			session.getTransaction().commit();
			
			return tacgia;
		} catch (Exception e) {
			return Collections.emptyList();
		}
		
	}

	@Override
	public tacgia getId(int id) {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(tacgia.class);
			tacgia result = (tacgia)criteria.add(Restrictions.idEq(id)).uniqueResult();
			session.getTransaction().commit();			
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public tacgia getName(String name) {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(tacgia.class);
			tacgia result = (tacgia)criteria.add(Restrictions.like("tentacgia", name)).uniqueResult();
			session.getTransaction().commit();			
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insert(tacgia t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void update(tacgia t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void delete(tacgia t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
