package cn.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itheima.dao.IUserDAO;
import cn.itheima.domain.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	private IUserDAO userDao;

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
