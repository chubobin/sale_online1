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
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function change_the_param(cart_id,sku_id,shfxz,tjshl){
		if(shfxz==true){
			shfxz="1";
		}else if(shfxz==false){
			shfxz="0";
		}
		$.ajax({
			url:"change_shoppingcart.do",
			type:"post",
			data:{
				id:cart_id,
				sku_id:sku_id,
				shfxz:shfxz,
				tjshl:tjshl
			},
			success:function(data){
				$("#shopingcart_inner").html(data);
			}
			
		})
		
	}
	function to_order_page(){
		window.location.href="to_order_page.html";
	}
</script>
</head>
<style type="text/css">
	td{vertical-align: middle !important;}
	.form-group{padding: 5px 0;}
</style>
<body id="shopingcart_inner">
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
	<div class="top_img">
		<img src="images/top_img.jpg" alt="">
	</div>
	<div class="search">
	<div class="logo"><img src="images/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
		<div class="card">
			
			
			<!--购物车商品-->
		<jsp:include page="new_shoppingcart.jsp"></jsp:include>
		
		</div>
	</div>
	<div class="Cbox">
		<table class="table table-striped table-bordered table-hover" >
		   <thead>
		     <tr>
		     	<th>复选框</th>
		       <th>商品图片</th>
		       <th>商品名称</th>
		       <th>商品属性</th>
		       <th>商品价格</th>
		       <th>商品数量</th>
		       <th>操作</th>
		     </tr>
		   </thead>
		   <tbody >
		   <c:forEach items="${listcart}" var="cart" varStatus="index">
		     <tr>
		     	<td><input id="shoppingcart_input_${index.index}" type="checkbox" value="${cart.shfxz}" ${cart.shfxz=="1"?"checked":""}
		onclick="change_the_param(${cart.id},${cart.sku_id},this.checked,-1)"/></td>
		       <td><img src="upload/${cart.shp_tp}" width="50px"/></td>
		       <td>${cart.sku_mch}</td>
		       <td>
		       		颜色：<span style='color:#ccc'>白色</span><br>
		       		尺码：<span style='color:#ccc'>L</span>
		       </td>
		       <td>${cart.sku_jg}</td>
		       <td><a href="javascript:change_the_param(${cart.id},${cart.sku_id},$('#shoppingcart_input_${index.index}').val(),${cart.tjshl-1});">-</a>
		${cart.tjshl}
		<a href="javascript:change_the_param(${cart.id},${cart.sku_id},$('#shoppingcart_input_${index.index}').val(),${cart.tjshl+1});">+</a>&nbsp;&nbsp;&nbsp;${cart.hj}
		<br></td>
		       <td>删除</td>
		     </tr>
		     </c:forEach>
		   </tbody>
	 	</table>
	</div>
	<div class="Cprice">
		<div class="price">总价：${sum}</div>
		<div class="jiesuan" onclick="to_order_page()">结算</div>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>