<%--
  Created by IntelliJ IDEA.
  User: mythwind
  Date: 2019/01/24
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<base href="<%=basePath%>">

<nav class="navbar navbar-expand-sm bg-white navbar-light">
    <!-- Brand -->
    <%--<a class="navbar-brand" href="#">Logo</a>--%>
    <a class="navbar-brand" href="index">
        <img src="images/logo.png" alt="Logo" style="width:100px;height: 40px">
    </a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">Link 1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link 2</a>
        </li>

        <!-- Dropdown -->
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Dropdown link
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
        </li>
    </ul>
    <!-- 这个 div 加上 justify-content-end 样式即可 -->
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <a data-toggle="modal" data-target="#login" href="login/toLogin">Login</a>
        &nbsp;/&nbsp;
        <a data-toggle="modal" data-target="#register"href="login/toRegister">Register</a>
    </div>
</nav>

