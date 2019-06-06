<%@page import="com.food.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/pintuer.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/admin.css" type="text/css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">

<% 
	    if(session.getAttribute("admin")!=null){
	 Admin admin=(Admin)session.getAttribute("admin");
	    
%>
 <div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img  src="${pageContext.request.contextPath}/admin/images/logo1.jpg " class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>

  <div class="head-l">
    <a class="button button-little bg-green" href="${pageContext.request.contextPath}/default.jsp" target="_blank">
       <span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
    <a href="index.jsp" class="button button-little bg-blue"><span class="icon-wrench">
       </span> 清除缓存</a> &nbsp;&nbsp;
      <a class="button button-little bg-green" target="_blank"> <span></span> 欢迎您：<%=admin.getUname()%></a>
      <a class="button button-little bg-red" href="${pageContext.request.contextPath}/admin/login.jsp">
       <span class="icon-power-off"></span> 退出登录</a>
       
<%
	    }else{
	    	

%>	
       <script type="text/javascript">
       window.location.href="login.jsp";
    </script>
       		<%
	    }
			%>
   </div>

</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">

    <li><a href="${pageContext.request.contextPath }/admin?method=guanliUser&currentPagae=1" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
   <li><a href="add_user.jsp" target="right"><span class="icon-caret-right"></span>添加用户</a></li>
    <li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="${pageContext.request.contextPath }/admin?method=selectUser" target="right"><span class="icon-caret-right"></span>会员管理</a></li>
    <li><a href="${pageContext.request.contextPath }/jh?method=list" target="right"><span class="icon-caret-right"></span>进货管理</a></li>
    <li><a href="${pageContext.request.contextPath }/food?method=findkcfood" target="right"><span class="icon-caret-right"></span>库存管理</a></li>
    <li><a href="${pageContext.request.contextPath }/order?method=myOrders" target="right"><span class="icon-caret-right"></span>订单管理</a></li>
    <li><a href="${pageContext.request.contextPath }/order?method=hotOrderFood&currentPage=1" target="right"><span class="icon-caret-right"></span>热销商品</a></li>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href=""> 首页</a></li>
  <li><a id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
 	
  <iframe scrolling="left" style="" src="hydl.jsp" name="right" width="100%" height="100%"  ></iframe>
 	
 </div>
 
</body>
</html>