<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品检索页面</title>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var index=0;
	function display_attr_save_data(shxm_id,shxzh_id,shux_mch){
		$("#display_div").append("<a id='display_attr_value_remove_"+shxm_id+"' href='javascript:display_attr_value_down("+shxm_id+");'>"+shux_mch+"</a>"+"&nbsp;&nbsp;&nbsp;");
		$("#display_attr_value_"+shxm_id).hide();
		$("#display_div").append("<input id='display_attr_value_input_"+shxm_id+"_0' type='hidden' name='attrlist["+index+"].shxm_id' value="+shxm_id+" />")
		$("#display_div").append("<input id='display_attr_value_input_"+shxm_id+"_1' type='hidden' name='attrlist["+index+"].shxzh_id' value="+shxzh_id+" />")
		index=index+1;
		diplay_form_submit();
	}
	function display_attr_value_down(shxm_id){
		$("#display_attr_value_remove_"+shxm_id).remove();
		$("#display_attr_value_input_"+shxm_id+"_0").remove();
		$("#display_attr_value_input_"+shxm_id+"_1").remove();
		$("#display_attr_value_"+shxm_id).show();
		index=index-1;
		if(index==0){
			window.location.href="index_select_attr_sku/${class_2_id}/${flmch2}/.do"
		}else{
			
		diplay_form_submit();
		}
		
	}
	function diplay_form_submit(){
		var formdata=$("#dislay_form").serialize();
		var order = $("#display_order_input").val();
		alert(formdata);
		$.ajax({
			url:"get_sku_by_class_2_id_attr/${class_2_id}/"+order+".do",
			data:formdata,
			success:function(data){
				$("#display_inner").html(data);
			}
		})
	}
	function dispaly_order_change(dom){
		var string ="list_beas";
		$(dom).attr("id",string);
		if($(dom).attr("tps")==$("#display_order_input").val()){
			$("#display_order_input").val($(dom).attr("tps")+" desc");
			$(dom).attr("id","");
		}else{
			
		$("#display_order_input").val($(dom).attr("tps"));
		}
		diplay_form_submit();
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
	
	<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini" style="display:none">
						<ul>
							
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
	<div class="filter">
		<h2>电脑、办公 </h2>
		<span class="gt">&gt</span>
		<div class="filter_div">
			电脑整机
		</div>
		<span class="gt">&gt</span>
		<div class="filter_div">
			${flmch2}
		</div>
		<div class="filter_clear">
			清空筛选
		</div>
				
	</div>
	<div class="Sscreen">
	<form id="dislay_form">
	
	<div id="display_div" class="list">
		<span>导航：</span>
		
	</div>
	<div class="list">
			<span class="list_span" onclick="dispaly_order_change(this)" tps="order by sku.sku_xl">销量</span>
			<span class="list_span" onclick="dispaly_order_change(this)" tps="order by sku.jg">价格</span>
			<span class="list_span" onclick="dispaly_order_change(this)" tps="order by sku.jg">评论数</span>
			<span class="list_span" onclick="dispaly_order_change(this)" tps="order by sku.chjshj">上架时间</span>
		</div>
	
	</form>
	<c:forEach items="${listattr}" var="attr">
		<div id="display_attr_value_${attr.id}" class="list">
		<span>${attr.shxm_mch}:</span>
		<c:forEach items="${attr.valuelist}" var="shx">
			<a href="javascript:display_attr_save_data(${attr.id},${shx.id},'${shx.shxzh_mch}${shx.shxzh}');">${shx.shxzh_mch}${shx.shxzh}</a>
		</c:forEach>
		<hr>
		</div>
	</c:forEach>
	</div>
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
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
	
</body>
</html>