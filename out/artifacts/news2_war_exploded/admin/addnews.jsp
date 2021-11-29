<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/15
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="../css/bootstrap.css" />
    <script type="text/javascript" src="../js/jquery-min-3.2.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<style type="text/css">
    body {
        padding: 20px;
    }

    .headLeft {
        float: left;
    }

    .headRight {
        padding-top: 40px;
        padding-left: 340px;
    }

    .search {
        margin-bottom: 10px;
    }

    .search .toolbar {}
</style>
<!--必须使用较新版本的BootStrap才有如下效果-->

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand " href="#">后台管理系统</a>
                    </div>
                    <div id="navbar" class="navbar-right">
                        <a class="navbar-brand" href="#">当前用户：xx</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row" style="padding-top: 45px">
        <div class="col-md-3">
            <div class="list-group">
                <!--激活，作为标题-->
                <a href="#" class="list-group-item active ">
                    系统菜单
                </a>
                <a href="addnews.jsp" class="list-group-item">添加新闻</a>
                <a href="newsmanage.jsp" class="list-group-item">管理新闻</a>
                <a href="#" class="list-group-item">新闻统计</a>
                <a href="#" class="list-group-item">用户列表</a>
                <a href="#" class="list-group-item">退出</a>
            </div>
        </div>
        <div class="col-md-9">
            <div>
                <ol class="breadcrumb">
                    <li><span class="glyphicon glyphicon-home"></span>&nbsp;
                        <a href="#">主页</a>
                    </li>
                    <li class="active"></li>
                </ol>
            </div>
            <div align="center" style="padding-top: 50px;">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">新闻标题：</label>
                        <div class="col-sm-10">
                            <input type="text" name="title" class="form-control" id="title" placeholder="请输入新闻标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pubdate" class="col-sm-2 control-label">发布时间：</label>
                        <div class="col-sm-10">
                            <input type="date" name="pubdate" class="form-control" id="pubdate" placeholder="请输入发布时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="source" class="col-sm-2 control-label">新闻来源：</label>
                        <div class="col-sm-10">
                            <input type="text" name="source" class="form-control" id="source" placeholder="请输入新闻来源">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-sm-2 control-label">新闻内容：</label>
                        <div class="col-sm-10">
                            <textarea name="content" id="content" class="form-control" cols="30" rows="10"></textarea>
<%--                            <input type="text" name="content" class="form-control" id="content" placeholder="请输入新闻内容">--%>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">录入</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div align="center" style="padding-top: 200px">
                Copyright © 2017-2018 larger5
            </div>
        </div>
    </div>
</div>
</body>

</html>
