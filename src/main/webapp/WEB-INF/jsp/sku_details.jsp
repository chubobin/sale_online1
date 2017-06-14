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
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="top">
		<div class="top_text">
			<c:if test="${user!=null}">
			<a>${user.yh_nch} 欢迎登录</a>
			<a href="logout.do">登出</a>
			</c:if>
			<c:if test="${user==null}">
			<a id="index_span_login"></a>
			</c:if>
		<a href="tologin.html">请登录</a>
		</div>
	</div>
	<form id="sku_details_form_data" method="post" action="add_cart.do">
	<div>
			<c:forEach items="${details.list_image}" var="image">
				<img src="upload/${image.url}" width="100px"/><br>
			</c:forEach>
			<c:forEach items="${skulist}" var="sku">
				<a href="display_sku_details/${sku.id}/${sku.shp_id}.do">${sku.sku_mch}</a><br>
			</c:forEach>
			库存：${details.kc}<br>
			价格：${details.jg}<br>
			商品描述:${details.product.shp_msh}<br>
			<c:forEach items="${details.list_attr_value }" var="attr">
				${attr.attr_name}:${attr.attr_value}<br>
			</c:forEach>
			<!-- 以下是要提交的数据 -->
			<input type="hidden" name="shp_tp" value="${details.list_image[0].url}" />
			<input type="hidden" name="sku_id" value="${details.id}" />
			<input type="hidden" name="kcdz" value="${details.kcdz}" />
			<input type="hidden" name="sku_mch" value="${details.sku_mch}" />
			<input type="hidden" name="sku_jg" value="${details.jg}" />
			<input type="hidden" name="shp_id" value="${details.shp_id}" />
	</div>
		<input type="text" name="tjshl" />
		<input type="submit" value="加入购物车" />
	</form>
</body>
</html>