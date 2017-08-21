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
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/H-ui.login.css"/>" />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/h-ui.admin/css/style.css"/>"  />
<link rel="stylesheet" type="text/css" href="<s:url value="/static/Hui-iconfont/1.0.8/iconfont.css"/>" />
<!--[if IE 6]>
<script type="text/javascript" src="<s:url value="/static/DD_belatedPNG_0.0.8a-min.js"/>" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<title>传智客户关系后台管理系统</title>
</head>
<body>
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
  	<!-- 这里是表单 -->
    <form class="form form-horizontal" action="<s:url value="/user_login"/>" method="post">
    	<!-- 账户 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="name" name="user_name" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      
      	<!-- 密码 -->
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="user_password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      
      	<!-- 验证码 -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>
      </div>
      
      	<!-- 回显错误信息 -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
            	<font color="red">&nbsp;  <s:property value="#loginFailMsg"/></font>
        </div>
      </div>
      
      	<!-- 提交框 -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input onClick="checkSubmit()" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input onClick="checkSubmit()" type="button" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright <a href="http://www.itcast.cn" target="_blank">北京传智播客教育科技有限公司</a> </div>
<script type="text/javascript" src="<s:url value="/static/jquery/1.9.1/jquery.min.js"/>"></script> 
<script type="text/javascript" src="<s:url value="/static/h-ui/js/H-ui.min.js"/>"></script>
	<script type="text/javascript">
		function checkSubmit(){
			var username = $("#name").val();
			var password = $("#password").val();
			username = $.trim(username);
			password = $.trim(password);
			if(username.length>0){
				if(password.length>0){
					//提交表单
					document.forms[0].submit();	
				}else{
					window.alert("密码必填");
					$("#password").focus();
					$("#password").val("");
				}
			}else{
				window.alert("用户名必填");
				$("#name").focus();
				$("#name").val("");
			}
		}
	</script>
</body>
</html>