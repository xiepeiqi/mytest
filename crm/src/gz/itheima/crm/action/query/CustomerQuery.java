package gz.itheima.crm.action.query;

public class CustomerQuery {
	
	private Integer curPage;//当前页
	private Integer pageSize;//每页多少条数据
	
	private String keyWord;//查询的条件
	
	private String custSource;//信息来源
	private String custIndustry;//所属行业
	private String custLevel;//客户级别
	
	
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	@Override
	public String toString() {
		return "CustomerQuery [curPage=" + curPage + ", pageSize=" + pageSize
				+ ", keyWord=" + keyWord + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel
				+ "]";
	}
	
	

}
