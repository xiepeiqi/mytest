package gz.itheima.crm.action;

import java.util.List;

import gz.itheima.crm.base.BaseAction;
import gz.itheima.crm.entity.User;
import gz.itheima.crm.execetion.LoginFailExecetion;
import gz.itheima.crm.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User>{
	
	//注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//用户添加
	public String add(){
		//直接输出信息
		//System.out.println("用户添加："+user);
		//通过日志类输出信息
		this.log.info("用户添加："+user);
		
		
		userService.save(user);
		
		//成功提醒：
//		ActionContext context = ActionContext.getContext();
//		context.put("msg", "添加用户成功");
		this.putContext("msg", "添加用户成功");
		
		return "msg";
	}
	
	//查询所有用户
	public String findAll(){
		//获取所有用户
		List<User> uList = userService.findAll();
		
		//把用户保存到值栈中
		this.putContext("uList", uList);
		
		return "list";
	}
	
	
	//登录的方法
	public String login(){
		log.info("用户登录");
		
		try {
			//登录
			User loginUser = userService.login(user);
			
			//把用户保存到session中
			this.putSession(USER_IN_SESSION, loginUser);
			
		} catch (LoginFailExecetion e) {
			//有异常返回登录页面
			this.putContext("loginFailMsg", e.getMessage());
			return LOGIN;
		}
		
		
		return "main";
	}
	
	
	
	
	
	
	//通过模型驱动拦截器封装页面参数
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

}
