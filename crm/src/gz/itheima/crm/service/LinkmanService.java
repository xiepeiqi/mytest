package gz.itheima.crm.service;

import java.util.List;

import gz.itheima.crm.entity.Linkman;

public interface LinkmanService {
	
	public void save(Linkman linkman);

	public List<Linkman> findAll();

}
