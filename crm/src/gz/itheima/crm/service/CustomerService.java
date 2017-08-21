package gz.itheima.crm.service;

import gz.itheima.crm.action.query.CustomerQuery;
import gz.itheima.crm.entity.Customer;
import gz.itheima.crm.util.PageBean;

import java.util.List;

public interface CustomerService {
	
	public boolean checkName(String name);

	public void save(Customer customer);

	public PageBean<Customer> findListByPage(CustomerQuery query);
	
	public void delete(Customer customer);

	public void deleteByIds(String ids);

	public Customer findById(Long custId);

	public List<Customer> findAll();

}
