<%--
  Created by IntelliJ IDEA.
  User: mythwind
  Date: 2019/01/15
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<html>
<head>
    <title>登陆</title>

    <base href="<%=basePath%>">
    <!--  在src/main/resource目录下创建文件夹 webjars -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />

    <style type="text/css">
        body {
            background-color: #EEEEE0;
        }
    </style>

    <script type="text/javascript" src="js/sysuser/login.js"></script>

</head>
<body>
    <div class="container text-center">
        <div class="row">
            <h1>登陆</h1>
        </div>
        <div class="row">
            <input type="text" class="form-control" id="username" name="username" placeholder="Email Address" required autofocus />
        </div>
        <div class="row">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required autofocus />
        </div>
        <div class="row">
            <button type="button" class="btn btn-primary" id="loginbtn" onclick="login();">登 陆</button>
        </div>
        <div class="row lastrow">
            还没账号?
            <a href="#">免费注册</a>|
            <a href="#">找回密码</a>
        </div>
    </div>

</body>
</html>
