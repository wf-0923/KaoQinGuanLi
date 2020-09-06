<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/23
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>学生请假</title>

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
        #qingjialeixing,#qingjiashijian,#qingjiajieshu,#qingjialiyou{
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
        #submit,#chaqingjia,#back{
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

<div class="header" id="head">
    <h2>学生请假</h2>
</div>

<%--action 是请求的路径--%>
<form action="shenqingqingjia" method="get">
    <input id="qingjialeixing" placeholder="请假类型" type="text" name="qingjialeixing"><br>
    时间写法例子：20200424.2222，年月日、时间以"."连接<br>
    <input id="qingjiashijian" placeholder="开始时间" type="text" name="starttime"> <br>
    <input id="qingjiajieshu" placeholder="结束时间" type="text" name="overtime"> <br>
    <input id="qingjialiyou" placeholder="请假理由" type="text" name="qingjialiyou"><br>
    <input id="submit" type="submit" value="保存"/><br>
</form>



<form action="chakanwodeqingjiajilu" method="get">
    <input id="chaqingjia" type="submit" value="查看请假记录"/><br>
</form>
<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>
</body>
</html>
