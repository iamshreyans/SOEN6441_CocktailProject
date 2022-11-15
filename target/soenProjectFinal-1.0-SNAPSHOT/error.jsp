<%--
  Created by IntelliJ IDEA.
  User: shubham
  Date: 12/11/2022
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Error</title>
</head>
<body>
<div style="text-align: center;">
  <h1>There is an Error</h1>
  <h2><%=exception.getMessage() %><br/> </h2>
</div>
</body>
</html>
