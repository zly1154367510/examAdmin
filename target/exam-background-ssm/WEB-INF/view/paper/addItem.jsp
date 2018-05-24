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
                    <form id="itemForm" class="form-horizontal style-form" method="post" action="/paper/addItemDo">
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
                        <input type="submit" value="提交" class='btn-default'>
                    </form>
                </div>
            </div>
        </div>
    </section>
</section>
</section>
<script type="text/javascript">
    //多选下标
    var i = 0
    //单选下标
    var j = 0
    $(document).ready(function(){
        $("body").on('click',"#addMultinomialAnswer",function(){
            i+=1
            var htmlText = "<label>"
            htmlText += "<input type='checkbox' name='isanswer' class='isanswer' value='"+i+"'>"
            htmlText += " 是否是答案"
            htmlText += "<input type='text' name='content' class='form-control round-form'/>"
            htmlText += "</label>"
            $("#selectItem").append(htmlText)
        })
        $("body").on('click',"#addIndividualAnswer",function(){
            j+=1
            var htmlText = "<label>"
            htmlText += "<input type='radio' name='isanswer' class='isanswer' value='"+j+"'>"
            htmlText += " 是否是答案"
            htmlText += "<input type='text' name='content' class='form-control round-form'/>"
            htmlText += "</label>"
            $("#selectItem").append(htmlText)
        })
//        $("body").on('click','.isanswer',function(){
//            console.log("hahaha")
//            console.log(this.val())
//            if (this.val()==undefined){
//
//                this.val(this.next().val())
//            }
//            console.log(this.val())
//        })
        var flag = true
        var flag1 = true
        $("input[name=type]").each(function(){
            $(this).click(function(){

                var discount = $(this).val();
                $("#selecItem").show(1000);
                if(discount=="单"){
                    var addText = "<input type='button' id='addIndividualAnswer' value='添加答案' class='btn-default'></input>"
                    var htmlText = "<label>"
                    htmlText += "<input type='radio' name='isanswer' class='isanswer' value='0'>"
                    htmlText += " 是否是答案"
                    htmlText += "<input type='text' name='content' class='form-control round-form'/>"
                    htmlText += "</label>"
                    //第一次点击
                    if(flag){
                        if(!flag1){
                            $("#selectItem").children().remove();
                        }
                        addText += htmlText
                        $("#selectItem").append(addText)
                        j = 0
                        addText = ""
                        flag = false
                        flag1 = true
                    }
                }else if (discount=="多"){

                    var addText = "<input type='button' id='addMultinomialAnswer' value='添加答案' class='btn-default'></input>"
                    var htmlText = "<label>"
                    htmlText += "<input type='checkbox' name='isanswer' class='isanswer' value='0'>"
                    htmlText += " 是否是答案"
                    htmlText += "<input type='text' name='content' class='form-control round-form'/>"
                    htmlText += "</label>"
                    if(flag1){
                        if(!flag){
                            $("#selectItem").children().remove();
                        }
                        addText += htmlText
                        i = 0
                        $("#selectItem").append(addText)
                        addText = ""
                        flag = true
                        flag1 = false

                    }
                }

            });
        });
    });

</script>
</body>
</html>
