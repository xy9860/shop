<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
</head>
<body>
	<a href="send_main_aindex.action">直接到后台 ui版本</a><br />
<%-- 	<a href="send_main_index.action">直接到后台 framset版本</a><br />
	<a href="${shop }/category_updata.action?category.type=儿童&category.id=1&category.hot=false">updata测试ssh环境</a>
	<a href="category_save.action">save测速struts和spring环境</a><br />
	<a href="category_query.action">查询所有类别</a><br />
	<a href="category_update.action?type=111&cid=1&hot=false">updata测试值栈赋值</a><br />
	<a href="account_query.action">查询所有客服</a><br />
	 <c:forEach items="${requestScope.categorys}" var="category">requestScope
		${category.cid}|${category.type}|${category.hot}<br />
		<hr>
	</c:forEach> 
	<c:forEach items="${sessionScope.categorys}" var="category">sessionScope
		${category.cid}|${category.type}|${category.hot}<br />
		<hr>
	</c:forEach>
	<c:forEach items="${applicationScope.categorys}" var="category">application
		${category.cid}|${category.type}|${category.hot}<br />
		<hr>
	</c:forEach> --%>
	
</body>
</html>