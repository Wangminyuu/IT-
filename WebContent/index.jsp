<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp"></jsp:include>
<main class="main-first-bgcolor">
    <div>
        <div class="main-head">
            <p>
                <span>我们提供</span>
            </p>
        </div>
        <div class="main-we-provide">
            <ul>
                <li><span><img src="images/lunch.png" alt=""></span>
                    <h2>中餐</h2>
                </li>
                <li><span><img src="images/dinner.png" alt=""></span>
                    <h2>晚餐</h2>
                </li>
                <li><span><img src="images/coffee.png" alt=""></span>
                    <h2>甜品/咖啡</h2>
                </li>
            </ul>
        </div>
    </div>


</main>

<main>
    <img class="mdbanner" src="images/mdbanner.jpg">
</main>

<main>
    <ul class="main-submenu">
        <li><a href="#">午餐</a></li>
        <li><a href="#">晚餐</a></li>
        <li><a href="#">甜品</a></li>
        <li><a href="#">饮料</a></li>
    </ul>
    <ul class="main-submenu-info main-submenu-first">
    <c:forEach var="food" items="${foodList }">
        <li><a href="food?method=detail&fid=${food.fid}">
            <div class="food-name">
                <p>${food.fname}</p>
           
            </div>
            <div class="food-price">
                <p>￥<span>${food.f_price}</span></p>
            </div>
            <div class="img-bg"></div>
            <img src="images/${food.image}"></a>
        </li>
       </c:forEach>
       
    </ul>
    <a class="more" href="${pageContext.request.contextPath }/food?method=foodList&currentPage=1">MORE</a>
</main>

<jsp:include page="/footer.jsp"></jsp:include>
</body>

<script src="${pageContext.request.contextPath }/lib/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath }/lib/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/js/main.js"></script>
</html>