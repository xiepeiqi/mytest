package gz.itheima.crm.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import gz.itheima.crm.base.BaseAction;
import gz.itheima.crm.entity.Customer;
import gz.itheima.crm.entity.Linkman;
import gz.itheima.crm.service.CustomerService;
import gz.itheima.crm.service.LinkmanService;

public class LinkmanAction extends BaseAction implements ModelDriven<Linkman>{
	
	//注入service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//注入联系人service
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	//去到添加联系人页面
	public String toadd(){
		List<Customer> cList = customerService.findAll();
		this.putContext("cList", cList);
		return "add";
	}
	
	//联系人保存
	public String add(){
		this.log.info("保存联系人"+linkman);
		//保存操作
		linkmanService.save(linkman);
		
		//回显成功信息
		this.putContext("msg", "成功保存联系人！");
		
		return "msg";
	}
	
	//联系人列表
	public String list(){
		List<Linkman> linkmanList = linkmanService.findAll();
		
		//System.out.println(linkmanList.get(0).getCustomer().getCustName());
		
		this.putContext("linkmanList", linkmanList);
		return "list";
	}
	
	
	
	
	private Linkman linkman = new Linkman();
	@Override
	public Linkman getModel() {
		return linkman;
	}
}
