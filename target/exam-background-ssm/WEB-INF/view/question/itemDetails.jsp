<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/23
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>选择题修改</title>
</head>
<body>
    <jsp:include page="../public/header.jsp"/>

    <section id="main-content">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right"></i> 选择题修改</h3>

            <!-- BASIC FORM ELELEMNTS -->
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="form-panel">
                        <h4 class="mb"><i class="fa fa-angle-right"></i> 选择题修改</h4>
                            <form id="itemForm" class="form-horizontal style-form" method="post" action="/question/itemDetailDo">
                                <input type="hidden" name="itemId" value="${item.id}"/>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">科目</label>
                                    <div class="col-sm-10">
                                       <input  type="text" name="subject" value="${item.subject}" class="form-control round-form"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">类型</label>ps:修改完成后请刷新页面在设置其他项
                                    <c:choose>
                                        <c:when test="${item.type=='单'}">
                                            <input name="type" value="单" type="radio" checked="true"/> 单选
                                            <input name="type" value="多" type="radio" /> 多选
                                        </c:when>
                                        <c:otherwise>
                                            <input name="type" value="单" type="radio" /> 单选
                                            <input name="type" value="多" type="radio" checked="true"/> 多选
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">题目</label>
                                    <div class="col-sm-10">
                                        <textarea name="title" class="form-control" rows="5">${item.title}</textarea>
                                    </div>
                                </div>
                                <div class="row mt">
                                    <div class="col-lg-12">
                                        <div class="form-panel">
                                            <h4 class="mb"><i class="fa fa-angle-right"></i> 选项设置</h4>
                                            <c:if test="${item.type=='多'}">
                                                <div class="checkbox">
                                                    <c:forEach items="${item.itemList}" var="itemm">
                                                        <label>
                                                            <p>${itemm.id}</p>
                                                           <c:choose>
                                                               <c:when test="${itemm.isanswer=='true'}">
                                                                   <input type="hidden" name="trueAnswer" value="${itemm.id}" >
                                                                   <input type="checkbox" name="isanswer" value="${itemm.id}"checked="checked" >
                                                               </c:when>
                                                               <c:otherwise>
                                                                   <input type="checkbox" name="isanswer" value="${itemm.id}">
                                                               </c:otherwise>
                                                           </c:choose>
                                                            是否是答案
                                                          <input type="hidden" value="${itemm.id}" name="itemmId">
                                                            <input type="text" name="content" value="${itemm.content}" class="form-control round-form"/>
                                                        </label>
                                                    </c:forEach>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.type=='单'}">
                                                <div class="radio">

                                                    <c:forEach items="${item.itemList}" var="itemm">
                                                        <label>
                                                            <c:choose>
                                                                <c:when test="${itemm.isanswer=='true'}">
                                                                    <input type="hidden" name="trueAnswer" value="${itemm.id}" >
                                                                    <input type="radio" name="isanswer" value="${itemm.id}" checked="true">
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="radio" name="isanswer" value="${itemm.id}">
                                                                </c:otherwise>
                                                            </c:choose>
                                                            是否是答案
                                                            <input type="hidden" value="${itemm.id}" name="itemmId">
                                                            <input type="text" name="content" value="${itemm.content}" class="form-control round-form"/>
                                                        </label>
                                                    </c:forEach>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <input type="submit" value="提交">
                            <form>
                    </div>
                </div>
            </div>
        </section>
    </section>
    </section>
</body>
</html>
