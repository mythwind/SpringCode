<!DOCTYPE html>

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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <base href="<%=basePath%>">
    <title>Collapsible sidebar using Bootstrap 4</title>

    <!--  在src/main/resource目录下创建文件夹 webjars -->
    <script src="webjars/jquery/3.3.1-2/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.min.css" />

    <link href="webjars/open-iconic/1.1.1/font/css/open-iconic-bootstrap.css" rel="stylesheet">
    <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- Our Custom CSS -->
    <%--<link rel="stylesheet" href="css/style4.css">--%>



    <link rel="stylesheet" href="css/slidebar.css">


</head>

<body>

<div class="container-fluid">
    <div class="row d-flex d-md-block flex-nowrap wrapper">
        <!--左侧菜单栏-->
        <div class="col-md-2 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
            <div class="list-group border-0 card text-center text-md-left">
                <a href="#menu1" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-dashboard"></i> <span class="d-none d-md-inline">Item 1</span> </a>
                <div class="collapse" id="menu1" data-parent="#sidebar">
                    <a href="#menu1sub1" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem 1 </a>
                    <div class="collapse" id="menu1sub1" data-parent="#menu1">
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem a</a>
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem b</a>
                        <a href="#menu1sub1sub1" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem c </a>
                        <div class="collapse" id="menu1sub1sub1">
                            <a href="#" class="list-group-item" data-parent="#menu1sub1sub1">Subitem c.1</a>
                            <a href="#" class="list-group-item" data-parent="#menu1sub1sub1">Subitem c.2</a>
                        </div>
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem d</a>
                        <a href="#menu1sub1sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem e </a>
                        <div class="collapse" id="menu1sub1sub2">
                            <a href="#" class="list-group-item">Subitem e.1</a>
                            <a href="#" class="list-group-item">Subitem e.2</a>
                        </div>
                    </div>
                    <a href="#menu1sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem 2</a>
                    <div class="collapse" id="menu1sub2" data-parent="#menu1">
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem 1 a</a>
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem 2 b</a>
                        <a href="#menu1sub2sub1" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem 3 c </a>
                        <div class="collapse" id="menu1sub2sub1">
                            <a href="#" class="list-group-item" data-parent="#menu1sub2sub1">Subitem 3 c.1</a>
                            <a href="#" class="list-group-item" data-parent="#menu1sub2sub1">Subitem 3 c.2</a>
                        </div>
                        <a href="#" class="list-group-item" data-parent="#menu1sub1">Subitem 4 d</a>
                        <a href="#menu1sub1sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">Subitem 5 e </a>
                        <div class="collapse" id="menu1sub2sub2">
                            <a href="#" class="list-group-item" data-parent="#menu1sub2sub2">Subitem 5 e.1</a>
                            <a href="#" class="list-group-item" data-parent="#menu1sub2sub2">Subitem 5 e.2</a>
                        </div>
                    </div>
                    <a href="#" class="list-group-item">Subitem 3</a>
                </div>
                <a href="#" class="list-group-item d-inline-block collapsed"><i class="fa fa-film"></i> <span class="d-none d-md-inline">Item 2</span></a>
                <a href="#menu3" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Item 3 </span></a>
                <div class="collapse" id="menu3" data-parent="#sidebar">
                    <a href="#" class="list-group-item" data-parent="#menu3">3.1</a>
                    <a href="#menu3sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">3.2 </a>
                    <div class="collapse" id="menu3sub2">
                        <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 a</a>
                        <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 b</a>
                        <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 c</a>
                    </div>
                    <a href="#" class="list-group-item" data-parent="#menu3">3.3</a>
                </div>
                <a href="#" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Item 4</span></a>
                <a href="#" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-list"></i> <span class="d-none d-md-inline">Item 5</span></a>
                <a href="#" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-clock-o"></i> <span class="d-none d-md-inline">Link</span></a>
                <a href="#" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-th"></i> <span class="d-none d-md-inline">Link</span></a>

            </div>
        </div>
        <!--右侧主页面-->
        <main class="col-md-8 float-left col px-5 pl-md-2 pt-2 main">
            <a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>

            <div class="page-header">
                <h2>Bootstrap 4 Sidebar Menu</h2>
            </div>
            <p class="lead">A responsive, multi-level vertical accordion.</p>
            <hr>
            <div class="row">
                <div class="col-lg-6">
                    <button role="button" class="btn btn-danger" data-toggle="collapse" data-target="#demo" aria-expanded="true">
                        horizontal collapsible
                    </button>
                    <div id="demo" class="width collapse show" aria-expanded="true">
                        <div class="list-group" style="width:400px">
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <button role="button" class="btn btn-danger" data-toggle="collapse" data-target="#demo2" aria-expanded="true">
                        vertical collapsible
                    </button>
                    <div id="demo2" class="height collapse show" aria-expanded="true">
                        <div>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

</body>

</html>