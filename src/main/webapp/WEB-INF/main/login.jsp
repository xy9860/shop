<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
</head>
<body>
<div align="center">
    <h2>管理员登陆</h2>
    <p>请输入你的账户和密码</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="管理员登陆" style="width:100%;max-width:400px;padding:30px 60px;">
        <div style="margin-bottom:10px">
            <input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input type="checkbox" checked="checked">
            <span>记住密码</span>
        </div>
        <div>
            <a href="" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
                <span style="font-size:14px;">Login</span>
            </a>
        </div>
    </div>
</div>
</body>
</html>