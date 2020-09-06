<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/24
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--遍历时使用的jstl依赖--%>
<%@ taglib prefix="y" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>发布签到任务成功+学生签到状态查询</title>

    <style type="text/css">


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

        #back, #chaxueshengqiandaozhuantai {
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
    <h2>发布成功/查学生签到状态</h2>
</div>

<form action="tologinsuccess" method="get">
    <input id="back" type="submit" value="返回服务"/><br>
</form>

<form action="qiandaozhuangtai" method="get">
    <input id="chaxueshengqiandaozhuantai" type="submit" value="查询学生签到状态"/><br>
</form>

<h3>以下为已签到同学</h3><br>

<%--这是那张表--%>
<table width="100%" border="1" id="table">
    <%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会错，因为没映射--%>
    <tr>
        <td aligh="right">学号
        </th>
        <td aligh="right">姓名
        </th>
        <td aligh="right">level
        </th>
        <td aligh="right">专业
        </th>
        <td aligh="right">班级
        </th>
    </tr>
    <y:forEach items="${yiqiandao}" var="yi">
        <tr>
            <td aligh="right"> ${yi.username}
            </th>
            <td aligh="right">${yi.name}
            </th>
            <td aligh="right"> ${yi.qiandaozhuangtai}
            </th>
            <td aligh="right">${yi.kechengmingcheng}
            </th>
            <td aligh="right"> ${yi.suozaibanji}
            </th>
        </tr>
    </y:forEach>
</table>


<h3>以下为未签到同学</h3>


<%--这是那张表--%>
<table width="100%" border="1" id="table">
    <%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会错，因为没映射--%>
    <tr>
        <td aligh="right">学号
        </th>
        <td aligh="right">姓名
        </th>
        <td aligh="right">level
        </th>
        <td aligh="right">专业
        </th>
        <td aligh="right">班级
        </th>
    </tr>
    <y:forEach items="${weiqiandao}" var="wei">
        <tr>
            <td aligh="right"> ${wei.username}
            </th>
            <td aligh="right"> ${wei.name}
            </th>
            <td aligh="right"> ${wei.qiandaozhuangtai}
            </th>
            <td aligh="right">${wei.kechengmingcheng}
            </th>
            <td aligh="right"> ${wei.suozaibanji}
            </th>
        </tr>
    </y:forEach>
</table>


<h3>以下为作废记录</h3>


<%--这是那张表--%>
<table width="100%" border="1" id="table">
    <%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会错，因为没映射--%>
    <tr>
        <td aligh="right">学号
        </th>
        <td aligh="right">姓名
        </th>
        <td aligh="right">level
        </th>
        <td aligh="right">专业
        </th>
        <td aligh="right">班级
        </th>
    </tr>
    <y:forEach items="${qiandaochaoshi}" var="chao">
        <tr>
            <td aligh="right"> ${chao.username}
            </th>
            <td aligh="right">${chao.name}
            </th>
            <td aligh="right">${chao.qiandaozhuangtai}
            </th>
            <td aligh="right"> ${chao.kechengmingcheng}
            </th>
            <td aligh="right"> ${chao.suozaibanji}
            </th>
        </tr>
    </y:forEach>
</table>
</body>
</html>
