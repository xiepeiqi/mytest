package gz.itheima.crm.base;

import gz.itheima.crm.entity.Customer;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

/*
 * 泛型通用的basicDao，里面写了一些共有的方法
 */
public class BaseDao<T> implements IBaseDao<T>{
	
	//具体子类的类
	private Class targetClass;
	
	public BaseDao(){
		//获取子类泛型父类上的具体泛型
		//1、获取当前执行的子类的Dao
		Class clz = this.getClass();  //CustomerDaoImpl
		//2、获取子类泛型父类(参数化类)
		ParameterizedType type = (ParameterizedType)clz.getGenericSuperclass(); // BaseDao<Customer>
		targetClass = (Class) type.getActualTypeArguments()[0];
		
		System.out.println(targetClass);
	}
	
	
	//注入HibernateTemplate
	protected HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//查询
	public List<T> findByHQL(String hql, Object... value) {
		return (List<T>)hibernateTemplate.find(hql, value);
	}

	//保存
	public void save(T t) {
		//hibernateTemplate.save(customer);
		//判断如果有id，则修改；如果没有id，则新增
		hibernateTemplate.saveOrUpdate(t);
	}

	//查找当前页数据
	public List<T> findListByPage(final Integer firstResult,final Integer maxResult,final String condition,final Object ...values) {
		return hibernateTemplate.execute(new HibernateCallback<List<T>>() {
			
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Query createQuery = session.createQuery("from "+targetClass.getSimpleName()+" where 1=1 "+condition);
				for(int i=0;i<values.length;i++){
					createQuery.setParameter(i, values[i]);
				}
				createQuery.setFirstResult(firstResult);//固定   (curPage-1)*pageSize
				createQuery.setMaxResults(maxResult);//查询几行
				return createQuery.list();
			}
		});
	}

	//查找总记录数
	public Integer findTotalCount(final String condition,final Object ...values) {
		
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			
			public Integer doInHibernate(Session session)
					throws HibernateException {
				Query createQuery = session.createQuery("select count(c) from "+targetClass.getSimpleName()+" c where 1=1 "+condition);
				for(int i=0;i<values.length;i++){
					createQuery.setParameter(i, values[i]);
				}
				return ((Long)createQuery.uniqueResult()).intValue();
			}
		});
	}

	
	//删除单个对象
	public void delete(Serializable id) {
		T t = findById(id);
		hibernateTemplate.delete(t);
	}
	
	//查找单个对象
	public T findById(Serializable id) {
		return (T) hibernateTemplate.get(targetClass, id);
	}
	
	
	

	//批量删除
	@SuppressWarnings("unchecked")
	/*
	 * ids:传入的具体ID值
	 * class_id_name：代表是持久化类中id的属性名称
	 */
	public void deleteByIds(final Object[] ids,final String class_id_name) {
		hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query createQuery = session.createQuery("delete from "+targetClass.getSimpleName()+" where "+class_id_name+" in ( :ids )");
				createQuery.setParameterList("ids", ids);
				return createQuery.executeUpdate();
			}
		});
		
	}

	//查询所有数据
	@Override
	public List<T> findAll() {
		return hibernateTemplate.loadAll(targetClass);
	}

	

}
