<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<jsp:include page="/header.jsp"></jsp:include>
<main >

    <div>
        <div class="main-head">
            <p>
                <span>菜式欣赏</span>
            </p>
        </div>
    </div>
</main>
<main>
    <img class="mdbanner" src="images/mdbanner.jpg">
</main>
<main>
    <div class="main-body">
        <p><span>每一种食物来源都经过我们的精挑细选，关于食材我们只选最天然、健康、优质的，只为一份对极致美味的追求，用心做好每一份菜，是我们不变的宗旨。</span></p>
        <ul class="main-body-img">
            <li><img src="images/mdlist1.jpg"></li>
            <li><img src="images/mdlist2.jpg"></li>
            <li><img src="images/mdlist3.jpg"></li>
            <li><img src="images/mdlist4.jpg"></li>
            <li><img src="images/mdlist5.jpg"></li>
            <li><img src="images/mdlist6.jpg"></li>
            <li><img src="images/mdlist7.jpg"></li>
            <li><img src="images/mdlist8.jpg"></li>
            <li><img src="images/mdlist9.jpg"></li>
        </ul>
    </div>
</main>
<main>
    <ul class="main-submenu" id="dishesContent">
      
      <c:forEach var="dishes" items="${dishesList }">
    <input type="hidden" name="did" value="${dishes.did }">
 
        <li><a href="${pageContext.request.contextPath }/food?method=foodListByDishes&currentPage=1&did=${dishes.did}">${dishes.dname }</a></li>
       </c:forEach>
 
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
    <nav aria-label="Page navigation">
        <ul class="pagination">
        <c:choose>
			  <c:when test="${currentPage eq 1 }">
			     <li>
                <a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=1" aria-label="Next">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
			  </c:when>
			  <c:otherwise>
			    <li ><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=${currentPage-1}" aria-label="Previous"><span
					aria-hidden="true">上一页</span></a></li>
			  </c:otherwise>
			</c:choose>
			
			<c:forEach var="index" begin="1" end="${allPages }">
			<c:choose>
			    <c:when test="${index eq currentPage }">
			    <li><a href="">${index }</a></li>
			    </c:when>
			    <c:otherwise>
                  <li><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=${index}">${index }</a></li>
			    </c:otherwise>
			</c:choose>
			</c:forEach>
			
			<c:choose>
			   <c:when test="${currentPage ge allPages }">
			     <li class="disabled"><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=${allPages}" aria-label="Next"><span
						aria-hidden="true">下一页</span></a></li>
			   </c:when>
			   <c:otherwise>
			    <li ><a href="${pageContext.request.contextPath }/food?method=foodList&currentPage=${currentPage+1}" aria-label="Next">
			    <span aria-hidden="true">下一页</span></a></li>
			   </c:otherwise>
			</c:choose>	
           
        </ul>
    </nav>
</main>


<jsp:include page="/footer.jsp"></jsp:include>

</body>

<script src="lib/jquery/jquery.js"></script>
<script src="lib/bootstrap/bootstrap.js"></script>
<script src="js/main.js"></script>
</html>