<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/24
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%--必须加isELIgnored="false"，否则后面遍历不了--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--遍历时使用的jstl依赖--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请假记录</title>
    <style type="text/css">

        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;  /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 20px;
        }

        ul { /*设置导航栏的框框*/
            margin-bottom: 0px; /*框整体的位置，30px是指离网页的项部和下部的距离，auto控制的是左右距离*/
            width: 100%; /*在在的宽度*/
            height: 50px; /*框框的长度*/
            padding: 0px; /*将框框的padding设置为零。 不然会导致框框里的内容与框边缘有问隔*/
            border: 1px solid #000; /*添加边框*/
            position: fixed;
            bottom: 0; /**距离底部为0*/
            left: 0;
            z-index: 1;
        }

        li {
            width: 25%;
            list-style-type: none; /* 去掉1i前的点*/
            float: left; /*将1i设置成做浮动，变为联动*/
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

        a:hover {
            background-color: #2f6f4f;
        }

        a#on {
            background-color: #FF0000;
        }

        #back, #chaqingjia {
            width: 85%;
            height: 60px;
            border: 1px solid darkgray;
            border-radius: 10px; /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 30px;
            font-size: larger;

        }

        #table {
            margin-bottom: 60px;
        }

    </style>


</head>
<body>

<div id="head">
    <h2>请假记录</h2>
</div>


<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

<form action="chakanwodeqingjiajilu" method="get">
    <input id="chaqingjia" type="submit" value="查看请假记录">
</form>











<%--这是那张表--%>
<table width="100%" border="1" id="table">
    <%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会错，因为没映射--%>

    <tr>
        <td aligh="right">学工号
        </th>
        <td aligh="right">姓名
        </th>
        <td aligh="right">所在班级
        </th>
        <td aligh="right">所在学院
        </th>
        <td aligh="right">请假类型
        </th>
        <td aligh="right">开始时间
        </th>
        <td aligh="right">结束时间
        </th>
        <td aligh="right">请假理由
        </th>
    </tr>
    <c:forEach items="${findallqingjiajilu}" var="list">
        <tr>

            <td aligh="right">${list.username}
            </th>
            <td aligh="right">${list.name}
            </th>
            <td aligh="right"> ${list.suozaibanji}
            </th>
            <td aligh="right">${list.suozaixueyuan}
            </th>
            <td aligh="right">${list.qingjialeixing}
            </th>
            <td aligh="right">${list.starttime}
            </th>
            <td aligh="right">${list.overtime}
            </th>
            <td aligh="right">${list.qingjialiyou}
            </th>

        </tr>

    </c:forEach>

</table>


</body>
</html>
