package gz.itheima.crm.service.impl;

import java.util.List;

import gz.itheima.crm.dao.UserDao;
import gz.itheima.crm.entity.User;
import gz.itheima.crm.execetion.LoginFailExecetion;
import gz.itheima.crm.service.UserService;
import gz.itheima.crm.util.MD5Util;

//User业务层实现
public class UserServiceImpl implements UserService{
	
	//注入UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//保存用户
	@Override
	public void save(User user) {
		userDao.save(user);
	}
	
	//查询所有用户
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	//登录业务方法
	@Override
	public User login(User user) throws LoginFailExecetion {
		//1、判断用户是否存在（查数据库）
		List<User> uList = userDao.findByHQL("from User where user_name=?", user.getUser_name());
		if(uList==null||uList.size()==0){
			//用户不存在
			throw new LoginFailExecetion("用户不存在");
		}
		//取出第一个数据
		User u = uList.get(0);
		//2、判断用户密码是否正确
		if(!u.getUser_password().equals(MD5Util.md5(user.getUser_password()))){
			//用户密码不正确
			throw new LoginFailExecetion("用户密码错误");
		}
		//3、判断用户的状态(判断数据库中的用户的状态)
		if("0".equals(u.getUser_state())){
			//用户密码不正确
			throw new LoginFailExecetion("用户已经停用，请联系管理员！！");
		}
		
		return u;
	}

	

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public User findById(Long id) {
		return null;
	}

}
