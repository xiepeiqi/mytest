package gz.itheima.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import gz.itheima.crm.action.query.CustomerQuery;
import gz.itheima.crm.dao.CustomerDao;
import gz.itheima.crm.entity.Customer;
import gz.itheima.crm.service.CustomerService;
import gz.itheima.crm.util.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	//注入dao
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	/*
	 * 返回true代表已经存在用户
	 * 返回false代表不存在用户，可以使用该名称
	 */
	@Override
	public boolean checkName(String name) {
		List<Customer> cusList = customerDao.findByHQL("from Customer where custName=?", name);
		System.out.println("存在多少条数据：------》"+cusList.size());
		if(cusList.size()>0){
			return true;
		}
		return false;
	}


	//保存客户
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}


	//客户列表查询
	@Override
	public PageBean<Customer> findListByPage(CustomerQuery query) {
		int firstRsult = (query.getCurPage()-1)*query.getPageSize();
		int maxResult = query.getPageSize();
		
		//hql语句
		String hql = "";
		//hql条件:参数
		List<String> values = new ArrayList<String>();
		//信息来源
		if(StringUtils.isNotBlank(query.getCustSource())){
			hql += "and custSource = ?";
			values.add(query.getCustSource());
		}
		
		//所属行业
		if(StringUtils.isNotBlank(query.getCustIndustry())){
			hql += "and custIndustry = ?";
			values.add(query.getCustIndustry());
		}
		
		//所属行业
		if(StringUtils.isNotBlank(query.getCustLevel())){
			hql += "and custLevel = ?";
			values.add(query.getCustLevel());
		}
		
		
		//关键词查询
		if(StringUtils.isNotBlank(query.getKeyWord())){
			hql += "and (custName like ? or custPhone like ? or custMobile like ?)";
			values.add("%"+query.getKeyWord()+"%");
			values.add("%"+query.getKeyWord()+"%");
			values.add("%"+query.getKeyWord()+"%");
		}
		
		PageBean pb = new PageBean();
		List<Customer> cList = customerDao.findListByPage(firstRsult ,maxResult ,hql , values.toArray());
		Integer tcount = customerDao.findTotalCount(hql , values.toArray());
		pb.setCurPageData(cList);
		pb.setTotalCount(tcount);
		return pb;
	}


	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer.getCustId());
	}


	@Override
	public void deleteByIds(String ids) {
		String[] split = ids.split(",");
		Long[] idArray = new Long[split.length];
		for(int i = 0;i<split.length;i++){
			idArray[i] = Long.parseLong(split[i]); 
		}
		customerDao.deleteByIds(idArray,"custId");
		
	}


	@Override
	public Customer findById(Long custId) {
		
		return customerDao.findById(custId);
	}


	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
