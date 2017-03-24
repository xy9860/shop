<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head_fore.jspf" %>
</head>
<body>
<div style="width: 700px">
	<c:forEach items="${applicationScope.bankList}" var="bankImage" >
		<span>
			<input value="${bank}" type="radio" name="" value="${fn:substring(bankImage,0,fn:indexOf(bankImage,'.')) }" />
			<img src="${shop}/bank/${bankImage}" />
		</span>
	</c:forEach>
</div>
</body>
</html>