<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>O Panadão - ${title}</title>

    <link href="${css}/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="${css}/slate-theme.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${css}/modern-business.css" rel="stylesheet">
    <%--DataTable--%>
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>
</head>

<body>
<div class="wrapper">
    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="${contextRoot}/home">O Panadão</a>
        </div>
    </nav>


    <!-- Page Content -->
    <div class="content">
        <div class="container">
            <div class="coll-xs-12">
                <div class="jumbotron">
                    <h1>${errorTitle}</h1>
                    <hr/>
                    <blockquote>
                        ${errorDescription}
                    </blockquote>
                </div>
            </div>
        </div>
    </div>


    <!-- Footer -->
    <%@ include file="shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>

