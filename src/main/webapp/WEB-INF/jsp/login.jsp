<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<form method="get" action="/user/login" >
        用户名：<input type="text" name="name"/><br/>
        密码：<input type="text" name="pwd"/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>