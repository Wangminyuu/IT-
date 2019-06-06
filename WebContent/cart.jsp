<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>美食城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/default.css">
<meta charset="utf-8">
<link type="text/css" href="css/css.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/default.css">

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript">
		    function updateCart(index,fid){
		    	var num=$("#num_"+index).val();
		    	window.location.href="${pageContext.request.contextPath}/food?method=updateCart&fid="+fid+"&num="+num;
		    }
		
		</script>
 	<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
</head>

<body>

<div class="car">
  <div class="cont">
   <div class="carImg"><img src="images/car1.jpg" width="951" height="27" /></div>
      <form action="${pageContext.request.contextPath}/order?method=addOrder" method="post">
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
     
     <td><a href="${pageContext.request.contextPath}/food?method=deleteCart&fid=${cartItem.food.fid}" class="green">删除</a>
      <a href="javascript:updateCart(${status.index},'${cartItem.food.fid}')" class="green">更新</a>
     </td>
    </tr>
 </c:forEach>
    <tr> 
     <td colspan="6"><div class="shanchu"><img src="images/lajio.jpg" /><a href="${pageContext.request.contextPath}/food?method=clearCart&fid=${cartItem.food.fid}">全部删除</a></div></td>
    </tr>
  
   </table><!--orderList/-->
   <div class="zongji">
   <strong>总计(不含运费)：</strong><strong class="red">￥${cart.total }</strong>
   </div><!--zongji/-->
   <div class="jiesuan">
    <a href="default.jsp" class="jie_1">继续购物&gt;&gt;</a>
   
<input type="submit" width="100" value="提交订单" name="submit" border="0">
<!--     <a href="" class="jie_2">立即结算&gt;&gt;</a> -->
  </form>
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->

    <!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>

</body>


</html>