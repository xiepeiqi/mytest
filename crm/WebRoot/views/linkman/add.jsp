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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<s:url value="/static/html5shiv.js"/>"></script>
<script type="text/javascript" src="<s:url value="/static/respond.min.js"/>"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui/css/H-ui.min.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/H-ui.admin.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/skin/default/skin.css"/>" id="skin" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/style.css"/>" />
<!--[if IE 6]>
<script type="text/javascript" src="<s:url value="/static/DD_belatedPNG_0.0.8a-min.js"/>" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<s:if test="customer.custId == null">
	<title>添加客户</title>
</s:if>
<s:else>
<title>修改客户</title>
</s:else>
</head>
<body>
<article class="page-container">
	<form action="<s:url value="/linkman_add"/>" method="post" class="form form-horizontal" id="form-member-add">
		<s:hidden name="lkmId"></s:hidden>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人姓名：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmName" cssClass="input-text"></s:textfield>
			</div>
			<div class="formControls col-xs-3 col-sm-4">
				<font color="red">
				<s:property value="fieldErrors['lkmName'][0]"/>
				</font>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所属客户：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<!-- 
					listKey:   <option value="listKey的值"></option>
					listValue: <option>listValue值</option>
				 -->
				<s:select name="customer.custId" list="#cList" listKey="custId" listValue="custName" cssClass="input-text"></s:select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人性别：</label>
			<div class="formControls col-xs-7 col-sm-7 skin-minimal">
				<div class="radio-box">
					<input name="lkmGender" type="radio" value="男"  <s:if test="custLevel == '男'">checked</s:if>>
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" value="女" name="lkmGender" <s:if test="custLevel == '女'">checked</s:if>>
					<label for="sex-2">女</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>固定电话：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmPhone" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>移动电话：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmMobile" cssClass="input-text"></s:textfield>
			</div>
			<div class="formControls col-xs-3 col-sm-4">
				<font color="red"><s:property value="fieldErrors['custMobile'][0]"/></font>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人邮箱：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmEmail" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人qq：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmQq" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人职位：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmPosition" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人备注：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:textfield name="lkmMemo" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

</body>
</html>