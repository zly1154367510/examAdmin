<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/2
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>


<h1 id="message">${message}</h1>
<script type="text/javascript">
    alert(document.getElementById("message").innerHTML)
    history.back(-1)
</script>
</body>
</html>
