package gz.itheima.crm.service.impl;

import java.util.List;

import gz.itheima.crm.dao.LinkmanDao;
import gz.itheima.crm.entity.Linkman;
import gz.itheima.crm.service.LinkmanService;

public class LinkmanServiceImpl implements LinkmanService{
	//注入联系人dao
	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}


	//保存联系人
	@Override
	public void save(Linkman linkman) {
		linkmanDao.save(linkman);
	}


	//查询所有的联系人
	@Override
	public List<Linkman> findAll() {
		return linkmanDao.findAll();
	}

}
