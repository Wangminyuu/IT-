<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp"></jsp:include>
<main>
    <div class="main-head">
        <p><span>配送方式</span></p>
    </div>
    <div class="main-team">
        <ul>
            <li><span><img src="images/p1.jpg" alt=""></span>
                <h2>配送中心配送</h2>
              
                <p>配送中心配送的组织者是以配送为专职的配送中心，通常规模比较大，种类，存储量比较多，
专业性强，和用户有固定的配送关系。</p></li>
            <li class="main-team-display"><span><img src="images/p2.jpg" alt=""></span>
                <h2>生产中心配送</h2>
             
                <p>生产中心配送的组织者是生产制造加工中心，尤其是进行多种生产的企业。
这些企业可以通过自己的配送系统进行配送，而不需要再将产品发运分配到配送中心进行配送。</p></li>
            <li><span><img src="images/p3.jpg" alt=""></span>
                <h2>仓库配送</h2>
               
                <p>仓库配送是以仓库为物流节点组织的配送。它既可以将仓库完全作为配送中心，
也可以在保持仓库仓储功能的基础上再增加一部分配送职能。</p></li>
        </ul>
        <span class="prevbtn"></span>
        <span class="nextbtn"></span>
    </div>
</main>
   <hr/>
   	<form class="form-horizontal" id="orderForm" style="margin-top: 5px; margin-left: 150px;" 
		action="${pageContext.request.contextPath }/food?method=findFoodList" method="post">
   <table class="query_form_table" id="table1" style="margin: auto;">
   <tr>
   <th style="font-size: 25px;">选择配送方式:&nbsp;&nbsp;</th>
		<td>
			<select name="D1" style="width: 150px">
				<option>请选择...</option>
				<c:forEach var="dispact" items="${transferList }">
				<option>${dispact.tname }</option>
				</c:forEach>
			</select> <span class="red_star">*</span></td>

</tr>
</table>
</form>
<p style="text-align: right; margin-right: 100px;">
						<a
							href="javascript:document.getElementById('orderForm').submit();">
							<img src="./images/finalbutton.gif" width="204" height="51"
							border="0" />
						</a>
					</p>
					<hr />
<jsp:include page="/footer.jsp"></jsp:include>


</body>

<script src="lib/jquery/jquery.js"></script>
<script src="lib/bootstrap/bootstrap.js"></script>
<script src="js/main.js"></script>
</html>