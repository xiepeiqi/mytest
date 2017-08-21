package gz.itheima.crm.action;

import gz.itheima.crm.base.BaseAction;
import gz.itheima.crm.entity.Log;
import gz.itheima.crm.service.LogService;

import java.util.List;

public class LogAction extends BaseAction{
	
	private LogService LogService;
	public void setLogService(LogService logService) {
		LogService = logService;
	}


	public String list(){
		List<Log> logList = LogService.findAll();
		this.putContext("logList", logList);
		return "list";
	}

}
