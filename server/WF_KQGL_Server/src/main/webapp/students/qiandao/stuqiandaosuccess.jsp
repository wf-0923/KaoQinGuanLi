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

        #text{
            text-align: center;
        }

        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            font-size: larger;
            margin-bottom: 50%;
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

        ul{                        /*设置导航栏的框框*/
            margin-bottom: 0px;   /*框整体的位置，30px是指离网页的项部和下部的距离，auto控制的是左右距离*/
            width: 100%;        /*在在的宽度*/
            height: 50px;       /*框框的长度*/
            padding: 0px;         /*将框框的padding设置为零。 不然会导致框框里的内容与框边缘有问隔*/
            border:1px solid #000;/*添加边框*/
            position:fixed;
            bottom:0;/**距离底部为0*/
            left:0;
            z-index:1;
        }
        li{
            width: 25%;
            list-style-type: none;/* 去掉1i前的点*/
            float: left;/*将1i设置成做浮动，变为联动*/
        }
        a {
            display: block; /*将a变成块状*/
            width: 100%; /*设置块的宽度*/
            height: 50px; /*设置块的长度*/
            font-faily: Microsoft Yahei; /*字体为微软雅黑*/
            line-height: 50px; /*设置字体在块中的高度*/
            background-color: #2f4f4f; /*背景颜色*/
            margin: 0px 0px; /*块里的高宽通过margin设置*/
            color: #fff;
            text-align: center; /*字体居中*/
            text-decoration: none; /*去掉下划线*/
            font-size: 15px;
        }
        a:hover{
            background-color: #2f6f4f;
        }
        a#on {
            background-color: #FF0000;
        }



    </style>

</head>
<body>

<div id="head">
    <h2>签到成功</h2>
</div>
<div id="text">
    <h2>恭喜签到成功</h2>
</div>


<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

</body>
</html>
