<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html><html>
<head>
    <title>美食生鲜配送系统</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/default.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="author" content="www.cssmoban.com" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="default.css">

</head>
<body>

<header>
    <div class="header-nav">
        <div role="navigation">
            <a href="#" rel="home" class="hd-logo" title="美食餐厅"><img style="margin-left: 100px" src="images/logo1.jpg"></a>
            <ul class="hd-nav">
                <li class="search-box-li">
                    <div><input type="text" name="search-keyword" placeholder="输入关键词" form="search-keyword"><i
                            class="iconfont search-submit">&#xe617;</i></div>
                    <i class="search-exit"></i></li>
                <li><a href="default.jsp" name="index">网站首页<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                <li><a href="about.jsp" name="about">关于我们<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                <li><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=1" name="productlist">菜式欣赏<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                <li><a href="article.jsp" name="article">美食资讯<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                <li><a href="contact.jsp" name="contact">配送方式<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
            </ul>

            <div class="motai"></div>
                 <ul class="hd-nav" >
             <c:choose >
                   <c:when test="${empty user }">
                    <li><a href="login_login.jsp">登录 <span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                    <li><a href="regist.jsp">注册 <span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                   </c:when>
               <c:otherwise>
                 <li><a style="color: white;">你好,${user.uname }</a><i class="iconfont ">&#xe6aa;</i>
                 <li><a href="cart.jsp">购物车<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                 <li> <a href="${pageContext.request.contextPath}/user?method=loginOut">退出<span><i class="iconfont ">&#xe6aa;</i></span></a></li>
                 </c:otherwise>
             </c:choose>
             </ul>
        </div>
        <div class="search-box">
            <form method="post" action="#" id="search-keyword">
                <input type="text" name="search-keyword" placeholder="请输入您的内容">
                <span>
                    </span>
            </form>

        </div>

    </div>

    <div class="header-carousel container">

        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">

                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="images/banner.jpg" style="width:100%;" alt="First slide">
                </div>
                <div class="item">
                    <img src="images/banner2.jpg" style="width:100%;" alt="Second slide">
                </div>
                <div class="item">
                    <img src="images/banner3.jpg" style="width:100%;" alt="Third slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev"></a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next"></a>
        </div>

    </div>
</header>
</body>
</html>