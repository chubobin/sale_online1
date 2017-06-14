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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

function order_produce_choose_address(address_id,address_yh,address_shjr){
	$("#order_produce_div").empty();
	$("#order_produce_div").append("<input type='hidden' name='id' value='"+address_id+"'>");
	$("#order_produce_div").append("<input type='text' name='yh_dz' value='"+address_yh+"'>");
	$("#order_produce_div").append("<input type='hidden' name='shjr' value='"+address_shjr+"'>");
}
</script>

</head>
<body>

	<c:forEach items="${list_address}" var="address">
		<input type="radio" name="choose" onclick="order_produce_choose_address(${address.id},'${address.yh_dz}','${address.shjr}')"/>${address.yh_dz}:${address.shjr}
	</c:forEach>
	<c:forEach items="${allOrder}" var="order">
		${order.orderinfo[0].sku_kcdz}
		<br>
		<div style="border:1px red solid;">
			<c:forEach items="${order.orderinfo}" var="info">
					<img alt="" src="upload/${info.shp_tp}" width="150px">
					<br>
					${info.sku_mch}<br>
				</c:forEach>
		</div>
	</c:forEach>
	<form action="to_submit_order.do" method="post">
	<div id="order_produce_div">
	
	</div>
	<input type="submit" value="提交订单" />
	</form>
</body>
</html>