<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<s:url value="/static/html5shiv.js"/>"></script>
<script type="text/javascript" src="<s:url value="/static/respond.min.js"/>"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui/css/H-ui.min.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/H-ui.admin.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/Hui-iconfont/1.0.8/iconfont.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/skin/default/skin.css"/>" id="skin" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/style.css"/>" />
<!--[if IE 6]>
<script type="text/javascript" src="<s:url value="/static/DD_belatedPNG_0.0.8a-min.js"/>" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>联系人管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 联系人管理 <span class="c-gray en">&gt;</span> 联系人列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<form method="post" action="<s:url value="/customer_list"/>">
	<div class="text-c"> 
		<s:select name="query.custSource" list="{'朋友介绍','已购买产品联系人','来自网络搜索'}" headerKey="" headerValue="==全部信息来源=="></s:select>
		<s:select name="query.custIndustry" list="{'互联网行业','教育培训行业','手机制造业'}" headerKey="" headerValue="==全部所属行业=="></s:select>
		<select name="query.custLevel" id="query_custLevel">
		    <option value="" >==全部联系人==</option>
		    <option value="1" <s:if test="#session.query.custLevel == 1">selected="selected"</s:if>>普通联系人</option>
		    <option value="2" <s:if test="#session.query.custLevel == 2">selected="selected"</s:if>>金牌联系人</option>
		    <option value="3" <s:if test="#session.query.custLevel == 3">selected="selected"</s:if>>白金联系人</option>
		</select>
		
		
		关键词：
		<input type="text" class="input-text" style="width:200px" placeholder="请输入关键词" id="" name='query.keyWord' value='<s:property value="query.keyWord"/>'>
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>

	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
		<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a href="javascript:;" onclick="member_add('添加联系人','<s:url value="/linkman_toadd"/>','','450')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加联系人</a>
		</span> 
		<span class="r">共有数据：<strong><s:property value="#pb.totalCount"/></strong> 条</span> 
	</div>
	
	
	<div class="mt-20">
	
	<!-- 数据展示区 -->
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr class="text-c">
				<th width="20"><input type="checkbox" name="" value=""></th>
				<th width="20">序号</th>
				<th width="80">联系人名称</th>
				<th width="100">所属客户</th>
				<th width="90">联系人性别</th>
				<th width="60">办公电话</th>
				<th width="60">联系人手机</th>
				<th width="60">联系人邮箱</th>
				<th width="60">联系人QQ</th>
				<th width="60">联系人职位</th>
				<th width="60">联系人备注</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#linkmanList" status="sta">
			<tr class="text-c">
				<td><input type="checkbox" value='<s:property value="lkmId"/>' name="custIDS"></td>
				<td><b><s:property value="(#sta.index+1)"/></b></td>
				<td><s:property value="lkmName"/></td>
				<td><s:property value="customer.custName"/></td>
				<td><s:property value="lkmGender"/></td>
				<td><s:property value="lkmPhone"/></td>
				<td><s:property value="lkmMobile"/></td>
				<td><s:property value="lkmEmail"/></td>
				<td><s:property value="lkmQq"/></td>
				<td><s:property value="lkmPosition"/></td>
				<td><s:property value="lkmMemo"/></td>
				<td class="td-manage"> 
				<a title="编辑" href="javascript:;" onclick="customer_edit('<s:property value="custId"/>')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>  
				<a title="删除" href="javascript:;" onclick="customer_del('<s:property value="custId"/>')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	
	<!-- 分页显示区 -->
	<div class="dataTables_wrapper " style="margin-bottom:50px;margin-top:10px;">
	<div class="dataTables_info">
		<div class="dataTables_length" id="DataTables_Table_0_length">
		<label>
			显示 
			<s:select name="query.pageSize" list="{10,25,50,100}" cssClass="select"></s:select>
			 条
		</label>
		</div>
	</div>
	<div class="dataTables_paginate paging_simple_numbers" >
		<!-- 
			sxxx?name=dfadf
			sxxx?name=%{#pb.firstPage}  把字符串转成ognl表达式
		 -->
		<s:a value="/customer_list?query.curPage=%{#pb.firstPage}&query.pageSize=%{#pb.pageSize}" cssClass="paginate_button previous">首页</s:a>
		<s:a value="/customer_list?query.curPage=%{#pb.prePage}&query.pageSize=%{#pb.pageSize}" cssClass="paginate_button previous">上一页</s:a>
		<span>
			<a class="paginate_button current" >第 <s:property value="#pb.curPage"/> 页</a>
		</span>
		<s:a value="/customer_list?query.curPage=%{#pb.nextPage}&query.pageSize=%{#pb.pageSize}" cssClass="paginate_button next">下一页</s:a>
		<s:a value="/customer_list?query.curPage=%{#pb.totalPage}&query.pageSize=%{#pb.pageSize}" cssClass="paginate_button next">末页</s:a>
		<button class="btn disabled radius">共 <s:property value="#pb.totalPage"/> 页</button>
	</div>
	</div>
	
	</div>
</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-删除*/
function member_del(obj,id){
	var url = '<s:url value="/book/books_delete"/>?id='+id;
	layer.confirm('确认要删除吗？',function(index){
		//layer_show("删除",url,"350","350");
		
		//layer.msg('已删除!',{icon:1,time:1000});
		
	});
}


function customer_del(id){
	var url = '<s:url value="/customer_delete"/>?custId='+id;
	layer.confirm('是否要删除？删除后数据无法恢复，请谨慎操作。',function (){
		layer_show("删除联系人信息",url,"350","350");
	});
	
}

function datadel(){
	var ids = "";
	$("input[name='custIDS']:checkbox:checked").each(function(){ 
		ids+=$(this).val()+","; 
	});
	
	//alert(ids);
	
	var url = '<s:url value="/customer_deleteByIds"/>?ids='+ids;
	layer.confirm('是否要批量删除数据？删除后数据无法恢复，请谨慎操作。',function (){
		layer_show("删除联系人信息",url,"350","350");
	});
}


function customer_edit(id){
	var url = '<s:url value="/customer_edit"/>?custId='+id;
	layer_show('修改联系人信息',url,'500','450');
}

</script> 
</body>
</html>
