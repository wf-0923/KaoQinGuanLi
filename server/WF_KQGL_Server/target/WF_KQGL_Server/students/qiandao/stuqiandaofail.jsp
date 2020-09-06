<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/25
  Time: 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    自适应手机宽度--%>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>学生签到</title>

    <style type="text/css">

        #textdiv{
            margin-left: 30px;
        }

        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            font-size: larger;
            margin-bottom: 100px;
        }

        /*按钮*/
        #back{
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

<div id="head">
    <h2>签到失败</h2>
</div>
<div id="textdiv">
<h3>签到失败，存在如下可能</h3>
<h3>1.签到超时，签到失败</h3>
<h3>2.签到码错误，请重新签到</h3>
<h3>3.不是学生，无需签到</h3>
</div>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

</body>
</html>
