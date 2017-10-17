package cn.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.dao.IUserDAO;
import cn.itheima.domain.User;

public class UserServiceImpl implements IUserService {

	private IUserDAO userDao;

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void del(User user) {
		userDao.del(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> findAllByCriteria(DetachedCriteria dc) {
		return userDao.findAllByCriteria(dc);
	}

	@Override
	public List<User> findByNameQuery() {
		return userDao.findByNameQuery();
	}

}
