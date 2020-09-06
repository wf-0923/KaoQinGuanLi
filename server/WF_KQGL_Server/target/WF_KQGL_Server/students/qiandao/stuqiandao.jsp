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


    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>学生签到</title>

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
        /*设置username，password文本输入框的css样式*/
        #qiandaoma,#kechengmingcheng{
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
        #submit,#tologinsuccess{
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
    <h2>签到</h2>
</div>
<%--action 是请求的路径--%>
<form action="xueshengqiandao" method="get">
    <input id="qiandaoma" placeholder="签到码" type="text" name="qiandaoma"><br>
    <input id="kechengmingcheng" placeholder="课程名称" type="text" name="kechengmingcheng"><br>
    <input id="submit" type="submit" value="提交签到"/><br>
</form>
<form  action="tologinsuccess" method="get">
    <input id="tologinsuccess" type="submit" value="返回服务"/><br>
</form>
</body>
</html>
