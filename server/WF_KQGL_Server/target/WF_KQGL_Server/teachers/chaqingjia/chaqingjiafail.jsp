<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/24
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查学生请假记录失败</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <style type="text/css">


        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative; /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 100px;
        }


        #back {
            width: 85%;
            height: 60px;
            border: 1px solid darkgray;
            border-radius: 10px; /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 40px;
            font-size: larger;

        }

        #textdiv {

            text-align: center;
        }
    </style>


</head>
<body>

<div id="head">
    <h3>查学生请假记录</h3>
</div>

<div id="textdiv">
    <h3>查学生请假记录失败</h3>
    <h3>1. 您不是教师，不能查其他学生的请假状态</h3><br><br>
</div>
<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

</body>
</html>