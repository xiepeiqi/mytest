﻿<%@ page language="java" pageEncoding="UTF-8"%>
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
	<form action="<s:url value="/customer_add"/>" method="post" class="form form-horizontal" id="form-member-add">
		<s:hidden name="custId"></s:hidden>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户名称：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<!-- <input type="text" class="input-text" value='' placeholder="" id="custName" name="custName"> -->
				<!-- 
					name="custName"
						1）把text的表单名变为custName
						2）从root中取出数据，赋值到属性的value中
				 -->
				<s:textfield name="custName" cssClass="input-text"></s:textfield>
			</div>
			<div class="formControls col-xs-3 col-sm-4">
				<font color="red">
				<s:property value="fieldErrors['custName'][0]"/>
				</font>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户信息来源：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:select name="custSource" list="{'朋友介绍','已购买产品客户','来自网络搜索','电话营销','网络营销'}" cssClass="input-text"></s:select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户所属行业：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<s:select name="custIndustry" list="{'互联网行业','教育培训行业','手机制造业','教育培训','金融保险'}" cssClass="input-text"></s:select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户级别：</label>
			<div class="formControls col-xs-7 col-sm-7 skin-minimal">
				<div class="radio-box">
					<input name="custLevel" type="radio" value="1"  <s:if test="custLevel == 1">checked</s:if>>
					<label for="sex-1">普通客户</label>
				</div>
				<div class="radio-box">
					<input type="radio" value="2" name="custLevel" <s:if test="custLevel == 2">checked</s:if>>
					<label for="sex-2">金牌客户</label>
				</div>
				<div class="radio-box">
					<input type="radio" value="3" name="custLevel" <s:if test="custLevel == 3">checked</s:if>>
					<label for="sex-2">白金客户</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>固定电话：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<!-- <input type="text" class="input-text" value="" placeholder="" id="custPhone" name="custPhone"> -->
				<s:textfield name="custPhone" cssClass="input-text"></s:textfield>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>移动电话：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<!-- <input type="text" class="input-text" value="" placeholder="" id="custMobile" name="custMobile"> -->
				<s:textfield name="custMobile" cssClass="input-text"></s:textfield>
			</div>
			<div class="formControls col-xs-3 col-sm-4">
				<font color="red"><s:property value="fieldErrors['custMobile'][0]"/></font>
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