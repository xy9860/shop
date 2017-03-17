<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
$(function () {
	$('#dg').datagrid({
	    url:'product_queryJoinCategory.action',//请求数据的url地址
	    queryParams:{pname:''},//当请求远程数据时，发送的额外参数。
	    idField:'pid',//指定cid为标识字段 可以隔着页面选中
	    striped:true,//奇偶行变色
	    fitColumns:true,//自动适应列  设置这个以后不会出现水平滚动条
	    loadMsg:'数据正在加载,请稍后.....',//数据加载等待时显示的提示消息
	    nowrap:true,//数据是不是显示在一行  默认为true
	    //singleSelect:true,//是否只能选择单行  全选功能失效
	    pagination:true,//显示分页的工具箱
	    frozenColumns:[[//冻结这列 不能移动
	    	 {field:'checked',checkbox:true},//行前面添加复选框
	    	 {field:'pid',title:'商品编号',width:100}
	    ]],
	    /* rowStyler: function(index,row){//行设置style
			//console.info("index"+index,+","+row);//发送消息到浏览器控制台
			if(index%2==0){
				return 'background-color:#6293BB;color:#fff;';//返回值交给style
			}
		}, */
	     columns:
	    	 [[//配置列字段    field是列字段名称与json key捆绑 tietle 标题 是显示层

	        {field:'pname',title:'商品名称',width:100,formatter: function(value,row,index){
				//用来格式化当前列的值 返回当前列的数据
				return "<span title="+value+">" +value+"</span>";//鼠标放上去提示当前内容
			}
		},
	        {field:'price',title:'商品价格',width:100},
	        {field:'pic',title:'商品图片',width:100},
	        {field:'premark',title:'商品简介',width:100},
	        {field:'pxremark',title:'商品详细介绍',width:100,formatter: function(value,row,index){
				//用来格式化当前列的值 返回当前列的数据
				return "<span title="+value+">" +value+"</span>";//鼠标放上去提示当前内容
			}
		}, 
		 {field:'pdate',title:'商品创建时间',width:100,formatter: function(value,row,index){
				//用来格式化当前列的值 返回当前列的数据
				return "<span title="+value+">" +value+"</span>";//鼠标放上去提示当前内容
			}
		}, 
		{field:'pcommend',title:'推荐',width:100,align:'right',formatter: function(value,row,index){
			//用来格式化当前列的值 返回当前列的数据
			if(value){
				return "<input type='checkbox' checked='checked' disabled='true' />";
			}else{
				return "<input type='checkbox' disabled='true' />";
			}
				}
			},
			{field:'popen',title:'开启',width:100,align:'right',formatter: function(value,row,index){
				//用来格式化当前列的值 返回当前列的数据
				if(value){
					return "<input type='checkbox' checked='checked' disabled='true' />";
				}else{
					return "<input type='checkbox' disabled='true' />";
				}
					}
				},
		{field:'product.category.ctype',title:'所属类别',width:100,formatter: function(value,row,index){//这里不能直接用列名读取 必须使用格式输出
				//用来格式化当前列的值 返回当前列的数据
				 if(row.category!=null&&row.category.ctype!=null){
					return row.category.ctype;
				}else{
					return "暂无";
				}
			}
		}
	    ]],
	    toolbar: [{
			iconCls: 'icon-add',
			text:'添加类别',
			handler: function(){alert('编辑按钮');}
		},'-',{
			iconCls: 'icon-edit',
			text:'更新类别',
			handler: function(){alert('帮助按钮');}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除类别',
			handler: function(){
				//判断是否有选中
				var rows=$('#dg').datagrid("getSelections");//返回被选中的行 如果没有任何行被选中返回 空数组
				if(rows.length==0){
					//提示没有选中
					$.messager.show({
						title:'错误提示',
						msg:'至少选择一条语句',
						timeout:3000,
						showType:'slide'
					});
				}else{
					//提示是否确认删除  执行删除的逻辑
					$.messager.confirm('确认执行', '确认删除选中的记录吗?', function(r){
						if (r){
							// 实现删除的方法
						}
					});
				}
			}
		},'-',{
			text:"<input id='ss' name='search' />",
		}]
	});
	//把普通文本框转换为搜索文本框
	$('#ss').searchbox({
		//触发查询事件
	    searcher:function(value,name){//value 文本的内容 name 文本框的内容 	
	        //获取当前的查询信息  从dg重新查询一次
	    	$('#dg').datagrid('load',{ctype:value});
	    },
	    //menu:'#mm',
	    prompt:'查询的内容'
	});
});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>