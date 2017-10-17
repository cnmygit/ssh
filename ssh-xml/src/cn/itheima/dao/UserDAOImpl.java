package cn.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itheima.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user); // session.save()
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user); // session.update()
	}

	@Override
	public void del(User user) {
		this.getHibernateTemplate().delete(user);// session.delete()
	}

	@Override
	public User findById(int id) {
		return this.getHibernateTemplate().get(User.class, id); // session.get()
	}

	@Override
	public List<User> findAll() {
		// 原来的hibernate中 session.createQuery(hql).setParameter().list();
		return (List<User>) this.getHibernateTemplate().find("from User");

	}

	@Override
	public List<User> findAllByCriteria(DetachedCriteria dc) {

		return (List<User>) this.getHibernateTemplate().findByCriteria(dc);

	}

	@Override
	public List<User> findByNameQuery() {
		// return (List<User>)
		// this.getHibernateTemplate().findByNamedQuery("findUserByHQL", 2);
		// //得到id>2

		return (List<User>) this.getHibernateTemplate().findByNamedQuery("findUserBySQL");
	}

}
