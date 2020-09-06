<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/28
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--遍历时使用的jstl依赖--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查学生请假记录</title>

    <style type="text/css">


        #head {
            height: 50px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative; /*    不可层叠，其他控件不会和head碰到一起*/
            margin-bottom: 100px;
        }


        #back {
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


    </style>
</head>
<body>

<div id="head">
    <h3>查学生请假记录成功</h3>
</div>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
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
    <c:forEach items="${chaxueshengqingjia}" var="list">
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
