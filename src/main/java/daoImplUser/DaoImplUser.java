package daoImplUser;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dao.daoUser;
import model.User;


@Repository
@Transactional
public class DaoImplUser implements daoUser {

	Session session=null;
	Transaction transaction=null;
	List<User>users=new ArrayList<>();
	
	SessionFactory sf;
	

	public DaoImplUser(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public List<User> getAllUser() {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<User>query=criteriaBuilder.createQuery(User.class);
		Root<User>root=query.from(User.class);
		query.select(root);
		Query<User>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		return users;
		
	}

	@Override
	public void addUser(User user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();

	}

	@Override
	public void delUser(User user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	

	}

	@Override
	public void upUser(User user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();

	}

	
	@Override
	public User getUserByNameAnDPassword(String name, String password) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<User>query=criteriaBuilder.createQuery(User.class);
		Root<User>root=query.from(User.class);
		query.select(root).where(criteriaBuilder.equal(root.get("name"), name)).where(criteriaBuilder.equal(root.get("password"),password));
		Query<User>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		session.close();
		if (users.size()!=0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	@Override
	public User getUserByName(String name) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<User>query=criteriaBuilder.createQuery(User.class);
		Root<User>root=query.from(User.class);
		query.select(root).where(criteriaBuilder.equal(root.get("name"), name));
		Query<User>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		if (users.size()!=0) {
			return users.get(0);
		}else {
			return null;
		}
	}

}
