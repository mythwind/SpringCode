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

<html>
<head>
    <title>Title</title>

    <!--  在src/main/resource目录下创建文件夹 webjars -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />

</head>
<body>
    <jsp:include page="base/base_header.jsp" flush="true" ></jsp:include>
    <div class="bg-secondary">
        <a href="login/toLogin">Login</a> | <a href="vedio">Vedio</a>
        Welcome
        <br>
        <br/>
        <img src="images/heihei.png"/>
    </div>
</body>
</html>
