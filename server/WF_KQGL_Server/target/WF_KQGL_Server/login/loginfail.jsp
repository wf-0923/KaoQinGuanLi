<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/22
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>登录失败</title>
    <style type="text/css">
        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 80px;
        }
        #headtext1,#headtext2{
            font-faily: Microsoft Yahei; /*字体为微软雅黑*/
            margin-top: 20px;

        }
        #relogin,#register{
            width: 85%;
            height: 80px;
            border: 1px solid darkgray;
            border-radius: 10px;    /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 40px;
            font-size: larger;

        }
    </style>
</head>
<body>

<div class="header" id="head">
    <h2 id="headtext1">登录失败</h2><br>
    <h3 id="headtext2">账号登陆失败，用户名或密码错误，请重新登录</h3><br>
</div>


<form action="relogin" method="get">
    <input id="relogin" type="submit" value="重新登录"/><br>
</form>
<form action="toregister" method="post">
    <input id="register" type="submit" value="去注册"/>
</form>
</body>
</html>
