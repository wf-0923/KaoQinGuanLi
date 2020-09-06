<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/24
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>教师发布签到任务</title>

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
        #zuoyongbanji,#qiandaoma,#kechengmingcheng,#kaishishijian,#jieshushijian{
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
        #submit,#back,#chaxueshengqiandaozhuantai{
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
    <h2>发布签到任务</h2>
</div>

<%--action 是请求的路径--%>
<form action="teacherfaqiandao" method="post">
    <input id="zuoyongbanji" placeholder="作用班级" type="text" name="suozaibanji"/><br>
    <input id="qiandaoma" placeholder="签到码"  type="text" name="qiandaoma"/><br>
    <input id="kechengmingcheng" placeholder="课程名称" type="text" name="kechengmingcheng"/><br>
    时间写法例子：20200424.2222，年月日、时间以"."连接<br>
    <input id="kaishishijian" placeholder="开始时间" type="text" name="starttime"><br>
    <input id="jieshushijian" placeholder="结束时间" type="text" name="overtime"><br>
    <input id="submit" type="submit" value="提交"/><br>
</form>
<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

<form action="tofaqiandaosuccess" method="get">
    <input id="chaxueshengqiandaozhuantai" type="submit" value="查询学生的签到状态"/><br>
</form>
</body>
</html>