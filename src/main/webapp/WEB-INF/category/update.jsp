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
		var iframedg = parent.$("iframe[title='category']").get(0).contentWindow.$("#dg");
		var rows = iframedg.datagrid("getSelections");//获得选中行
		//远程加载管理员的下拉列表框
		$('#cc').combobox({
			url : 'account_query.action',
			valueField : 'aid',
			textField : 'alogin',
			panelHeight:'auto'
		});
		//完成数据的回显
		

		$('#ff').form('load', {
			cid : rows[0].cid,
			ctype : rows[0].ctype,
			chot : rows[0].chot,
			'account.aid':rows[0].account.aid//默认勾选 已经有的管理员
		/* alogin:row[0].alogin, */
		});

		$("input[name=ctype]").validatebox({
			required : true,
			missingMessage : '必须输入一个类别名称!',
			tipPosition : 'left',
			validateOnCreate : false,//刚开始不验证
			validateOnBlur : true
		//丢失焦点 验证
		});
		//注册btn事件
		$("#btn").click(function() {
			//如果验证成功就提交数据
			if ($("#ff").form("validate")) {
				//验证通过  提交数据
				$.messager.progress(); // 显示进度条
				$('#ff').form('submit', {//调用submit提交数据
					url : 'category_save.action',
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
			<input type="hidden" id="cid"> <label for="ctype">类别名称:</label>
			<input type="text" name="ctype" />
		</div>
		<div>
			<label for="chot"></label> <input type="radio" name="chot"
				value="true" checked="checked" /> 热点 <input type="radio"
				name="chot" value="false" /> 非热点
		</div>
		<div>
			<label for="account">所属客服:</label> <input id="cc"
				name="account.aid">
		</div>
		<div>
			<a id="btn" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit'">更新类别</a>
		</div>
	</form>
</body>
</html>