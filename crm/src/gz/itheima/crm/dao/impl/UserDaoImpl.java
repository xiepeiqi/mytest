package gz.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import gz.itheima.crm.dao.UserDao;
import gz.itheima.crm.entity.User;

public class UserDaoImpl implements UserDao {
	
	//注入HibernateTemplate
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//保存用户
	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}
	
	//查询所有用户
	@Override
	public List<User> findAll() {
		//通过loadAll方法直接查询出所有的用户数据
		return hibernateTemplate.loadAll(User.class);
	}
	
	//通用的查询用户列表方法
	@Override
	public List<User> findByHQL(String hql, Object... value) {
		/*
		 * 以前的玩法：
		 * hibernate
		 * session.careateQuery(hql，参数);
		 * for(){
		 * 	迭代参数
		 * }
		 */
		return (List<User>) hibernateTemplate.find(hql, value);
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
