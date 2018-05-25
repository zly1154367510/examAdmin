<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/22
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>题目管理</title>
</head>
<body>
<jsp:include page="../public/header.jsp"/>
<section id="main-content">
    <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 选择题管理</h3>
        <div class="row mt">
            <div class="col-lg-12">
                <div class="content-panel">
                    <h4><i class="fa fa-angle-right"></i> 选择题</h4>
                    <a href="/question/addItem">
                        <div id="myButtons1" class="bs-example">
                          <button type="button" class="btn btn-primary">添加题目</button>
                        </div>
                    </a>
                    <section id="unseen">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                                <tr>
                                    <th>科目</th>
                                    <th>类型</th>
                                    <th>题目</th>
                                    <th>选项</th>
                                    <th>操作</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="item">
                                    <tr>
                                        <td>${item.subject}</td>
                                        <td>${item.type}</td>
                                        <td>${item.title}</td>
                                        <td>
                                            <div class="dropdown">
                                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    点击查看选项
                                                    <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                                    <c:forEach items="${item.itemList}" var="itemm">
                                                        <li><a href="">${itemm.content}</a><c:if test="${itemm.isanswer}==1">-我是答案</c:if></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </td>
                                        <td><a href="/question/itemDetail?id=${item.id}">修改</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="http://localhost:8083/question/item?page=${previousPage}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="http://localhost:8083/question/item?page=${nextPage}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <form action="http://localhost:8083/question/item" method="get">
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
