<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/26
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--遍历时使用的jstl依赖--%>
<%@ taglib prefix="y" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>发布通知成功页</title>

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
        /*鼠标点击时的颜色*/
        a:hover{
            background-color: #2f6f4f;
        }
        /*被选中变色*/
        a#on {
            background-color: #FF0000;
        }


        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative; /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 20px;
        }

        /*设置username，password文本输入框的css样式*/
        #zuoyongbanji, #qiandaoma, #kechengmingcheng, #kaishishijian, #jieshushijian {
            width: 85%;
            height: 80px;
            border: 1px solid darkgray;
            border-radius: 10px; /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 40px;
            margin-bottom: 15px;
            font-size: larger;

        }

        #back, #chawofabudetongzhi {
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
        #bottom{
            margin-bottom: 60px;
        }


    </style>


</head>
<body>

<div id="head">
    <h2>发布通知成功/查通知</h2>
</div>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

<form action="teacherchazijifadetongzhi" method="get">
    <input id="chawofabudetongzhi" type="submit" value="查我发布的通知"/><br>
</form>

<%--底部导航--%>
<div>
    <ul>
        <li><a href="chakebiao">课表</a></li>
        <li><a href="tologinsuccess">服务</a></li>
        <li><a id="on"  href="studentchatongzhi">通知</a></li>
        <li><a href="mine">我的</a></li>
    </ul>
</div>


<%--这是那张表--%>
<table  width="100%" border="1" id="table">
    <%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会错，因为没映射--%>

    <tr>
        <td aligh="right">发布时间
        </th>
        <td aligh="right">发布者
        </th>
        <td aligh="right">覆盖班级
        </th>
        <td aligh="right">标题
        </th>
        <td aligh="right">正文
        </th>
    </tr>
         <y:forEach items="${modeljiaoshichazijifadetongzhi}" var="teacherchatongzhi">
        <tr id="bottom">
            <td aligh="right">${teacherchatongzhi.starttime}
            </th>
            <td aligh="right">${teacherchatongzhi.fabuzhe}
            </th>
            <td aligh="right">${teacherchatongzhi.fugaibanji}
            </th>
            <td aligh="right">${teacherchatongzhi.title}
            </th>
            <td  aligh="right">${teacherchatongzhi.zhengwen}
            </th>

        </tr>

        </y:forEach>

</table >

</body>
</html>