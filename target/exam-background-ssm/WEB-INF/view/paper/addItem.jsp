<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/23
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
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
    <title>添加选择题</title>
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
        <h3><i class="fa fa-angle-right"></i> 添加选择题</h3>

        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
            <div class="col-lg-12">
                <div class="form-panel">
                    <h4 class="mb"><i class="fa fa-angle-right"></i> 添加选择题</h4>
                    <form id="itemForm" class="form-horizontal style-form" method="post" action="/paper/itemDetailDo">
                        <input type="hidden" name="itemId" />
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">科目</label>
                            <div class="col-sm-10">
                                <input  type="text" name="subject"  class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">类型</label>
                                <input name="type" value="单" type="radio" class="typeRadio" /> 单选
                                <input name="type" value="多" type="radio" class="typeRadio" /> 多选
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">题目</label>
                            <div class="col-sm-10">
                                <textarea name="title" class="form-control round-form" rows=5></textarea>
                            </div>
                        </div>
                        <div class="row mt" id="selecItem">
                            <div class="col-lg-12">
                                <div class="form-panel">
                                    <h4 class="mb"><i class="fa fa-angle-right"></i> 选项设置</h4>

                                        <div class="radio" id="selectItem">



                                        </div>

                                </div>
                            </div>
                        </div>
                        <input type="submit" value="提交">
                    </form>
                </div>
            </div>
        </div>
    </section>
</section>
</section>
<script type="text/javascript">

    $(document).ready(function(){
        var flag = true
        $("input[name=type]").each(function(){
            $(this).click(function(){

                var discount = $(this).val();
                $("#selecItem").show(1000);
                if(discount=="单"){
                    var htmlText = "<label>"
                    htmlText += "<input type='radio' name='isanswer' >"
                    htmlText += " 是否是答案"
                    htmlText += "<input type='text' name='content' class='form-control round-form'/>"
                    htmlText += "</label>"
                    if (flag) {
                        $("#selectItem").append(htmlText)
                        htmlText = ""
                        flag = false
                    }else{
                        $("#selectItem").children().remove();
                        flag = true
                }
                }else if (discount=="多"){

                    var htmlText = "<label>"
                    htmlText += "<input type='checkbox' name='isanswer' >"
                    htmlText += " 是否是答案"
                    htmlText += "<input type='text' name='content' class='form-control round-form'/>"
                    htmlText += "</label>"
                    if (flag) {
                        $("#selectItem").append(htmlText)
                        htmlText = ""
                        flag = false
                    }else{
                        $("#selectItem").children().remove();
                        flag = true
                    }
                }

            });
        });
    });

</script>
</body>
</html>
