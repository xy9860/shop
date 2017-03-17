<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<style type="text/css">
#menu {
	width: 200px;
}

#menu ul {
	list-style: none;
	padding: 0px;
	margin: 0px;
}

#menu ul li {
	border-bottom: 1px splid #fff;
}

#menu ul li a {
	display: block;
	background-color: #00a6ac;
	color: #fff;
	padding: 5px;
	text-decoration: none;
}

#menu ul li a:hover {
	background-color: #008792;
}
</style>
<script type="text/javascript">
	$(function() {
		$("a[title]").click(function(){//事件注册
			//判断前后边是不是有相应的tab
			var text=$(this).text();//获得点击的超链接的文本
			var href=$(this).attr("title");//获得 点击带过来的链接
			var id=$(this).attr("id");//获得 点击带过来的链接
			if($("#tt").tabs("exists",text)){//判断tab存在不存在
				$("#tt").tabs("select",text);//选中一个面板
			}else{
				$("#tt").tabs("add",{
					title:text,
					closable:true,//配置面板关闭按钮
					//content:'正文内容'  测试使用直接植入 内容
					//href:href//这里加载的网页只能加载body里面的内容
					content:'<iframe src='+href+' title='+id+' frameborder="0" width="100%" height="100%"></iframe>'//使用内联框架的方式显示
				});//添加一个面板
			}
		});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'欢迎来到易购后台管理系统',split:true"
		style="height: 100px;"></div>
	<!--     <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div> -->
	<!--     <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div> -->
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width: 220px;">
		<!-- 此处显示系统菜单 -->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基本操作">
				<ul>
					<li><a href="#" title="send_category_query.action" id="category">类别管理</a></li>
					<li><a href="#" title="send_product_query.action" id="product">商品管理</a></li>
				</ul>
			</div>
			<div title="高级操作">
				<ul>
					<li><a href="#">类别管理</a></li>
					<li><a href="#">商品管理</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'后台操作'"
		style="padding: 1px; background: #fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省值" style="padding: 20px; display: none;">
				此处现在显示相应的系统信息(操作系统,域名 硬件 或报表)
			</div>
			
		</div>
	</div>
	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div> <!--  //放在这里是为了锁住全屏 在哪里弹出在哪里锁 -->
</body>
</html>