package gz.itheima.crm.service;

import java.util.List;

import gz.itheima.crm.entity.Log;

public interface LogService {
	
	public void log(Log log);

	public List<Log> findAll();

}
