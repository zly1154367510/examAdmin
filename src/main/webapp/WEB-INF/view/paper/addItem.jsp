<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/25
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>添加试卷</title>
    <style type="text/css">
        #selecItem{
            display: none;
        }
    </style>
</head>
<body>
<jsp:include page="../public/header.jsp"/>

<section id="main-content">
    <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 添加试卷</h3>

        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
            <div class="col-lg-12">
                <div class="form-panel">
                    <h4 class="mb"><i class="fa fa-angle-right"></i> 添加试卷</h4>
                    <form id="itemForm" class="form-horizontal style-form" method="post" action="/question/addItemDo">
                        <input type="hidden" name="itemId" />
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">试卷名</label>
                            <div class="col-sm-10">
                                <input  type="text" name="name"  class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">科目</label>
                            <div class="col-sm-10">
                                <input  type="text" name="subject"  class="form-control"/>
                            </div>
                        </div>

                        <input type="submit" value="提交" class='btn-default'>
                    </form>
                </div>
            </div>
        </div>
    </section>
</section>
</body>
</html>