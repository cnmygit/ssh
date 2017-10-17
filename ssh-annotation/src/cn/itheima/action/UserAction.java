package cn.itheima.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itheima.domain.User;
import cn.itheima.service.IUserService;

@Controller
@Scope("prototype")
@Namespace("/") // <package namespace="">
@ParentPackage("struts-default") // <package extends="">
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Override
	public User getModel() {
		return user;
	}

	// <action name="user_add"><result name="success">/success.jsp</result>
	@Action(value = "user_add", results = { @Result(name = "success", location = "/success.jsp") })
	public String add() {
		userService.add(user);
		return SUCCESS;
	}

	@Action(value = "user_findById")
	public void findById() {

		// 通过service来调用根据id查询操作
		User _user = userService.findById(user.getId());

		// 将_user转换成json数据响应到浏览器
		String json=JSONObject.toJSONString(_user);
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
