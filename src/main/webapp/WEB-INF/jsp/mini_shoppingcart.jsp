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
<c:forEach items="${listcart}" var="cart">
			<div class="one">
					<img src="upload/${cart.shp_tp}" width="50px"/>
					<span class="one_name">
						${cart.sku_mch}
					</span>
					<span class="one_prece">
						<b>￥${cart.sku_jg}</b><br />
						&nbsp;&nbsp;&nbsp;删除
					</span>
				</div>
	</c:forEach>
	<div class="gobottom">
					共<span>${count}</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
					共计￥<span>${sum}</span>
					<button class="goprice">去购物车</button>
				</div>
</body>
</html>