<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<!-- 优先使用 IE 最新版本和 Chrome -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
	</head>
<body>
	<footer>
    <div style="margin-top: 30px">
        <ul class="footer-top">
            <li><a href="default.jsp">网站首页</a></li>
            <li><a href="about.jsp">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=1">菜式欣赏</a></li>
            <li><a href="article.jsp">美食资讯</a></li>
            <li><a href="contact.jsp">配送方式</a></li>
        </ul>
    </div>
    <div>
        <ul class="footer-body">
            <li>
                <span>电话:</span><span>12345678910</span>
            </li>
            <li>
                <span>邮箱:</span><span>123@163.com</span>
            </li>
            <li>
                <span>地址:</span><span>山东省山东理工大学</span>
            </li>
        </ul>
        <P><span><a href="http://www.haothemes.com/" target="_blank" title=""></a> </span></P>
        <ul class="footer-footer">
            <li><i class="iconfont ">&#xe613;</i></li>
            <li><i class="iconfont ">&#xe634;</i></li>
            <li><i class="iconfont ">&#xe602;</i></li>
        </ul>
    </div>
</footer>

		
</body>
</html>