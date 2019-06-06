<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/pintuer.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/admin.css" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript">
	function deleteHeader(hid) {
		if(window.confirm("确定要删除吗？")){
			location.href="${pageContext.request.contextPath}/header?method=delete&hid="+hid;
		}
	}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
 
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">编号</th>
      <th width="15%">商品名称</th>
       <th width="15%">库存数量</th>
     
    </tr>
    
   	<c:forEach var="kc" items="${foodList }">
			<tr style="text-align: center;">
				<td>${kc.fid }</td>
				<td>${kc.fname }</td>
				
				<td>${kc.num }</td>
				
			</tr>
			</c:forEach>
    <tr>
      <td colspan="8"><div class="pagelist"> 
	      <c:choose>
	      <c:when test="${currentPage le 1 }"><a href="">上一页</a></c:when>
	      <c:otherwise>
	        <a href="${pageContext.request.contextPath }/food?method=findkcfood&currentPage=${currentPage-1}">上一页</a>
	      </c:otherwise>
	      </c:choose>
         
	     <c:choose>
         <c:when test="${currentPage ge totalPage }"><a href="">下一页</a></c:when>
         <c:otherwise>
             <a href="${pageContext.request.contextPath }/food?method=findkcfood&currentPage=${currentPage+1}">下一页</a>
         </c:otherwise>
	      </c:choose> 
      </div></td>
     </tr>
      
  </table>
</div>

</body>
</html>