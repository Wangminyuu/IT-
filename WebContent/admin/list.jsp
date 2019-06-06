<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/jh?method=toAdd">进货</a> </li>
         
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="300" style="text-align:center; padding-left:20px;">进货单号</th>
       
        <th>商品名称</th>
        <th>价格</th>
        <th>数量</th>
        
        <th>总价</th>
        <th>供应商</th>
        <th>进货日期</th>

        <th width="310">操作</th>
      </tr>
     
    <c:forEach var="jh" items="${jhList }">
     <tr>
       
   
          <td >
          ${jh.jid }</td>
        
          <td>${jh.food.fname }</td>
          <td>${jh.jprice }</td>
          <td>${jh.jnum }</td>
          <td>${jh.jtotal }</td>
          <td>${jh.gys.gysname }</td>
		 <td>${jh.jhdate }</td>
          <td><div class="button-group">
		
			
				
<%-- 			${pageContext.request.contextPath}/jh?method=update&jid=${jh.jid} --%>
				 <a class="button border-red" href="javascript:deleteProduct('${jh.jid}')" onclick="return del(pid)"><span class="icon-trash-o"></span> 删除</a> </div></td>
			</tr>
			</c:forEach>
        

   
      <tr>
      <td colspan="8"><div class="pagelist"> 
       <a href="${pageContext.request.contextPath }/jh?method=list&currentPage=1">首页</a>
      <c:choose>
       <c:when test="${currentPage le 1 }"><a href="#">上一页</a></c:when>
       <c:otherwise>
         <a href="${pageContext.request.contextPath }/jh?method=list&currentPage=${currentPage-1}">上一页</a>
       </c:otherwise>
      </c:choose>
        <c:forEach begin="1" end="${totalPage }" var="index">
          <c:choose>
            <c:when test="${index eq currentPage }">
               <span class="current">${index}</span>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath }/jh?method=list&currentPage=${index}">${index}</a>
            </c:otherwise>
          </c:choose>
        </c:forEach>
        
       <c:choose>
         <c:when test="${currentPage ge totalPage }"><a href="#">下一页</a></c:when>
         <c:otherwise>
             <a href="${pageContext.request.contextPath }/jh?method=list&currentPage=${currentPage+1}">下一页</a>
         </c:otherwise>
       </c:choose>
        
       
         
         <a href="${pageContext.request.contextPath }/jh?method=list&currentPage=${totalPage}">尾页</a>
          </div></td>
      </tr>
     
    </table>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
	function deleteProduct(jid){
				if(window.confirm("确定删除吗？")){
					location.href="${pageContext.request.contextPath}/jh?method=detelejh&jid="+jid;
				}
				
			}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
</body>
</html>