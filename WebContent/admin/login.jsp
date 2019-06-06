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
    <title>登录</title>  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/pintuer.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/admin.css" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="${pageContext.request.contextPath }/admin?method=findFoodList" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="valcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img alt="" src="valcode.jsp">  
                                                   
                        </div>
                    </div>
                </div>
                <div style="padding:5px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>

            </div>
            <div>
            	<tr>
				<td colspan="2" align="center">
				<c:if test="${!empty param.msg }">
				   <c:choose>
				      <c:when test="${param.msg==0 }">
				         <span>用户名或密码错误！</span>
				      </c:when>
				       <c:when test="${param.msg==1 }">
				         <span>验证码错误！</span>
				      </c:when>
				      <c:when test="${param.msg==2 }">
				         <span>请先登录</span>
				      </c:when>
				      <c:when test="${param.msg==3 }">
				         <span>注册成功！</span>
				      </c:when>
				   </c:choose>
				</c:if>
				
				</td>
			</tr>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>