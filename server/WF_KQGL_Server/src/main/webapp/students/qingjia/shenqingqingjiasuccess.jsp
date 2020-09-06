<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/24
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%><%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>Title</title>

    <style type="text/css">


        #head {
            height: 120px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            font-size: larger;
            margin-bottom: 50%;
        }

        #back,#chaqingjia{
            width: 85%;
            height: 60px;
            border: 1px solid darkgray;
            border-radius: 10px;    /* 圆角5°*/
            padding-left: 13px;
            margin-top: 100px;
            margin-left: 30px;
            margin-right: 40px;
            font-size: larger;

        }

        #textdiv{
            text-align: center;
         }


    </style>

</head>
<body>
<div id="head">
    <h2>请假成功</h2><br>
</div>
<div id="textdiv">
    <h3>恭喜请假申请成功</h3>
</div>

<form action="chakanwodeqingjiajilu" method="get">
    <input id="chaqingjia" type="submit" value="查看请假记录"  >
</form>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>
</body>
</html>
