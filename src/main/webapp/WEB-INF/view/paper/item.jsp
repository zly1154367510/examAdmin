<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>试卷管理</title>
    <style>
        .mask{
            position:absolute;
            top:0%; /**遮罩全屏top,left都为0,width,height为100%**/
            left:0%;
            width:100%;
            height:100%;
            filter:alpha(opacity=50);
            opacity: 0.5;
            -moz-opacity:0.5;
            -khtml-opacity: 0.5;
            background-color:black;
            z-index: 1001;
            display:none;
            z-index: 888;
        }
        .itemDiv{

            background-color: white;
            z-index: 999;
            display: none;
            width: 80%;
            height: 80%;
            overflow:auto
        }
    </style>
</head>
<body>
<jsp:include page="../public/header.jsp"/>

<section id="main-content">
    <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 试卷管理</h3>
        <div class="row mt">
            <div class="col-lg-12">
                <div class="content-panel">
                    <h4><i class="fa fa-angle-right"></i> 试卷</h4>
                    <a href="/paper/addItem">
                        <div id="myButtons1" class="bs-example">
                            <button type="button" class="btn btn-primary">添加试卷</button>
                        </div>
                    </a>
                    <section id="unseen">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                            <tr>
                                <th>试卷名</th>
                                <th>创建时间</th>
                                <th>科目</th>
                                <th>试卷详情</th>
                                <th>操作</th>

                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="item">
                                    <tr >
                                        <td>${item.name}</td>
                                        <td>${item.created}</td>
                                        <td>${item.subject}</td>
                                        <td class="questionItem" id="${item.id}"><button >详情</button></td>
                                        <td><a href="/paper/itemDetail?id=${item.id}">修改</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="http://localhost:8083/paper/item?page=${previousPage}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="http://localhost:8083/paper/item?page=${nextPage}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <form action="http://localhost:8083/paper/item" method="get">
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
<div class="mask"></div>
<div class="itemDiv">
    <p align="right" id="itemDivClose" style="font-size: 50px;cursor:pointer ">X</p>
    <table class="table">
        <thead>
        <tr>
            <th>题目</th>
            <th>选项</th>

        </tr>
        </thead>
        <tbody class="item">

        </tbody>
    </table>
</div>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
$(function(){
    function funShowDivCenter() {
        var top = ($(window).height() -  $(".mask").height()) / 2;
        var left = ($(window).width() -  $(".mask").width()) / 2;
        var scrollTop = $(document).scrollTop();
        var scrollLeft = $(document).scrollLeft();
        $(".mask").css({ position: 'absolute', 'top': top + scrollTop, left: left + scrollLeft }).toggle(500);
    }
    function funShowDivCenter1() {
        var top = ($(window).height() -   $(".itemDiv").height()) / 2;
        var left = ($(window).width() -   $(".itemDiv").width()) / 2;
        var scrollTop = $(document).scrollTop();
        var scrollLeft = $(document).scrollLeft();
        $(".itemDiv").css({ position: 'absolute', 'top': top + scrollTop, left: left + scrollLeft }).toggle();
    }
    $(document).on("click","#itemDivClose",function(){
        funShowDivCenter()
        funShowDivCenter1()
    })
    $(document).on("click",".questionItem",function(){
        var id
        var html=""
        id = $(this).attr("id")
        var nodeName = ".item"+id
        var divName = ".div"+id;
        var that = $(this)
        console.log(id)
        $.ajax({
            url:"http://localhost:8083/paper/questionItem",
            data:{
                "id":id,
            },
            dataType:"json",
            type:"GET",
            success:function (res) {
                console.log(res)
                if (res.status==200){
                    html = ""

                    for (var i = 0;i < res.data.length;i++){
                        html += "<tr>"
                        html+="<td>"+res.data[i].selectQuestion.title+"</td>"
                        html+= "<td>"
                        for (var j = 0;j<res.data[i].selectQuestion.itemList.length;j++){
                            html+=res.data[i].selectQuestion.itemList[j].content
                            html+="<br>"
                        }
                        html+= "</td>"
                        html += "</tr>"
                    }

                    $(".item").append(html)
                    funShowDivCenter()
                   funShowDivCenter1()
                }
            }
        })
    })
})
</script>
</body>
</html>