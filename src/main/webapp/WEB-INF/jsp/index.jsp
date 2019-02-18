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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>YouCan</title>

    <meta name="keywords" content="侧边导航菜单(可分组折叠)">
    <meta name="description" content="侧边导航菜单(可分组折叠)" />
    <meta name="HandheldFriendly" content="True" />
    <base href="<%=basePath%>">

    <!--  在src/main/resource目录下创建文件夹 webjars -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />

    <script type="text/javascript" src="js/sysuser/login.js"></script>

</head>
<body>
    <jsp:include page="base/base_header.jsp" flush="true" ></jsp:include>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                    <li class="active">
                        <a href="#">
                            <i class="glyphicon glyphicon-th-large"></i>
                            首页
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>
                            系统管理
                            <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="mytask"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="./plans.html">
                            <i class="glyphicon glyphicon-credit-card"></i>
                            物料管理
                        </a>
                    </li>
                    <li>
                        <a href="./grid.html">
                            <i class="glyphicon glyphicon-globe"></i>
                            分发配置
                            <span class="label label-warning pull-right">5</span>
                        </a>
                    </li>
                    <li>
                        <a href="./charts.html">
                            <i class="glyphicon glyphicon-calendar"></i>
                            图表统计
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-fire"></i>
                            关于系统
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-md-10">
                主窗口
                <a href="login/toLogin">Login</a> | <a href="vedio">Vedio</a>
                <div>
                    <a href="thymeleaf_test">Themeleaf</a>
                </div>
                Welcome
                <br>
                <br/>
                <img src="images/heihei.png"/>
            </div>
        </div>
    </div>

    <div class="bg-secondary">

    </div>

    <!-- 注册窗口 -->
    <div id="register" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">注册</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="">
                        <div class="form-group">
                            <label for="">用户名</label>
                            <input class="form-control" type="text" placeholder="6-15位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">密码</label>
                            <input class="form-control" type="password" placeholder="至少6位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">再次输入密码</label>
                            <input class="form-control" type="password" placeholder="至少6位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">邮箱</label>
                            <input class="form-control" type="email" placeholder="例如:123@123.com">
                        </div>
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 登录窗口 -->
    <!-- data-backdrop="static" 禁止外部点击对话框消失 -->
    <div id="login" class="modal fade" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <!--登陆框头部-->

                <div class="modal-header">
                    <h4 class="modal-title">
                        欢迎登陆！
                    </h4>
                    <a class="close" data-dismiss="modal">×</a>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="login/login" method="post">
                        <div class="form-group">
                            <label for="login">用户名</label>
                            <input class="form-control" type="text" id="username" name="username" placeholder="Email Address" required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="login">密码</label>
                            <input class="form-control" type="password" id="password" name="password" placeholder="Password" required autofocus>
                        </div>
                        <div>
                            <button class="btn btn-primary btn-block" type="button" onclick="return login();">提交</button>
                        </div>
                        <div style="display: none">
                            <iframe src="pages/login_dialog.html" width="100%" height="100%" frameborder="0">
                                您的浏览器不支持iframe，请升级
                            </iframe>
                        </div>


                        <%--
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">登录</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>--%>
                        <div class="" style="margin-top: 10px">
                            <div align="left" style="float:left">
                                还没有账号？<a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">点我注册</a>
                            </div>
                            <div align="right">
                                <a href="">忘记密码</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
