package gz.itheima.crm.dao;

import java.util.List;

import gz.itheima.crm.entity.User;

//DAO:持久层
public interface UserDao {
	
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(Long id);
	public List<User> findAll();
	
	//通过hql查询用户
	public List<User> findByHQL(String hql,Object ... value);

}
