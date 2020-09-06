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
    <title>用户注册</title>

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
        #username,#password,#level,#name,#suozaixueyuan,#suozaibanji,#suoshuzhuanye{
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
        #register,#relogin{
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
   <h2>注册</h2>
</div>

<%--action 是请求的路径--%>
<form action="register" method="post">
    <input id="username" placeholder="用户名" type="text" name="username"/><br>
    <input id="password"  placeholder="密码" type="text" name="password"/><br>
    <h3> 身份：学生填0 教师填1 班主任填2 辅导员填3</h3><br>
    <input id="level" placeholder="身份"  type="text" name="level"/><br>
    <input id="name"  placeholder="姓名" type="text" name="name"/><br>
    <input id="suozaixueyuan" placeholder="学院"  type="text" name="suozaixueyuan"/><br>
    <input id="suozaibanji" placeholder="班级"  type="text" name="suozaibanji"/><br>
    <input id="suoshuzhuanye" placeholder="专业"  type="text" name="suoshuzhuanye"/><br>

    <input id="register" type="submit" value="保存"/><br>
</form>
<form action="relogin" method="get">
<input id="relogin" type="submit" value="返回登录"/><br>
</form>

</body>
</html>
