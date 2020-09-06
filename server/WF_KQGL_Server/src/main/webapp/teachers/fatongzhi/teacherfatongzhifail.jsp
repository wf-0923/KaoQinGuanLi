<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/26
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>发布通知失败页</title>

    <style type="text/css">


        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 20px;
        }
        /*设置username，password文本输入框的css样式*/
        #biaoti,#zhengwen,#fugaibanji{
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
        /*按钮*/
        #back,#submit,#chatongzhi{
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
        #textdiv{
            margin-left: 30px;
        }
        #text{
            text-align: center;
        }
    </style>
</head>
<body>

<div id="head">
    <h3>发布通知失败</h3>
</div>

<div id="textdiv">
<h3>发布通知失败，可能的原因如下：</h3>
<h3>1.您不是教师，不能够发通知</h3>
<h3>2.存在空值，请重新发布</h3>
</div>


<h3 id="text">您可以重新发布通知</h3>
<form action="teacherfatongzhi" method="get">
    <input id="biaoti" placeholder="标题"  type="text" name="title"/><br>
    <input id="zhengwen" placeholder="正文"  type="text" name="zhengwen"/><br>
    <input id="fugaibanji" placeholder="覆盖班级" type="text" name="fugaibanji"><br>
    <input id="submit" type="submit" value="提交"/><br>
</form>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

<form action="teacherchazijifadetongzhi" method="get">
    <input id="chatongzhi" type="submit" value="查我发布的通知"/><br>
</form>
</body>
</html>
