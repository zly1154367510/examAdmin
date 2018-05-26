<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/22
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - FREE Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="http://localhost:8083/static/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="http://localhost:8083/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8083/static/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8083/static/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8083/static/lineicons/style.css">

    <!-- Custom styles for this template -->
    <link href="http://localhost:8083/static/css/style.css" rel="stylesheet">
    <link href="http://localhost:8083/static/css/style-responsive.css" rel="stylesheet">

    <script src="http://localhost:8083/static/js/chart-master/Chart.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<section id="container" >
    <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
        <!--logo end-->

        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="login.html">Logout</a></li>
            </ul>
        </div>
    </header>
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="profile.html"><img class="img-circle" width="60"></a></p>
                <h5 class="centered">Marcel Newman</h5>

                <li class="mt">
                    <a  href="/user/item">
                        <i class="fa fa-dashboard"></i>
                        <span>用户管理</span>
                    </a>
                </li>

                <li class="mt">
                    <a class="active" href="/question/item">
                        <i class="fa fa-dashboard"></i>
                        <span>试题管理</span>
                    </a>
                </li>

                <li class="mt">
                    <a class="active" href="/paper/item">
                        <i class="fa fa-dashboard"></i>
                        <span>试卷管理</span>
                    </a>
                </li>

                <li class="mt">
                    <a class="active" href="/score/item">
                        <i class="fa fa-dashboard"></i>
                        <span>成绩管理</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-desktop"></i>
                        <span>考试系统</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="general.html">技术支持：zly</a></li>
                        <li><a  href="buttons.html">2018年5月26日16:49:41</a></li>
                        <li><a  href="panels.html">联系：13112415228</a></li>
                    </ul>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <script src="http://localhost:8083/static/js/jquery.js"></script>
    <script src="http://localhost:8083/static/js/jquery-1.8.3.min.js"></script>
    <script src="http://localhost:8083/static/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="http://localhost:8083/static/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="http://localhost:8083/static/js/jquery.scrollTo.min.js"></script>
    <script src="http://localhost:8083/static/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="http://localhost:8083/static/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="http://localhost:8083/static/js/common-scripts.js"></script>

    <script type="text/javascript" src="http://localhost:8083/static/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="http://localhost:8083/static/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="http://localhost:8083/static/js/sparkline-chart.js"></script>
    <script src="http://localhost:8083/static/js/zabuto_calendar.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var unique_id = $.gritter.add({
                // (string | mandatory) the heading of the notification
                title: 'Welcome to Dashgum!',
                // (string | mandatory) the text inside the notification
                text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
                // (string | optional) the image to display on the left

                // (bool | optional) if you want it to fade out on its own or just sit there
                sticky: true,
                // (int | optional) the time you want it to be alive for before fading out
                time: '',
                // (string | optional) the class name you want to apply to that specific message
                class_name: 'my-sticky-class'
            });

            return false;
        });
    </script>

    <script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });

            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });


        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>

<!-- js placed at the end of the document so the pages load faster -->


</body>
</html>