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
    <title>Title</title>

    <style type="text/css">


        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            font-size: larger;
            margin-bottom: 100px;
        }

        #relogin,#reregister{
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
<%--<h4>注册失败，请检查是否有未填项</h4>--%>

<div id="head">
    <h2>注册失败</h2>
    <h4>存在空值或用户名已经存在，请重新注册</h4>
</div>


<form action="relogin" method="get">
    <input  id="relogin" type="submit" value="返回登录"/><br>
</form>
<form  action="toregister" method="get">
    <input id="reregister" type="submit" value="返回注册"/><br>
</form>
</body>
</html>
