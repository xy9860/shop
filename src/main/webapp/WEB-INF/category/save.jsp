<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		form div{
			margin: 8px;
			
		}
		form div a{
			float: right;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("input[name=ctype]").validatebox({
				required:true,
				missingMessage:'必须输入一个类别名称!',
				tipPosition:'left',
				validateOnCreate:false,//刚开始不验证
				validateOnBlur:true//丢失焦点 验证
			});
			//注册btn事件
			$("#btn").click(function(){
				//如果验证成功就提交数据
				if($("#ff").form("validate")){
					//验证通过  提交数据
					$.messager.progress();	// 显示进度条
					$('#ff').form('submit', {//调用submit提交数据
						url: '',
						onSubmit: function(){
							var isValid = $(this).form('validate');
							if (!isValid){
								$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
							}
							return isValid;	// 返回false终止表单提交
						},
						success: function(){
							$.messager.progress('close');	// 如果提交成功则隐藏进度条
						}
					});


				}else{
					alert(false);
				}
			});
		});
		
	</script>
</head>
<body>
	<form id="ff" method="post">   
	    <div>   
	        <label for="ctype">类别名称:</label>   
	        <input type="text" name="ctype" />   
	    </div>   
	    <div>   
	        <label for="chot"></label>   
	        <input type="radio" name="chot" value="true" checked="checked" /> 热点 
	     	<input type="radio" name="chot" value="true" /> 非热点
	    </div>
	    <br>
		<div>   
	        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>  
	    </div>  
	</form>  
</body>
</html>