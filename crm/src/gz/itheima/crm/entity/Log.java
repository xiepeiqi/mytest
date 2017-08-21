package gz.itheima.crm.entity;

import java.util.Date;

public class Log {
	
	private Long log_id;
	private String opt_user;
	private Date log_time;
	private String function;
	private String login_ip;
	
	
	public Long getLog_id() {
		return log_id;
	}
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}
	public String getOpt_user() {
		return opt_user;
	}
	public void setOpt_user(String opt_user) {
		this.opt_user = opt_user;
	}
	public Date getLog_time() {
		return log_time;
	}
	public void setLog_time(Date log_time) {
		this.log_time = log_time;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	
	

}
