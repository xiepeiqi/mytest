package gz.itheima.crm.util;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import gz.itheima.crm.base.BaseAction;
import gz.itheima.crm.entity.Log;
import gz.itheima.crm.entity.User;
import gz.itheima.crm.service.LogService;

public class LogAspact {
	
	//注入logService
	private LogService logService;
	public void setLogService(LogService logService) {
		this.logService = logService;
	}


	public void log(JoinPoint jp){
		System.out.println("记录日志了.....");
		//new Log记录日志
		Log log = new Log();
		//操作时间
		log.setLog_time(new Date());
		
		
		//操作人的ip地址
		HttpServletRequest request = ServletActionContext.getRequest();
		String remoteAddr = request.getRemoteAddr();
		log.setLogin_ip(remoteAddr);
		
		//记录操作人
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(BaseAction.USER_IN_SESSION);
		log.setOpt_user(user.getUser_id()+","+user.getUser_name());
		
		
		//记录操作人干了哪些活
		Object target = jp.getTarget();
		Object[] args = jp.getArgs();
		Signature signature = jp.getSignature();
		
		//方法名称
		String methodName = signature.getName();
		String name = target.getClass().getName();
		String function = "记录日志："+name+":"+methodName+"，参数有：【"+Arrays.asList(args)+"】";
		log.setFunction(function);
		
		//保存日志
		logService.log(log);
	}

}
