<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>美食城</title>
<meta charset="utf-8">
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
 	<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
<div class="buyinfo">
<form action="${pageContext.request.contextPath}/food?method=addCart" method="post">
    <div class="buyDtlLeft">
    <img src="${pageContext.request.contextPath }/images/${food.image}"/>
    </div>
    <div class="buyDtl">
    <div class="buyDtlRight">
    <h3>${food.fname }</h3>
    <h5><strong id="price_item_1">菜品：${food.fname }</strong></h5>
    <br/>
     <h4><strong id="price_item_1">配料：${food.batch }</strong></h4>
    <br/>
    <table class="buyTable">
     <tr>
      <th width="70">购买数量</th>
      <td>
       <div class="p_number">
		<div class="f_l add_chose">
		 <input id="num" name="quantity" value="1" maxlength="4" size="10" type="text">
		</div>
		
	
	
	</div>
      </td>
     </tr>

    </table><!--buyTable/-->
           	<div class="f_l buy">
			单价：<span class="total-font" id="total_item_1">￥${food.f_price }</span>
			<input type="hidden" name="total_price" id="total_price" value="" />
			 <input type="hidden" name="fid" value="${food.fid }">
		</div>
    <div class="goumai">
    
     <input value="加入购物车" type="submit" class="buy-mai">
    </div><!--goumai/-->
   </div><!--buyDtlRight/-->
   </div>
   <div class="clears"></div>
   </form>
   
  </div><!--buyDtl/-->

</body>
	<jsp:include page="/footer.jsp"></jsp:include>

</html>