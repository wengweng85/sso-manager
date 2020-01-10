<%@ page language="java" contentType="text/html; charset=gbk"  pageEncoding="gbk"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>请勿重复提交数据</title>
       <link href="<%=path%>/resource/js/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path%>/resource/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path%>/resource/css/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h2>请勿重复提交数据</h2>

        <div class="error-desc">
                                        系统检测到重复提交数据、请确认
            <!-- 
            <br/>您可以返回主页看看
            <br/><a href="<c:url value='/'/>" class="btn btn-primary m-t">主页</a>
            -->
        </div>
    </div>
     <script src="<%=path%>/webjars/js/jQuery/jquery-2.0.0.min.js"></script>
     <script src="<%=path%>/webjars/js/bootstrap.min.js"></script>
</body>
</html>



