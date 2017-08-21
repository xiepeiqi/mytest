package gz.itheima.crm.service.impl;

import java.util.List;

import gz.itheima.crm.dao.LogDao;
import gz.itheima.crm.entity.Log;
import gz.itheima.crm.service.LogService;

public class LogServiceImpl implements LogService {
	
	//注入logDao
	private LogDao logDao;
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public void log(Log log) {
		logDao.save(log);
	}

	@Override
	public List<Log> findAll() {
		return logDao.findAll();
	}

}
