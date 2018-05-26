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
    <title>用户管理</title>
</head>
<body>
<jsp:include page="../public/header.jsp"/>
<section id="main-content">
    <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 用户管理</h3>
        <div class="row mt">
            <div class="col-lg-12">
                <div class="content-panel">
                    <h4><i class="fa fa-angle-right"></i> 用户</h4>
                    <a href="/question/addItem">
                        <div id="myButtons1" class="bs-example">
                            <button type="button" class="btn btn-primary">添加用户</button>
                        </div>
                    </a>
                    <section id="unseen">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                            <tr>
                                <th>姓名</th>
                                <th>用户名</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.name}</td>
                                    <td>${item.username}</td>

                                    <td><a href="/question/itemDetail?id=${item.id}">修改</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="http://localhost:8083/user/item?page=${previousPage}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="http://localhost:8083/user/item?page=${nextPage}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <form action="http://localhost:8083/user/item" method="get">
                                        <div class="input-group" width="20%">
                                            <input type="text" class="form-control" name="page" width="20%" placeholder="Search for...">
                                            <span class="input-group-btn">
                                            <input class="btn btn-default" type="submit">跳转</input>
                                        </span>
                                        </div>
                                    </form>

                                </li>
                            </ul>
                        </nav>
                    </section>
                </div><!-- /content-panel -->
            </div><!-- /col-lg-4 -->
        </div><!-- /row -->
    </section>
</section>
</body>
</html>