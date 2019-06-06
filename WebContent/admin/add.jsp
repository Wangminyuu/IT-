<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
   function a() {
	var num=$("#jnum").val();
	var jprice=$("#jprice").val();
	var jtotal=parseInt(num)*parseInt(jprice);
     $("#jtotal").val(jtotal);
}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/jh?method=add">  

    <table class="table table-bordered table-hover definewidth m10">
    
    <tr>
        <td width="10%" class="tableleft">商品名称
        
        </td> 
           
         <td>
         <select name="fid" class="input w50">
            <c:forEach var="food" items="${foodlist }">
             
              <option value="${food.fid }">${food.fname }</option>
            </c:forEach>
            </select>
        </td>
    </tr>
  
    <tr>
        <td class="tableleft">商品价格</td>
        <td>        <input type="number" name="jprice" id="jprice" />
        </td>
    </tr>
    <tr>
        <td class="tableleft">进货数量</td>
        
        <td><input type="number" name="jnum" id="jnum" onblur="a()"/>
          
        </td>
        
    </tr>
    <tr>
        <td class="tableleft">总金额</td>
        <td><input type="text"  disabled="disabled" name="jtotal" id="jtotal" /></td>
    </tr>
    <tr>
        <td class="tableleft">供应商</td>
         <td>
         <select name="gysid" class="input w50">
            <c:forEach var="gys" items="${gyslist }">
              <option value="${gys.id }">${gys.gysname }</option>
            </c:forEach>
            </select>
        </td>
    </tr> <tr>
        <td class="tableleft">进货日期</td>
        <td>
            <jsp:useBean id="now" class="java.util.Date"></jsp:useBean> 
        	<input type="text" name="jhdate" value="<fmt:formatDate value='${now }' type="date" pattern="yyyy/MM/dd" />" />
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button>
        </td>
    </tr>
</table>
    </form>
  </div>
</div>

</body>

</body>
</html>