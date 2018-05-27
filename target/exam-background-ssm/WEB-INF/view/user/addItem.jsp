<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/26
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>成绩管理</title>
</head>
<body>

<jsp:include page="../public/header.jsp"/>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<section id="main-content">
    <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 添加用户</h3>

        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
            <div class="col-lg-10">
                <div class="form-panel">
                    <h4 class="mb"><i class="fa fa-angle-right"></i> 添加用户</h4>
                    <form id="userForm" class="form-horizontal style-form" method="post" action="/user/addItemDo">
                        <input type="hidden" name="itemId" />
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label" for="username">用户名(必需)</label>
                            <div class="col-sm-10"></div>
                            <input  type="text" id="username" name="username"  class="form-control" required/>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label" for="name">真实姓名(必需)</label>
                            <div class="col-sm-10"></div>
                            <input  type="text" name="name"  id="name" class="form-control" required/>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label" for="password">密码(必需)</label>
                            <div class="col-sm-10"></div>
                            <input  type="username" name="password" id="password" class="form-control" required/>

                        </div>
                        <input type="submit" value="提交" class='btn-default'>
                    </form>
                </div>
            </div>
        </div>
    </section>
</section>

<script type="text/javascript">
    $.validator.setDefaults({
        submitHandler: function() {
            alert("提交事件!");
        }
    });
    $().ready(function() {
        $("#userForm").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2
                },
                name:{
                    requored:true
                },
                password:{
                    required:true
                }
            },
            message:{
                username:{
                    required:"这是必填字段",
                    minlength:"不少于两个字母"
                },
                name:{
                    required:"这是必填字段"
                },
                password:{
                    required:"这是必填字段"
                }
            }
        })
    });
</script>
</body>
</html>