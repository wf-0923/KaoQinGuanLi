<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="http://localhost:8080/WF_KQGL_Server_war_exploded/login.jsp">去登录</a>

<h3>测试查询</h3>
<a href="usercontroller/findall">查询所有用户信息</a>


<h3>测试保存</h3>
<%--action 是请求的路径--%>
<form action="usercontroller/saveuser" method="post">
    用户名：<input type="text" name="username"/><br>
    密码：<input type="text" name="password"/><br>
    <input type="submit" value="保存"/><br>
</form>

<h3>测试根据id删除用户</h3>
<%--action 是请求的路径--%>
<form action="usercontroller/deleteuserbyid" method="post">
    id：<input type="text" name="id"/><br>
    <input type="submit" value="删除"/><br>
</form>

<h3>测试根据id修改用户</h3>
<%--action 是请求的路径--%>
<form action="usercontroller/updateuserbyid" method="post">
    id：   <input type="text" name="id"/><br>
    用户名：<input type="text" name="username"/><br>
    密码：  <input type="text" name="password"/><br>
    <input type="submit" value="修改"/><br>
</form>

</body>
</html>
