package gz.itheima.crm.util;

import java.util.List;

//分页对象
public class PageBean<T> {

	private List<T> curPageData; // 当前页数据
	private int firstPage; // 首页
	private int prePage;// 上一页 算法：如果当前页==首页？ 1 ： 当前页-1
	private int nextPage; // 下一页 算法： 如果当前页==总页数 ? 总页数 ：当前页+1
	private int totalPage;// 总页数/尾页 算法： 总记录数%每页记录数==0 ? 总记录数/每页记录数:总记录数/每页记录数 +1
	private int curPage; // 当前页
	private int pageSize = 10;// 每页记录数
	private int totalCount; // 总记录数
	public List<T> getCurPageData() {
		return curPageData;
	}
	public void setCurPageData(List<T> curPageData) {
		this.curPageData = curPageData;
	}
	//首页
	public int getFirstPage() {
		return 1;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	//上一页：
	public int getPrePage() {
		return this.getCurPage()==this.getFirstPage()?this.getFirstPage():this.getCurPage()-1;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	//下一页
	public int getNextPage() {
		return this.getCurPage()==this.getTotalPage()?this.getTotalPage():this.getCurPage()+1;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	//总页数
	public int getTotalPage() {
		return this.getTotalCount()%this.getPageSize()==0?this.getTotalCount()/this.getPageSize()
				: this.getTotalCount()/this.getPageSize()+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
