<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<style type="text/css">
form div {
	margin: 8px;
}

form div a {
	float: right;
}
</style>
<script type="text/javascript">
	$(function() {
		//ifram中的 DG对象
		var iframedg = parent.$("iframe[title='product']").get(0).contentWindow.$("#dg");
		var rows = iframedg.datagrid("getSelections");//获得选中行
		//远程加载管理员的下拉列表框
		$('#cc').combobox({
				url : 'category_query.action',
				valueField : 'cid',
				textField : 'ctype',
				panelHeight:'auto',//自动调整下拉列表框高度
				editable:false//不能自己输入值 只能使用下拉功能
		});
		//完成数据的回显
		

		$('#ff').form('load', {
			pid:rows[0].pid,
			pname : rows[0].pname,
			price : rows[0].price,
			pic : rows[0].pic,
			premark : rows[0].premark,
			pxremark : rows[0].pxremark,
			pcommend : rows[0].pcommend,
			popen : rows[0].popen,
			'category.cid':rows[0].category.cid//默认勾选 已经有的管理员
		/* alogin:row[0].alogin, */
		});

		$("form input").validatebox({
			required:true,
			missingMessage:'必须输入一个值!',
			tipPosition:'left',
			validateOnCreate:false,//刚开始不验证
			validateOnBlur:true//丢失焦点 验证
		});
		//注册btn事件
		$("#btn").click(function() {
			//如果验证成功就提交数据
			if ($("#ff").form("validate")) {
				//验证通过  提交数据
				$.messager.progress(); // 显示进度条
				$('#ff').form('submit', {//调用submit提交数据
					url : 'product_update.action',
					success : function() {
						$.messager.progress('close'); // 如果提交成功则隐藏进度条
						//关闭当前窗体
						parent.$("#win").window("close");
						//刷新数据表
						//jq对象不兼容//parent.$("iframe[title='category']").contents().find("#dg").datagrid('reload');
						//不能直接选择easyui//parent.$("iframe[title='category']").$("#dg").datagrid('reload');
						//使用dom对象  向下强转 dom兼容高
						iframedg.datagrid('reload');
					}
				});

			}
		});
	});
</script>
</head>
<body>
	<form id="ff" method="post">   
	    <div>   
	        <label for="pname">商品名称:</label>   
	        <input type="text" name="pname" />
	        <input type="hidden" name="pid">
	    </div>   
	    <div>   
	        <label for="price">商品价格:</label>   
	        <input type="text" name="price" />   
	    </div> 
	    <div>   
	        <label for="pic">商品图片:</label>   
	        <input type="text" name="pic" />   
	    </div> 
	    <div>   
	        <label for="premark">简单介绍:</label>   
	        <input type="text" name="premark" />   
	    </div> 
	    <div>   
	        <label for="pxremark">详细介绍:</label>   
	        <input type="text" name="pxremark" />   
	    </div> 
	    <div>   
	        <label for="pcommend"></label>   
	        <input type="radio" name="pcommend" value="true" checked="checked" /> 推荐
	     	<input type="radio" name="pcommend" value="false" /> 不推荐
	    </div>
	    <div>   
	        <label for="popen"></label>   
	        <input type="radio" name="popen" value="true" checked="checked" /> 有效 
	     	<input type="radio" name="popen" value="false" /> 无效
	    </div>
	    <div>
			<label for="account">所属类别:</label>
			<input id="cc" name="category.cid">
		</div>
		<div>   
	        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新商品</a>  
	    </div>  
	</form> 
</body>
</html>