<%--
  Created by IntelliJ IDEA.
  User: wangfan
  Date: 2020/4/26
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%--遍历时使用的jstl依赖,导入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--在网页的<head>中增加以上这句话，可以让网页的宽度自动适应手机屏幕的宽度。--%>
<%--其中：--%>
<%--width=device-width ：表示宽度是设备屏幕的宽度--%>
<%--initial-scale=1.0：表示初始的缩放比例--%>
<%--minimum-scale=0.5：表示最小的缩放比例--%>
<%--maximum-scale=2.0：表示最大的缩放比例--%>
<%--user-scalable=yes：表示用户是否可以调整缩放比例--%>
<html>
<head>
<%--    使网页自适应手机宽度--%>
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0,
     user-scalable=yes" />
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
        }
        #chaxunkebiao{
            width: 85%;
            height: 60px;
            margin-bottom: 60px;
            border: 1px solid darkgray;
            border-radius: 10px;    /* 圆角5°*/
            padding-left: 13px;
            margin-top: 15px;
            margin-left: 30px;
            margin-right: 30px;
            font-size: larger;

        }

    </style>
</head>
<body>
<div>
<%--    底部导航--%>
<ul>
    <li><a id="on"  href="chakebiao">课表</a></li>
    <li><a href="tologinsuccess">服务</a></li>
    <li><a href="studentchatongzhi">通知</a></li>
    <li><a href="mine">我的</a></li>
</ul>
</div>
<div class="header" id="head">
   <h1>我的课表</h1>
</div>




<table width="100%" border="1" id="table">
<%--   在ChaKeBiaoController 的chakebiao()头上没有加@RequestMapping，就会报错，因为没映射--%>
    <c:forEach items="${kebiao}" var="kebiao">
    <tr>
        <td aligh="left">
        </th>
        <td aligh="right">周一
        </th>
        <td aligh="right">周二
        </th>
        <td aligh="right">周三
        </th>
        <td aligh="right">周四
        </th>
        <td aligh="right">周五
        </th>
    </tr>
    <tr>
        <td aligh="left">1
        </th>
        <td aligh="right">${kebiao.monday1}
        </th>
        <td aligh="right">${kebiao.tuesday1}
        </th>
        <td aligh="right">${kebiao.wednesday1}
        </th>
        <td aligh="right">${kebiao.thursday1}
        </th>
        <td aligh="right">${kebiao.friday1}
        </th>

    </tr>
    <tr>
        <td aligh="left">2
        </th>
        <td aligh="right">${kebiao.monday2}
        </th>
        <td aligh="right">${kebiao.tuesday2}
        </th>
        <td aligh="right">${kebiao.wednesday2}
        </th>
        <td aligh="right">${kebiao.thursday2}
        </th>
        <td aligh="right">${kebiao.friday2}
        </th>


    </tr>
    <tr>
        <td aligh="left">3
        </th>
        <td aligh="right">${kebiao.monday3}
        </th>
        <td aligh="right">${kebiao.tuesday3}
        </th>
        <td aligh="right">${kebiao.wednesday3}
        </th>
        <td aligh="right">${kebiao.thursday3}
        </th>
        <td aligh="right">${kebiao.friday3}
        </th>


    </tr>
    <tr>
        <td aligh="left">4
        </th>
        <td aligh="right">${kebiao.monday4}
        </th>
        <td aligh="right">${kebiao.tuesday4}
        </th>
        <td aligh="right">${kebiao.wednesday4}
        </th>
        <td aligh="right">${kebiao.thursday4}
        </th>
        <td aligh="right">${kebiao.friday4}
        </th>


    </tr>
    <tr>
        <td aligh="left">5
        </th>
        <td aligh="right">${kebiao.monday5}
        </th>
        <td aligh="right">${kebiao.tuesday5}
        </th>
        <td aligh="right">${kebiao.wednesday5}
        </th>
        <td aligh="right">${kebiao.thursday5}
        </th>
        <td aligh="right">${kebiao.friday5}
        </th>


    </tr>
    </c:forEach>

</table>

<%--<form  action="chakebiao" method="get">--%>
<%--    <input id="chaxunkebiao" type="submit" value="查询我的课表"/><br>--%>
<%--</form>--%>



</body>
</html>
