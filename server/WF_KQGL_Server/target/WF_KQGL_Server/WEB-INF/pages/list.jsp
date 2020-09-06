<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--遍历时使用的jstl依赖--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="http://localhost:8080/WF_KQGL_Server_war_exploded/signin.jsp">去登录</a>
<h3>查询了所有的用户信息</h3>
<c:forEach items="${list}" var="user">
    ${user.id}
    ${user.username}
    ${user.password}<br>
</c:forEach>

</body>
</html>
