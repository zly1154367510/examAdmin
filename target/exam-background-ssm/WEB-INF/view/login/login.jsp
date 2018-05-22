<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="http://localhost:8083/static/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="http://localhost:8083/static/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="http://localhost:8083/static/css/style.css" rel="stylesheet">
    <link href="http://localhost:8083/static/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form:form commandName="admin" class="form-login" action="/loginDo">
            <h2 class="form-login-heading">lili考试系统后台登录</h2>
            <div class="login-wrap">
                <form:errors path="username"/>
                <form:input path="username" type="text" class="form-control" placeholder="用户名" />
                <br>
                <form:errors path="password"/>
                <form:input path="password" type="password" class="form-control" placeholder="密码"/>
                <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?那我也没办法</a>

		                </span>
                </label>
                <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i> 登录</button>
                <hr>

                <div class="login-social-link centered">
                    <p>or you can sign in via your social network</p>
                    <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
                    <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
                </div>


            </div>

            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Forgot Password ?</h4>
                        </div>
                        <div class="modal-body">
                            <p>Enter your e-mail address below to reset your password.</p>
                            <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                        </div>
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                            <button class="btn btn-theme" type="button">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal -->

        </form:form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="http://localhost:8083/static/js/jquery.js"></script>
<script src="http://localhost:8083/static/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="http://localhost:8083/static/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("http://localhost:8083/static/img/login-bg.jpg", {speed: 500});
</script>


</body>
</html>