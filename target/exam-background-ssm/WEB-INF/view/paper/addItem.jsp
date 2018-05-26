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
                    <form id="itemForm" class="form-horizontal style-form" method="post" action="/paper/addItemDo">
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
                        <div class="row mt" id="selecItem">
                            <div class="col-lg-12">
                                <div class="form-panel">
                                    <h4 class="mb"><i class="fa fa-angle-right"></i> 题目选择</h4>
                                    <div id="selectItem">
                                    </div>
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination">
                                            <li>
                                                <a aria-label="Next" id="next">
                                                    <span aria-hidden="true">加载更多</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                        <p id="checkedLength" style="font-size:20%" >

                        </p>
                        <input style="zoom: 150%;" type="submit" value="提交" class='btn-default'>

                    </form>
                </div>
            </div>
        </div>
    </section>
</section>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
    $(function(){
        var checkedLen = 0
        page = 1
        var html = ""
        var subject
        $(document).on("click",".itemCheck",function(){
            alert("我是check")
            if($(this).prop("checked")){
                checkedLen += 1
            }else{
                checkedLen -=1
            }
            $("#checkedLength").text("已选中"+checkedLen+"个答案")
        })

        $("input[name=subject]").blur(function(){

          subject = $(this).val();
          //  console.log(subject)
            $.ajax({
                url:"http://localhost:8083/paper/questionItemBySubject",
                data:{
                    "subject":subject
                },
                dataType:"json",
                type:"GET",
                success:function(res){
                    console.log(res)
                    if(res.status==200){
                        for (var i = 0;i<res.data.length;i++){
                            html += "<input style='zoom:300%;' type='checkbox' name='questionItemId' class='itemCheck' value="+res.data[i].id+" /><br>"
                            html += "<h2>"+res.data[i].title+"</h2>"
                            for (var j = 0;j<res.data[i].itemList.length;j++){
                                html +="<br>"
                                html += res.data[i].itemList[j].content

                            }
                            html += "<hr>"
                        }
                       // console.log(html)
                        $("#selectItem").append(html)
                        html = ""
                        $("#selecItem").show(500)

                    }
                }
            })
        })

//        $("#previous").click(function(){
//            if (page>1){
//                page+=1
//                $("#selecItem").hide(500)
//                //  console.log(subject)
//                $.ajax({
//                    url:"http://localhost:8083/paper/questionItemBySubject",
//                    data:{
//                        "subject":subject,
//                        "page":page
//                    },
//                    dataType:"json",
//                    type:"GET",
//                    success:function(res){
//                        console.log(res)
//                        if(res.status==200){
//                            for (var i = 0;i<res.data.length;i++){
//                                html += "<input type='checkbox' name='questionItemId' value="+res.data[i].id+" /><br>"
//                                html += "<h2>"+res.data[i].title+"</h2>"
//                                for (var j = 0;j<res.data[i].itemList.length;j++){
//                                    html +="<br>"
//                                    html += res.data[i].itemList[j].content
//
//                                }
//                                html += "<hr>"
//                            }
//                            //console.log(html)
//                            $("#selectItem").empty();
//                            $("#selectItem").append(html)
//                            html = ""
//                            $("#selecItem").show(1000)
//
//                        }
//                    }
//                })
//            }else{
//                alert("已经是第一页了")
//            }
//        })

        $("#next").click(function(){
            page+=1


            //  console.log(subject)
            $.ajax({
                url:"http://localhost:8083/paper/questionItemBySubject",
                data:{
                    "subject":subject,
                    "page":page
                },
                dataType:"json",
                type:"GET",
                success:function(res){
                    console.log(res)
                    if(res.status==200){
                        for (var i = 0;i<res.data.length;i++){
                            html += "<input style='zoom:300%;' type='checkbox' name='questionItemId' class='itemCheck' value="+res.data[i].id+" /><br>"
                            html += "<h2>"+res.data[i].title+"</h2>"
                            for (var j = 0;j<res.data[i].itemList.length;j++){
                                html +="<br>"
                                html += "<h3>"+res.data[i].itemList[j].content+"</h3>"

                            }
                            html += "<hr>"
                        }
                       // console.log(html)
                        $("#selectItem").append(html)
                        html = ""
                        $("#selecItem").show(1000)

                    }
                }
            })
        })
    })
</script>
</body>
</html>