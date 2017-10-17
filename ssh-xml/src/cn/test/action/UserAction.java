package cn.itheima.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itheima.domain.User;
import cn.itheima.service.IUserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	private IUserService userService;

	public void setUs(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String add() {
		userService.add(user);
		return SUCCESS;
	}

}
