<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>美食城网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/default.css">
<meta charset="utf-8">
<link type="text/css" href="css/css.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/default.css">

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
 	<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
</head>
<body>

<form >
<div class="car">
  <div class="cont">
   <div class="carImg"><img src="images/car2.jpg" width="951" height="27" /></div>
  <table class="orderList">
    <tr>
     <th width="20"></th>
     <th width="450">商品</th>
     <th width="130">单价</th>
     <th width="130">数量</th>
     <th width="130">总金额</th>
     <th width="105">操作</th>
    </tr>
<c:forEach var="entry" items="${cart.cartItems }" varStatus="status">
<c:set var="cartItem" value="${entry.value }"></c:set>
    <tr>
    <td colspan="5" style="text-align:left;color:#930; font-weight:bold;">
      <img src="images/dianpu.gif" width="20" height="15" style="position:relative;top:2px;" />
      efood美食城
     </td>
    </tr>
    <tr>
     <td></td>
     <td>
      <dl>
       <dt><a href=""><img src="${pageContext.request.contextPath}/images/${cartItem.food.image }" width="85" height="85" /></a></dt>
       <dd>${cartItem.food.fname }<br/></dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥${cartItem.food.f_price }</strong></td>
     <td>
     <input type="text" id="num_${status.index}" name="num" value="${cartItem.buyNum }" maxlength="4" size="10">
     </td>
     <td><strong class="red">￥${cartItem.subTotal }</strong></td>
     
     <td><a href="${pageContext.request.contextPath}/food?method=deleteCart&fid=${cartItem.food.fid}" class="green">删除</a></td>
    </tr>
 </c:forEach>
   
   
  
   </table><!--orderList/-->
   <div class="zongji">
   <strong>总计(不含运费)：</strong><strong class="red">￥${cart.total }</strong>
   </div><!--zongji/-->





   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->
</form>
<div>
			<hr />
		<form class="form-horizontal" id="orderForm" style="margin-top: 5px; margin-left: 150px;" 
		action="${pageContext.request.contextPath }/order?method=dispact" method="post">
				<input type="hidden" name="orderid" value="${order.oid }">
				<div class="form-group">
					<label for="username" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address"
							value="${user.address }">  
							<a href="${pageContext.request.contextPath }/address.jsp">添加默认地址</a>
							
					</div>
				</div>     
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="inputPassword3" name="name"
							value="${user.name }">
					</div>
				</div>
				<div class="form-group">
					<label for="confirmpwd" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="confirmpwd" name="tel"
							value="${user.tel }">
					</div>
				</div>
				


			<hr />
	<p style="text-align: right; margin-right: 100px;">
					<a href="javascript:document.getElementById('orderForm').submit();">
						<img src="${pageContext.request.contextPath }/images/finalbutton.gif" width="204" height="51"
						border="0" />
					</a>
				</p>
			
			</form>
		</div>

</body>
<footer>
    <!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
</footer>

</body>


</html>