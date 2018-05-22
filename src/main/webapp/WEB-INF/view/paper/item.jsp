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
    <title>Title</title>
</head>
<body>
<>
<jsp:include page="../public/header.jsp"/>
<div class="row ">
    <div class="col-md-10">
        <table class="table">
            <thead>
            <tr>
                <th><i class="fa fa-bullhorn"></i> 科目</th>
                <th class="hidden-phone"><i class="fa fa-question-circle"></i> 类型</th>
                <th><i class="fa fa-bookmark"></i> 题目</th>
                <th><i class=" fa fa-edit"></i> 操作</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><a href="basic_table.html#">${item.subject}</a></td>
                        <td class="hidden-phone">${item.type}</td>

                        <td><span class="label label-info label-mini">${item.title}</span></td>
                        <td>
                            <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                            <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                            <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
