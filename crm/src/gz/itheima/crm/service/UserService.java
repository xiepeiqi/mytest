package gz.itheima.crm.service;

import java.util.List;

import gz.itheima.crm.entity.User;
import gz.itheima.crm.execetion.LoginFailExecetion;

//业务层接口
public interface UserService {
	
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(Long id);
	public List<User> findAll();
	
	//登录方法
	public User login(User user) throws LoginFailExecetion;

}
