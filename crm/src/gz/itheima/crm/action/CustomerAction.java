package gz.itheima.crm.action;

import gz.itheima.crm.action.query.CustomerQuery;
import gz.itheima.crm.base.BaseAction;
import gz.itheima.crm.entity.Customer;
import gz.itheima.crm.service.CustomerService;
import gz.itheima.crm.util.PageBean;

import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

//客户模块Action
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {
	
	//注入service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//代码验证客户名称是否重复
	public void validateAdd() {
		if(customer.getCustId()==null && customerService.checkName(customer.getCustName())){
			//这个addFieldError方法，会自动跳转到input视图
			this.addFieldError("custName", "客户名称重复，请换一个客户名称");
		}
	}
	
	//客户添加
	public String add(){
		if(customer.getCustId()==null){
			//回显成功信息
			this.putContext("msg", "客户信息保存成功！");
		}else{
			//回显成功信息
			this.putContext("msg", "客户信息修改成功！");
		}
		//日志信息打印
		this.log.info("创建客户信息......."+customer);
		//保存客户信息
		customerService.save(customer);
		
		return "msg";
	}
	
	//客户列表查询
	public String list(){
		
		this.log.info("条件查询："+query);
		
		
		//解决条件搜索后，换页错误的问题
		//1.用户点击"搜索",把搜索的条件保存到HttpSession中(保存多了当前页的页码)
		//2.用户点击"换页",从HttpSession取出搜索条件（更新当前页的页码）
		
		//默认情况，当前页是第一页
		if(query.getCurPage()==null){
			//1.用户点击"搜索",把搜索的条件保存到HttpSession中
			query.setCurPage(1);
			
			//把搜索条件保存起来
			this.putSession("query", query);
		}else{
			//2.用户点击"换页",从HttpSession取出搜索条件
			
			//从HttpSession取出搜索条件
			CustomerQuery cq = (CustomerQuery)this.getDateFromSession("query");
			//把当前页码设置回条件对象中
			cq.setCurPage(query.getCurPage());
			query = cq;
		}
		
		//每页多少条判断
		if(query.getPageSize()==null){
			query.setPageSize(10);
		}

		PageBean<Customer> pb = customerService.findListByPage(query);
		
		//拿到当前页，用于序号的显示
		if(!(pb.getCurPage()==query.getCurPage())){
			pb.setCurPage(query.getCurPage());
		}
		if(!(pb.getPageSize()==query.getPageSize())){
			pb.setPageSize(query.getPageSize());
		}
		 
		this.putContext("pb", pb);
		
		this.log.info("查看表单数据================"+query);
		this.putContext("level", query.getCustLevel());
		
		return "list";
	}
	
	
	//删除客户
	public String delete(){
		this.log.info("删除客户数据================"+customer);
		if(customer.getCustId()==null){
			this.putContext("msg", "删除客户信息失败，原因：客户id为空！");
			return "msg";
		}
		customerService.delete(customer);
		this.putContext("msg", "删除客户信息成功！");
		return "msg";
	}
	
	
	//批量删除客户
	public String deleteByIds(){
		ids = ids.substring(0, ids.length()-1);
		this.log.info("删除客户数据================"+ids);
		customerService.deleteByIds(ids);
		this.putContext("msg", "批量删除客户信息成功！");
		return "msg";
	}
	
	public String edit(){
		customer = customerService.findById(customer.getCustId());
		this.putRoot(customer);
		return "edit";
	}
	
	
	
	
	//通过属性驱动封装查询参数
	private CustomerQuery query = new CustomerQuery();
	public CustomerQuery getQuery() {
		return query;
	}
	public void setQuery(CustomerQuery query) {
		this.query = query;
	}
	
	//通过属性驱动封装批量删除的id
	private String ids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}




	//模型驱动封装参数
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}

}
