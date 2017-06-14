<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath %>" />
</head>
<body>
<div id="display_inner" class="Sbox">
		<c:forEach items="${skulist}" var="sku">
			<div class="list">
			<div class="img"><img src="upload/${sku.product.shp_tp}" width="200px" height="150px"></div>
			
			<div class="price">库存：${sku.kc}</div>
			<div class="price">¥${sku.jg}</div>
			
			<div class="title"><a href="display_sku_details/${sku.id}/${sku.product.id}.html">${sku.product.shp_mch}</a></div>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>