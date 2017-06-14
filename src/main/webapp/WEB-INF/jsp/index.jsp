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
	$(function(){
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#index_ul_class_1").append("<li onmouseover='index_display_class_2(this.value)' value="+json.id+"><a href='javascript:;'>"+json.flmch1+"</a></li>");
			});
		});
		var user=index_get_cookie("lgoinuser");
		$("#index_span_login").html(decodeURIComponent(user));
	})
	
	function index_display_class_2(class_1_id){
		$("#index_ul_class_2").empty();
		$("#index_ul_class_2").show();
		$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
			$(data).each(function(i,json){
				$("#index_ul_class_2").append("<li  value="+json.id+"><a href='index_select_attr_sku/"+json.id+"/"+json.flmch2+"/.html;'>"+json.flmch2+"</a></li>");
			});
		});
	}
	
	function index_get_cookie(key){
		var cookie=document.cookie;
		var cookies=cookie.split(";");
		
		for(var i=0;i<cookies.length;i++){
			var values=cookies[i].split("=");
			if(values[0]==key){
				return values[1];
			}
		}
	}
	
	
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
	<div class="top_img">
		<img src="images/top_img.jpg" alt="">
	</div>
	<div class="search">
		<div class="card">
			
			
			<!--购物车商品-->
		<jsp:include page="new_shoppingcart.jsp"></jsp:include>
		
		</div>
	</div>
	<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini">
						<ul id="index_ul_class_1">
							<li>
								<a href="">家用电器</a>
								<div class="two_nav" id="index_ul_class_2">
									<a href="">11111</a>
								</div>
							</li>
							<li><a href="">手机、数码、通信</a></li>
							<li><a href="">电脑、办公</a></li>
							<li><a href="">家具、家居、家装</a></li>
						</ul>
					</div>
				</div>
				<ul>
					<li><a href="">服装城</a></li>
					<li><a href="">美妆馆</a></li>
					<li><a href="">超市</a></li>
					<li><a href="">全球购</a></li>
					<li><a href="">闪购</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">拍卖</a></li>
					<li><a href="">金融</a></li>
					<li><a href="">智能</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="banner">
		<div class="ban">
			<img src="./images/banner.jpg" width="980" height="380" alt="">
		</div>
	</div>
</body>
</html>