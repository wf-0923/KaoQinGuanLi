<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/22
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>Title</title>

    <style type="text/css">



        #head {
            height:50px;
            width: 100%;
            margin-top: 60px;
            text-align: center;
        }
        /*设置username，password文本输入框的css样式*/
        #username,#password{
            width: 85%;
            height: 80px;
            border: 1px solid darkgray;
            border-radius: 10px;    /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 40px;
            margin-bottom: 15px;
            font-size: larger;

        }
        #login,#register{
            width: 85%;
            height: 60px;
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

<h2 id="head">欢迎登录考勤管理系统</h2>




<%--action 是请求的路径--%>
<form action="loginin" method="post">
<%--id 引用css样式  placeholder 提示性文字，输入时消失--%>
    <input id="username" type="text" name="username" placeholder="请输入用户名"/><br>
    <input id="password" type="text" name="password" placeholder="请输入密码"/><br>
    <input id="login" type="submit" value="登录"/>
    <%--空格占位--%>
    &nbsp;&nbsp;&nbsp;
</form>
    <form action="toregister" method="post">
        <input id="register" type="submit" value="注册"/>
    </form>
</div>

</body>
</html>
