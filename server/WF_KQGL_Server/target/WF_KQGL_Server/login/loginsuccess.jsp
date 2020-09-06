<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <%--    使网页自适应手机宽度--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>课表</title>
    <style type="text/css">
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




        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            margin-bottom: 60px;
        }
        #stuqingjia,#qiandao,#teafatongzhi,#teafaqiandao,#chaxuesehngqingjiajilu{
            width: 85%;
            height: 60px;
            border: 1px solid darkgray;
            border-radius: 10px;    /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 30px;
            font-size: larger;

        }
        #textstucenter,#textteacenter{
            text-align: center;
        }

    </style>
</head>
<body>
<%--    底部导航--%>
<div>
    <ul>
        <li><a href="chakebiao">课表</a></li>
        <li><a id="on" href="tologinsuccess">服务</a></li>
        <li><a href="studentchatongzhi">通知</a></li>
        <li><a href="mine">我的</a></li>
    </ul>
</div>


<%--体会:登录成功界面放在WEB-INF中，普通用户就不能通过输入网址的方式直接访问，更安全--%>
<div>
<%--    sessionScope,是在LoginController时通过@SessionAttributes("user")，保存了登录时用户的model--%>
    <div class="header" id="head">
        <div class="title"><h3>welcome,${sessionScope.user.username}!</h3></div>
    </div>
</div>

<h3 id="textstucenter">学生功能区</h3><br>
<form action="toqingjia" method="get">
    <input id="stuqingjia" type="submit" value="请假"/><br>
</form>

<form action="tostuqiandao" method="get">
    <input id="qiandao" type="submit" value="签到"/><br>
</form>

<h3 id="textteacenter">教师功能区</h3><br>

<form action="fatongzhi" method="get">
    <input id="teafatongzhi" type="submit" value="发布通知/作业"/><br>
</form>
<form action="toteacherfaqiandao" method="get">
    <input id="teafaqiandao" type="submit" value="发布签到任务"/><br>
</form>
<form action="teacherchaxuesehngqingjiajilu" method="get">
    <input id="chaxuesehngqingjiajilu" type="submit" value="查学生请假记录"/><br>
</form>
</body>
</html>
