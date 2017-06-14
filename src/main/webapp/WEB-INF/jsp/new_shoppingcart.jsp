<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath %>" />
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function new_shoppingcart_hide(){
		$("#new_div_shoppingcart").hide();
	}
	function new_shoppingcart_show(){
		$.ajax({
			url:"get_minicart.do",
			type:"post",
			success:function(data){
				$("#new_div_shoppingcart").html(data);
			}
		})
		$("#new_div_shoppingcart").show();
		
	}
</script>
<body>
<a href="goto_shoppingcart.do" onmouseover="new_shoppingcart_show()" onmouseout="new_shoppingcart_hide()">购物车<div class="num">0</div></a>
			<div class="cart_pro" id="new_div_shoppingcart" style="display:none;">
				<h6>最新加入的商品</h6>
				
			</div>
</body>
</html>