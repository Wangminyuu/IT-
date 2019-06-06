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
 	<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
</head>
<body>

<h4 style="margin-left: 120px; margin-top: 30px;color: black;font-weight: bolder;" >添加默认地址</h4>
			<hr />
		<form class="form-horizontal" id="addressForm" style="margin-top: 5px; margin-left: 150px;" 
		action="${pageContext.request.contextPath }/user?method=addAddress" method="post">
				<input type="hidden" name="orderid" value="${order.oid }">
				<div class="form-group">
					<label for="username" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address"
							placeholder="请输入收货地址">
					</div>
				</div>    
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="inputPassword3" name="name"
							placeholder="请输收货人">
					</div>
				</div>
				<div class="form-group">
					<label for="confirmpwd" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="confirmpwd" name="tel"
							placeholder="请输入联系方式">
					</div>
				</div>
				


			<hr />
	<p style="text-align: right; margin-right: 100px;">
	<input type="submit" value="设为默认地址">
<!-- 					<a href="javascript:document.getElementById('addressForm').submit();"> -->
						
<!-- 					</a> -->
				</p>
			
			</form>
		</div>

</body>
<footer>
	<jsp:include page="/footer.jsp"></jsp:include>
</footer>

</body>


</html>