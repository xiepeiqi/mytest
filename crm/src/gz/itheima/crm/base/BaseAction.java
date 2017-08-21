package gz.itheima.crm.base;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport{
	//log对象，给子类打印日志
	protected Logger log = Logger.getLogger(this.getClass());
	
	public static final String USER_IN_SESSION = "user_in_session";
	
	//公用提醒方法
	public void putContext(String key,Object obj){
		ActionContext context = ActionContext.getContext();
		context.put(key, obj);
	}
	
	//公用的方法，保存数据到session中
	public void putSession(String key,Object obj){
		ActionContext context = ActionContext.getContext();
		context.getSession().put(key, obj);
	}
	
	//从session中获取数据
	public Object getDateFromSession(String key){
		ActionContext context = ActionContext.getContext();
		return context.getSession().get(key);
	}
	
	public void putRoot(Object obj){
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.push(obj);
	}

}
