package gz.itheima.crm.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

	//查询
	public List<T> findByHQL(String hql, Object... value) ;

	//保存
	public void save(T t) ;

	//查找当前页数据
	public List<T> findListByPage(
			final Integer firstResult,
			final Integer maxResult,
			final String condition,
			final Object ...values) ;

	//查找总记录数
	public Integer findTotalCount(final String condition,final Object ...values) ;
	
	//删除单个对象
	public void delete(Serializable id);
	
	//查找单个对象
	public T findById(Serializable id);

	//批量删除
	public void deleteByIds(final Object[] ids,final String class_id_name);
	 
	//查询所有数据
	public List<T> findAll();
}
